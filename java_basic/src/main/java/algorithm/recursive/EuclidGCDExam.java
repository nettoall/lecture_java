package algorithm.recursive;

import java.util.Scanner;

/**
 * 최대 공약수를 구하는 유클리드 호제법
 * 1. 각 변의 길이가 22와 8인 직사각형을 길이가 8인 정사각형으로 분할(정사각형으로 분할되지 않는 크기까지)
 * 2. 각 변의 길이 8, 6일 직사각형을 다시 길이가 6인 정사각형으로 분할
 * 3. 정사각형으로 구성이 될때까지 반복 - 이때의 변 길이가 최대 공약수
 * 비재귀로 풀기
 */
public class EuclidGCDExam {
    static int gcd(int x, int y){
        while(y != 0){
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대 공약수를 구합니다. ");

        System.out.print("정수를 입력하세요:");
        int x = stdIn.nextInt();
        System.out.print("정수를 입력하세요:");
        int y = stdIn.nextInt();
        System.out.println("최대 공약수는 " + gcd(x,y) + "입니다.");
    }
}
