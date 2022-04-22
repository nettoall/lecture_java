package algorithm.simul;

import java.util.Scanner;

/**
 * 8 X 8 좌표 평면에서 특정한 한 칸에 나이트가 서 있음.
 * 나이트는 말을 타고 있기 때문에 이동을 할 때에는 L자 형태로만 이동할 수 있으면 평면밖으로 나갈 수 없음.
 * 나이트는 다음과 같이 이동
 * - 수평으로 두칸 이동 후 수직으로 한 칸 이동
 * - 수직으로 두칸 이동 후 수평으로 한 칸 이동
 * 행위치는 1부터 8 로 표시
 * 열 위치는 a 부터 h로 표현
 *
 * 입력조건 : 첫째 줄에 8 X 8 좌표 평면상에서 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자열이 입력
 * 출력 조건 : 첫째 줄에 나이트가 이동할 수 있는 경우의 수를 출력
 */
public class SimulExam07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String position = sc.nextLine();
        int row = position.charAt(1) - '0';
        int col = position.charAt(0) - 'a' + 1;  // 숫자로 변환함
//        char[] posChar = position.toCharArray();
//        int x = posChar[0];
//        char y = posChar[1];
        // 방향 벡터 정의
        int[][] steps = {{-2,-1},{-2,1},{2, -1},{2,1},{-1,-2},{1, -2},{-1,2},{1,2}};

        int count = 0;
        int nx = -1;
        int ny = -1;
        for(int i = 0; i < steps.length; i++){
            nx = row + steps[i][0];
            ny = col + steps[i][1];
            if(nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8){
                count += 1;
            }
        }
        System.out.println("count : " + count);
    }
}
