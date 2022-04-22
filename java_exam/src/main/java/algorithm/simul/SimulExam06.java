package algorithm.simul;

import java.util.Scanner;

/**
 * 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성
 * 예로 N 이 1일 때 3이 하나라도 파함되어 있으므로 세어야 하는 시각
 * 00시 00분 03초
 * 00시 13분 30초
 *
 * 반면에 3이 포함되어 있지 않으므로 세면 안 되는 시각
 * 00시 02분 55초
 * 01시 27분 45초
 *
 * 입력조건 : 첫째줄에 정수 N  이 입력( 0 <= N <= 23)
 * 출력 조건 : 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 출력
 *
 * 해법 모든 경우의 수를 검색하여 처리 (완전 탐색 - Brute Forcing)
 */
public class SimulExam06 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int hour  = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i <= hour; i++) {
            for(int j = 0; j < 60; j++) {
                for(int k = 0; k < 60; k++) {
                    // 매 시각 안에 '3'이 포함되어 있다면 카운트 증가
                    if(check(i,j,k)) cnt++;
                }
            }
        }
        System.out.println("count : " + cnt);
    }

    public static boolean check(int h, int m, int s){
        if(h % 10 == 3 || m /10 ==3 || m % 10 == 3|| s/10  == 3|| s % 10 == 3)
            return true;
        return false;
    }
}
