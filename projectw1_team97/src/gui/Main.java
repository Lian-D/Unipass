package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        StackPane pane = new StackPane();
        primaryStage.setTitle("UNIPASS: password storage");
        primaryStage.setScene(new Scene(root, 500, 275));

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
