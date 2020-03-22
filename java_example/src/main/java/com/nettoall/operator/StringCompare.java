package com.nettoall.operator;

public class StringCompare {
    public static void main(String[] args){
        String a = "어벤져스";  // a, b는 같은 번지를 참조하기 때문에 비교시 true가 나온다.
        String b = "어벤져스";
        String c = new String("어벤져스"); // 새로운 String 객체를 생성하고 a,b와 같은 문자열을 넣었지만 다르다고 나옴.

        System.out.println("a & b : " + (a == b));
        System.out.println("a & c : " + (a == c));
        System.out.println("a equals c : " + (a.equals(c)));

    }
}
