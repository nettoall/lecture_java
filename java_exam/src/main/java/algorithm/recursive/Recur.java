package algorithm.recursive;

import java.util.Scanner;

/**
 * 재귀 알고리즘
 * 재귀 알고리즘을 분석하는 방법에는 상향식 분석과 하향식 분석이 있음
 *
 */
public class Recur {
    static void recur(int n){
        if(n > 0){
            recur(n-1);
            System.out.println(n);
            recur(n-2);
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요.: ");
        int x = stdIn.nextInt();

        recur(x);
    }
}
