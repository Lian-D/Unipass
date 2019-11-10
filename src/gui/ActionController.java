package gui;

import accountType.Account;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.FileReader;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;

public class ActionController implements Initializable{
    @FXML
    public JFXTextField addHost;

    @FXML
    public JFXPasswordField addUser;

    @FXML
    public JFXPasswordField addPass;

    @FXML
    public JFXTextField displayHost;

    @FXML
    public JFXTextField displayUser;

    @FXML
    public JFXTextField displayPass;



    @FXML
    public JFXListView<String> List;
    public Map<String, Account> map;



    private void loadData() throws IOException {
        this.map = FileReader.createFile();
        for (String key: map.keySet()){
            List.getItems().add(key);
        }
    }
    @FXML
    public void addAccount(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String host = addHost.getText().toString();
        String user = addUser.getText().toString();
        String password = addPass.getText().toString();

        Account acc = new Account(host,user,password);
        FileReader.addnewaccountdata(acc);
        alert.setHeaderText("Account Has Been Saved");
        alert.setContentText("The account has been saved, please relaunch the client. Unipass will now terminate");
        alert.showAndWait();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    private void onClickChangeText(){
        displayHost.setText(List.getSelectionModel().getSelectedItem());
        displayUser.setText(map.get(List.getSelectionModel().getSelectedItem()).getUser());
        displayPass.setText(map.get(List.getSelectionModel().getSelectedItem()).getPass());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List.setOnMouseClicked(event ->
                onClickChangeText());
        try {
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
