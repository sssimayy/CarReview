
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
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class SignUpController implements Initializable {
    
    @FXML
    private TextField usernameField;

    @FXML
    private TextField locationField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private RadioButton female;

    @FXML
    private Button login;

    @FXML
    private Button signUp;

    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup gender;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       handler= new DBHandler();
    }  
    
    @FXML
    void signUpButton(ActionEvent event) {
      
        //Saving Data
        String insert= "INSERT INTO users(names,password,gender,location)"
                +" VALUES (?,?,?,?)";
        try {
            connection= handler.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        try {
            pst=connection.prepareStatement(insert);
            pst.setString(1,usernameField.getText());
            pst.setString(2,passwordField.getText());
            pst.setString(3,getGender());
            pst.setString(4,locationField.getText());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
      
    }

    @FXML
    void loginButton(ActionEvent e) throws IOException {
        Parent prnt=FXMLLoader.load(getClass().getResource("/car/FXML/LoginMain.fxml")); 
        Scene scene = new Scene(prnt);    
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow(); 
        window.setScene(scene);
        window.show();
    }
    public String getGender(){
        String gen="";
        
        if(male.isSelected()){
            gen="Male";
            
        }
        else if(female.isSelected()){
            gen="Female";
        }
            return gen;
    }
  
}
