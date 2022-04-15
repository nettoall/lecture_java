package algorithm.basic;


import java.util.Scanner;

/**
 * 입력받은 수만큼 *를 행,열로 출력
 */
public class Rectangle {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n ;
        System.out.println("사각형을 출력합니다.");
        System.out.print("단수 :" );
        n = stdIn.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print("*")   ;
            }
            System.out.println();
        }
    }
}
