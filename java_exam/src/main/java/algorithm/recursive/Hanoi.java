package algorithm.recursive;

import java.util.Scanner;

/**
 * 해법은 제일 하위단을 제외하고 나머지를 그룹으로 처리하여 옮기면 됨
 */
public class Hanoi {
    static void move(int no, int x, int y){
        if(no > 1)
            move(no -1 , x, 6 - x - y); // 6 은 1기둥, 2기둥, 3기둥을 합한 값이며 6 - x - y는 중간 기둥을 의미

        System.out.println("원반[" + no + "]을 " + x +"기둥에서 " + y + "기둥으로 옮김");

        if(no > 1)
            move(no - 1, 6 - x - y, y);
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("정수를 입력하세요.: ");
        int n = stdIn.nextInt();

        move(n,1,3);
    }
}
