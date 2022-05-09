//package com.nettoall.javafx.total.model;
//
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleStringProperty;
//
//public class Student {
//    private SimpleStringProperty name;
//    private SimpleIntegerProperty scoreOfKor;
//    private SimpleIntegerProperty scoreOfMath;
//    private SimpleIntegerProperty scoreOfEng;
//
//    public Student(){
//        this.name = new SimpleStringProperty();
//        this.scoreOfKor = new SimpleIntegerProperty();
//        this.scoreOfMath = new SimpleIntegerProperty();
//        this.scoreOfEng = new SimpleIntegerProperty();
//    }
//
//    public Student(String name, int scoreOfKor, int scoreOfMath, int scoreOfEng){
//        this.name = new SimpleStringProperty(name);
//        this.scoreOfKor = new SimpleIntegerProperty(scoreOfKor);
//        this.scoreOfMath = new SimpleIntegerProperty(scoreOfMath);
//        this.scoreOfEng = new SimpleIntegerProperty(scoreOfEng);
//    }
//
//    public String getName(){return name.get();}
//
//    public void setName(String name){ this.name.set(name);}
//
//    public int getScoreOfKor(){return scoreOfKor.get(); }
//
//    public void setScoreOfKor(int scoreOfKor){this.scoreOfKor.set(scoreOfKor);}
//
//    public int getScoreOfMath(){return scoreOfMath.get();}
//
//    public void setScoreOfMath(int scoreOfMath){this.scoreOfMath.set(scoreOfMath);}
//
//    public int getScoreOfEng() { return scoreOfEng.get();}
//
//    public void setScoreOfEng(int scoreOfEng){this.scoreOfEng.set(scoreOfEng);}
//}
