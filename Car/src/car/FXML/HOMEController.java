
package car.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class HOMEController implements Initializable {

    @FXML
    private Button Benz;

    @FXML
    private Button Ferrari;

    @FXML
    private Button Maserati;

    @FXML
    private Button Volvo;
 
    @FXML
    private AnchorPane homeAnchor;
    
    AnchorPane home;
    
    @FXML
    private Text welcome;

    @FXML
    private Button exit;
    
    @FXML
    private Button LogOut;  
    
    @FXML
    private final  ImageView imMas= new ImageView("file:C:\\Users\\asus-pc\\Documents\\NetBeansProjects\\Car\\images\\indir.jpg");

    @FXML
    private ImageView imVolvo;
    
    @FXML
    private ImageView imMerc;

    @FXML
    private ImageView imFerrari;
    
    private static HOMEController instance;
    
    public HOMEController(){
        instance=this;
        
    }
    public static HOMEController getInstance(){
        
        return instance;    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        setUsername(LoginMainController.getInstance().usernameField());
    }   
   
    public void setUsername(String user){
        
        this.welcome.setText("Welcome, "+user);
    }
    
    @FXML
    void logOutButton(ActionEvent event) throws IOException {
        
            Parent prnt=FXMLLoader.load(getClass().getResource("/car/FXML/LoginMain.fxml")); 
            Scene scene = new Scene(prnt);    
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            window.setScene(scene);
            window.show();
    }

    @FXML
    void exitButton(ActionEvent event) {
        Platform.exit();
    }
     @FXML
    void volvoBtn(ActionEvent event) {
        HOMEController.getInstance().createPage(homeAnchor,"/car/FXML/Volvo.fxml");
        
    }

    @FXML
    void MaseBtn(ActionEvent event) {
         HOMEController.getInstance().createPage(homeAnchor,"/car/FXML/Maserati.fxml");
    }

    @FXML
    void benzBtn(ActionEvent event) {
         HOMEController.getInstance().createPage(homeAnchor,"/car/FXML/Mercedes.fxml");

    }

    @FXML
    void FerrariBtn(ActionEvent event) {
         HOMEController.getInstance().createPage(homeAnchor,"/car/FXML/Ferrari.fxml");

    }
    
    public void createPage(AnchorPane homeAnchor,String loc ){
        try {
            homeAnchor= FXMLLoader.load(getClass().getResource(loc));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         
        
        
    }
}
