
package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Car extends Application {
    @Override
    public void start(Stage stage){
        try{
            /*Parent root= FXMLLoader.load(getClass().getResource("/car/FXML/LoginMain.fxml"));
            Scene scene= new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);*/
        Parent root= FXMLLoader.load(getClass().getResource("/car/FXML/FirstPage.fxml"));
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
            
        }catch(Exception e){
            e.printStackTrace();
        }
  
      
    }

   
    public static void main(String[] args) {
        launch(args);
          System.out.println("dgdkg");
    }
    
}
