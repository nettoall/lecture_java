package com.nettoall.javafx.total;

import com.nettoall.javafx.total.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private Button btnAdd;
    @FXML
    private Button btnGraph;
    @FXML private TableView<Student> tableView;

    //private Stage primaryStage;

    private ObservableList<Student> students;

   // public void setPrimaryStage(Stage primaryStaage){this.primaryStaage = primaryStaage;}



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        students = FXCollections.observableArrayList(
                new Student("홍길동", 40,60,80),
                new Student("김갑돌", 50,80,60),
                new Student("이순자", 60,70,90)
        );
        btnAdd.setOnAction(event -> handleBtnAdd(event));
        btnGraph.setOnAction(event -> handleBtnGraph(event));

        TableColumn tcName = tableView.getColumns().get(0);
        tcName.setCellFactory(new PropertyValueFactory("name"));
        tcName.setStyle("-fx-alignment: CENTER");

        TableColumn tcKor = tableView.getColumns().get(1);
        tcKor.setCellFactory(new PropertyValueFactory("scoreOfKor"));
        tcKor.setStyle("-fx-alignment: CENTER");

        TableColumn tcMath = tableView.getColumns().get(2);
        tcMath.setCellFactory(new PropertyValueFactory("scoreOfMath"));
        tcMath.setStyle("-fx-alignment: CENTER");

        TableColumn tcEng = tableView.getColumns().get(3);
        tcEng.setCellFactory(new PropertyValueFactory("scoreOfEng"));
        tcEng.setStyle("-fx-alignment: CENTER");

       // tableView.setItems(students);
/*
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() > 1){
                    Student student = tableView.getSelectionModel().selectedItemProperty().getValue();
                    handlePie(student);
                }
            }
        });*/
    }

    public void handleBtnAdd(ActionEvent event){
        Stage dialog = new Stage(StageStyle.UTILITY);
        dialog.initModality(Modality.WINDOW_MODAL);
        //또는 다은 방법으로 primaryStage 가져옴
        // dialog.initOwner(btnAdd.getScene().getWindow());
        dialog.initOwner(btnAdd.getScene().getWindow());
        dialog.setTitle("추가");
        Parent parent = null;
        try{
            parent = FXMLLoader.load(getClass().getResource("form.fxml"));
        }catch(Exception e){
            e.printStackTrace();
        }

        TextField nameField = (TextField)parent.lookup("#txtName");
        TextField korField = (TextField)parent.lookup("#txtKor");
        TextField mathField = (TextField)parent.lookup("#txtMath");
        TextField engField = (TextField)parent.lookup("#txtEng");
        Button btnSave = (Button)parent.lookup("#btnSave");
        Button btnCancel = (Button)parent.lookup("#btnCancel");

        btnSave.setOnAction(event1 -> {
            if(!nameField.equals("") && !korField.equals("") && !mathField.equals("") && !engField.equals("")){
                Student student = new Student(nameField.getText(),Integer.parseInt(korField.getText()), Integer.parseInt(mathField.getText()), Integer.parseInt(engField.getText()));
                students.add(student);
                dialog.close();
            }
        });

        btnCancel.setOnAction(event1 -> dialog.close());

        Scene scene = new Scene(parent);
        dialog.setScene(scene);
        dialog.setResizable(false);
        dialog.show();
    }

    public void handleBtnGraph(ActionEvent event){
        Stage dialog = new Stage(StageStyle.UTILITY);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(btnGraph.getScene().getWindow());
        dialog.setTitle("막대그래프");
        Parent parent = null;
        try{
            parent = FXMLLoader.load(getClass().getResource("batchart.fxml"));
        }catch(Exception e){
            e.printStackTrace();
        }

        Button btnClose = (Button)parent.lookup("#btnClose");
        btnClose.setOnAction(event1 -> dialog.close());
        BarChart barChart = (BarChart)parent.lookup("#barChart");

        ObservableList korList = FXCollections.observableArrayList();
        ObservableList mathList = FXCollections.observableArrayList();
        ObservableList engList = FXCollections.observableArrayList();

        XYChart.Data<String, Integer> korData = null;
        XYChart.Data<String, Integer> mathData = null;
        XYChart.Data<String, Integer> engData = null;

        for(int i = 0; i < students.size(); i++){
            Student student = students.get(i);
            korList.add(new XYChart.Data(student.getName(),student.getScoreOfKor()));
            mathList.add(new XYChart.Data(student.getName(),student.getScoreOfMath()));
            engList.add(new XYChart.Data(student.getName(),student.getScoreOfEng()));
        }

        XYChart.Series korSeries = new XYChart.Series();
        korSeries.setName("국어");
        korSeries.setData(korList);

        XYChart.Series mathSeries = new XYChart.Series();
        mathSeries.setName("수학");
        mathSeries.setData(mathList);

        XYChart.Series engSeries = new XYChart.Series();
        engSeries.setName("영어");
        engSeries.setData(engList);

        barChart.getData().add(korSeries);
        barChart.getData().add(mathSeries);
        barChart.getData().add(engSeries);

        Scene scene = new Scene(parent);
        dialog.setScene(scene);
        dialog.setResizable(false);
        dialog.show();
    }

    public void handlePie(Student student){
        Stage dialog = new Stage(StageStyle.UTILITY);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(btnAdd.getScene().getWindow());
        dialog.setTitle("파이그래프");
        Parent parent = null;
        try{
            parent = FXMLLoader.load(getClass().getResource("piechart.fxml"));
        }catch (Exception e){
            e.printStackTrace();
        }

        Button btnClose = (Button)parent.lookup("#btnClose");
        btnClose.setOnAction(event -> dialog.close());
        PieChart pieChart = (PieChart)parent.lookup("#pieChart");

        pieChart.setData(FXCollections.observableArrayList(
                new PieChart.Data("국어",student.getScoreOfKor()),
                new PieChart.Data("수학",student.getScoreOfMath()),
                new PieChart.Data("영어",student.getScoreOfEng())
        ));

        Scene scene = new Scene(parent);
        dialog.setScene(scene);
        dialog.setResizable(false);
        dialog.show();
    }

}
