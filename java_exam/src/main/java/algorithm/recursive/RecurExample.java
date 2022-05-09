package algorithm.recursive;

import java.util.Scanner;

/**
 * 재귀 알고리즘
 * 다음 재귀 알고리즘은 비재귀 알고리즘으로 변환
 *
 */
public class RecurExample {
    static void recur(int n){
        if(n > 0){
            recur(n-1);
            recur(n-2);
            System.out.println(n);
        }
    }

    static void noRecur(int n){
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;

        while(true){
            if(n > 0){
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if(sw == 0)
                    n = n - 1;
                else if(sw == 1){
                    n = n - 2;
                    sw = 0;
                }
                continue;
            }
            do{
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;

                if(sw == 2){
                    System.out.println(n);
                    if(ptr < 0)
                        return;
                }
            }while(sw == 2);
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요.: ");
        int x = stdIn.nextInt();

        recur(x);
    }
}
