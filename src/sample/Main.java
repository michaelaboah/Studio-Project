package sample;
//
//import com.aquafx_project.AquaFx;
//import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.GUI.Controller2;

public class Main extends Application {

    Stage primaryStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{					// Works as of |  6/26/2021
        Parent root = FXMLLoader.load(getClass().getResource("FXMLFiles/Test.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("sample/StyleSheets/old.css");

        primaryStage.setTitle("Apollo's Library");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);


//        System.out.println("test");
    }
}
