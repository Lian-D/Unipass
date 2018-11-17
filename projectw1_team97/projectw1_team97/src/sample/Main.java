package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        StackPane pane = new StackPane();
        Text text = new Text("Please enter your set unipass password");
        primaryStage.setTitle("UNIPASS: password storage");
        primaryStage.setScene(new Scene(root, 500, 275));

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
