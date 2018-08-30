package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.opencv.core.Core;

public class Main extends Application {

    static {
        System.loadLibrary("../opencv_3_3/build/java/x64/" + Core.NATIVE_LIBRARY_NAME);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Computer Vision");
        primaryStage.setScene(new Scene(root, 300, 1010));
        primaryStage.setResizable(false);
        primaryStage.setX(-7);
        primaryStage.setY(0);
        primaryStage.setOnCloseRequest(event -> {
            System.out.println("exit");
            System.exit(0);
        });
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
