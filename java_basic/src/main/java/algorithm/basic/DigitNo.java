package algorithm.basic;

import java.util.Scanner;

public class DigitNo {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int a;
        do{
            System.out.print("입력하세요 : ");
            a = stdIn.nextInt();
        }while(a <= 0);

        int no = 0;

        while(a > 0) {
            a /= 10;
            no++;
        }

        System.out.println("그 수는 " + no +"자리입니다.");


    }
}
