package algorithm.basic;

import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n ;
        System.out.print("피라미드 밑변 수는 : " );
        n = stdIn.nextInt();
        StarPyra(n);

    }

    static void StarPyramid(int n ){
        int loop = (n - 1) * 2 + 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= (loop/2) - i + 1; j++){ // 전체적인 띄어써야할 공간을 계산하기 않아도 됨. 그냥 필요한 공백만 처리하면 알아서
                System.out.print(' ');
            }
            for(int j = 1; j <= (i - 1) * 2 + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void StarPyra(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < n-i+1; j++){ // n - i + 1
                System.out.print(' ');
            }
            for(int j = 1; j <= (i -1) * 2 + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
