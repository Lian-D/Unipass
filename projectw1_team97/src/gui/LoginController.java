package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Unipass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    @FXML
    private JFXPasswordField passwordFieldLogin;

    @FXML
    private JFXButton submitLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void validate(ActionEvent event) throws IOException {
        String password = passwordFieldLogin.getText();
        Unipass unipass = new Unipass();

        if (unipass.passwordVerificiation(password)){
            System.out.println("Correct Password!");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Actions.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("UNIPASS: password storage");
            stage.setScene(new Scene(root1));
            stage.show();
        }
        else System.out.println("Incorrect");

    }
}
