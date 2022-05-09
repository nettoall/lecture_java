//package com.nettoall.javafx.ex02.event.button;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class RootController implements Initializable {
//    @FXML private Button button1;
//    @FXML private Button button2;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        button1.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("버튼1 클릭");
//            }
//        });
//
//        button2.setOnAction(event -> System.out.println("버튼2 클릭"));
//
//    }
//}
