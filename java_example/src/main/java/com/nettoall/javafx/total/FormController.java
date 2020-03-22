package com.nettoall.javafx.total;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtKor;
    @FXML
    private TextField txtMath;
    @FXML
    private TextField txtEng;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnCancel.setOnAction(evnet -> handleBtnCancel(evnet));
    }

    public void handleBtnCancel(ActionEvent event){
        Platform.exit();
    }
}
