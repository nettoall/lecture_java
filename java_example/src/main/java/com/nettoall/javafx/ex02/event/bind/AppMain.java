package com.nettoall.javafx.ex02.event.bind;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("root.fxml"));

        root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bind Example");
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
