package algorithm.basic;

import java.util.Scanner;

/**
 * 가우스의 덧셈 공식 구현
 * 1 - 100 처럼 10단위로만 유효함. 1 - 15, 1 - 7 일 경우 계산이 맞지 않음.
 */
public class GauceFor {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("시작값을 입력하세요");
        System.out.print("시작값 : ");
        int min = stdIn.nextInt();
        System.out.println("종료값을 입력하세요");
        System.out.print("종료값  : ");
        int max = stdIn.nextInt();

        int sum = (min + max) * (max /2);

        System.out.println("시작값 " + min +" 부터 종료값 " + max + "까지의 합은 : " + sum);

        int verify = 0;
        for(int i = min; i <= max; i++){
            verify += i;
        }

        System.out.println("검증값 : " + verify);
    }
}
