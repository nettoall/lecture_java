package com.nettoall.operator;

public class LogicalOperator {
    public static void main(String[] args){
        int charCode = 'A';
        // & 는 앞뒤 모두 평가해서 산출결과를 낸다
        if((charCode >= 65) & (charCode <= 90)){
            System.out.println("대문자 이군요");
        }
        // && 은 앞에가 false이면 뒤 연산식을 평가하지 않고  false를 산출
        if((charCode >= 97) && (charCode <= 122)){
            System.out.println("소문자 이군요");
        }


        if(!(charCode < 48) && !(charCode > 57)){
            System.out.println("0-9 숫자이군요");
        }

        int value = 6;

        // |과 ||도 앞에서 설명한 &, &&와 같이 평가한다.
        if((value%2 == 0) | (value%3 == 0)){
            System.out.println("2 또는 3의 배수이군요");
        }

        if((value%2 == 0) || (value%3 == 0)){
            System.out.println("2 또는 3의 배수이군요");
        }
    }
}
