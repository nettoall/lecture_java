package algorithm.basic;

import java.util.Scanner;

public class NumericPyramid {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n ;
        System.out.print("피라미드 밑변 수는 : " );
        n = stdIn.nextInt();
        numericPyra(n);

    }

    static void numericPyra(int n){
        int loop = (n - 1) * 2 + 1;
        int printnum = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= (loop/2) - i + 1; j++){
                System.out.print(' ');
            }
            for(int j = 1; j <= (i - 1) * 2 + 1; j++){
                System.out.print(i % 10);
            }
            System.out.println();
        }
    }

    static void npira(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i + 1; j++){
                System.out.print(' ');
            }
            for(int j = 1; j <= (i - 1) * 2 + 1; j++){
                System.out.print(i % 10);
            }
            System.out.println();
        }
    }
}
