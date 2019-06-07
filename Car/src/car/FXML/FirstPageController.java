
package car.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class FirstPageController implements Initializable {

  @FXML AnchorPane holderPane;

  AnchorPane home;
    
    @FXML
    private Button myCars;

    @FXML
    private Button about;

    @FXML
    private Button homeBtn  ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createPage();
    }  
     
   
    private void setNode(Node node){
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
        
        FadeTransition ft= new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
    }
    private void createPage(){
        
      try {
          home = FXMLLoader.load(getClass().getResource("/car/FXML/HOME.fxml"));
          setNode(home);
      } catch (IOException ex) {
          ex.printStackTrace();
      }
    }
    
        
    
    @FXML
    void homeButton(ActionEvent event) {

    }

    @FXML
    void myCarsButton(ActionEvent event) {

    }

    @FXML
    void aboutButton(ActionEvent event) {

    }

    @FXML
    void contactUs(ActionEvent event) {

    }
}
