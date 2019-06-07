
package car.FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class VolvoController implements Initializable {

   @FXML
    private Button backBtn;
   @FXML
   private AnchorPane CarInfo;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

  @FXML
    void backButton(ActionEvent event) {

         HOMEController.getInstance().createPage(CarInfo,"/car/FXML/Volvo.fxml");
    }
    
    
}
