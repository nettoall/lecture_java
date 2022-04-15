package algorithm.basic;

import java.util.Scanner;

/**
 * 시작값과 연속된 수의 종료값을 받아 합을 구하는 문제
 */
public class FromToSum {
    static int sumOf(int a, int b){
        int sum = 0;

        for(int i = a; i <= b; i++){
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("시작값 입력 : ");
        int a = stdIn.nextInt();
        System.out.print("종료값 입력 : " );
        int b = stdIn.nextInt();

        System.out.println("합계는 : " + sumOf(a,b));
    }
}
