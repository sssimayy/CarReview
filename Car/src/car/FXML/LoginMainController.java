
package car.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import DBConnection.DBHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert.AlertType;


public class LoginMainController implements Initializable {

    
    @FXML
    private TextField usernameField;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox rememberMeField;

    @FXML
    private Button forgotButton;

    private DBHandler handler;
    private Connection connection;
    private java.sql.PreparedStatement pst;
    private static LoginMainController instance;
    
    public LoginMainController(){
        instance=this;
    }
    public static  LoginMainController getInstance(){
        return instance;
    }
    public String usernameField(){
        
        return usernameField.getText();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      handler =new DBHandler();
    }    
    
    
    
     @FXML
    void signUpButton(ActionEvent ev) throws IOException {
        Parent prnt=FXMLLoader.load(getClass().getResource("/car/FXML/SignUp.fxml")); 
        Scene scene = new Scene(prnt);    
        Stage window = (Stage)((Node)ev.getSource()).getScene().getWindow(); 
        window.setScene(scene);
        window.show();
    }

    @FXML
    void loginButton(ActionEvent event1) throws IOException, SQLException {

        //Retrieve data from database
        connection= handler.getConnection();
        String q1= "SELECT * FROM users where names? and password=?";
        try{
        pst=connection.prepareStatement(q1);
        pst.setString(1,usernameField.getText());
        pst.setString(2,passwordField.getText());
        ResultSet rs= pst.executeQuery();
        
        int count=0;
        while(rs.next()){
            
            count=count+1;
        }
        if(count==1)
        {
            Parent prnt=FXMLLoader.load(getClass().getResource("/car/FXML/HomePage.fxml")); 
            Scene scene = new Scene(prnt);    
            Stage window = (Stage)((Node)event1.getSource()).getScene().getWindow(); 
            window.setScene(scene);
            window.show();
        }
        else{   
            Alert alert= new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Username and password is not correct!");
            alert.show();
           
            
        }
        }catch(SQLException e1){
            e1.printStackTrace();
            
        }
        finally{
            connection.close();
        }
        
        
        Parent prnt=FXMLLoader.load(getClass().getResource("")); 
        Scene scene = new Scene(prnt);    
        Stage window = (Stage)((Node)event1.getSource()).getScene().getWindow(); 
        window.setScene(scene);
        window.show();
       
    }

    @FXML
    void forgotButton(ActionEvent event) {

    }
     
    
}
