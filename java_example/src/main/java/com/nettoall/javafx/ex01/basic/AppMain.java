//package com.nettoall.javafx.ex01.basic;
//
//import javafx.application.Application;
//import javafx.stage.Stage;
//
//import java.util.List;
//import java.util.Map;
//
//public class AppMain extends Application {
//    public AppMain(){
//        System.out.println(Thread.currentThread().getName() + " : AppMain() 호출");
//    }
//
//    @Override
//    public void init() throws Exception{
//        System.out.println(Thread.currentThread().getName() + ": init() 호출");
//        Parameters params = getParameters();
//        List<String> list = params.getRaw();
//        Map<String, String> map = params.getNamed();
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        System.out.println(Thread.currentThread().getName() + ": start() 호출");
//        primaryStage.show();
//    }
//
//    @Override
//    public void stop() throws Exception{
//        System.out.println(Thread.currentThread().getName() + ": Stop()호출");
//    }
//
//    public static void main(String[] args){
//        System.out.println(Thread.currentThread().getName() + ": main()호출");
//        launch(args);
//    }
//
//
//}
