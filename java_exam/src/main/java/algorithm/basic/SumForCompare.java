package algorithm.basic;

import java.util.Scanner;

public class SumForCompare {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int a,b;

        System.out.print("a의 값: ");
        a = stdIn.nextInt();
        while(true){
            System.out.print("b의 값 :");
            b = stdIn.nextInt();
            if( b > a)
                break;
            System.out.println("a보다 큰 값을 입력하세요");
        }

        int minus = 0;

        minus = b - a;

        System.out.println("b-a는 " + minus + " 입니다.");


    }
}
