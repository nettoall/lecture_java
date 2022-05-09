package algorithm.simul;

import java.util.Scanner;

public class SimulExam05 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine(); // 숫자 입력후 엔터 명령을 받도록 처리
        String plan = sc.nextLine();
        String[] planArr = plan.split(" ");

        int[][] testArr = new int[size][size];
        int posx = 1;
        int posy = 1;

        for(int i = 0; i < planArr.length; i++){
            if(planArr[i].equals("R")){
                if(posy< size){
                    posy += 1;
                }
            } else if(planArr[i].equals("L")) {
                if(posy >  1) {
                    posy -= 1;
                }

            }else if(planArr[i].equals("U")){
                if(posx > 1){
                    posx -= 1;
                }

            } else if(planArr[i].equals("D")) {
                if(posx < size){
                    posx += 1;
                }

            }
        }

        System.out.println("position " + posx +" " +  posy);
    }

    public static void main0(String[] args){
        Scanner sc = new Scanner(System.in);

        // N 입력받기
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1;

        // L, R, U, D 에 따른 이동 방향 벡터
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1,1, 0, 0};
        char[] moveTypes = {'L','R','U','D'};

        // 이동 게획을 하나씩 확인
        for (int i = 0; i < plans.length; i++){
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기
            int nx = -1, ny = -1;
            // moveTypes 개수 만큼
            for(int j = 0; j < 4; j++) {
                if(plan == moveTypes[j]){
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시
            if( nx < 1 || ny < 1 || nx > n || ny > n) continue;
            // 이동 수행
            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);
    }
}
