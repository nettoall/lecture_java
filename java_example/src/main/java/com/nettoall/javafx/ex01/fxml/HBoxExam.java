package com.nettoall.javafx.ex01.fxml;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxExam extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        root.setPrefHeight(150);
        root.setPrefWidth(350);
        root.setSpacing(10);

        root.setPadding(new Insets(10));

        TextField textField = new TextField();
        textField.setPrefWidth(200);

        Button button = new Button();
        button.setText("확인");

        ObservableList list = root.getChildren();
        list.add(textField);
        list.add(button);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("HBox Exam");
        primaryStage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}
