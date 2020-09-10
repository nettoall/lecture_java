package algorithm.basic;

import java.util.Scanner;

/**
 * 왼쪽 위 직각, 오른쪽 위 직각, 오른쪽 아래 직각
 */
public class Triangle {
    static void triangleLU(int n){
        /*
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

         */

        // n - i + 1 (공식)
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRB(int n){
        /*
        for(int i = 1; i <= n; i++){
            for(int j = n; j > i; j--){
                System.out.print(" ");
            }
            for(int k = 1; k <= i; k++){
                System.out.print("*");
            }
            System.out.println();
        }

         */
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - 1; j++){
                System.out.print(" ");
            }
            for(int k = 1; k <= i; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
    }

    static void triangleRU(int n){
        /*
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){ // j <= i - 1
                System.out.print(" ");
            }
            for(int j = n; j >= i; j--){ // j = 1; j < n -1 +1;
                System.out.print("*");
            }
            System.out.println();
        }

         */
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i - 1; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= n - i + 1; j++){ //n - i + 1
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n ;
        System.out.print("사격형의 수는 : ");
        n = stdIn.nextInt();

        triangleLU(n);
        triangleRB(n);
        triangleRU(n);
    }
}
