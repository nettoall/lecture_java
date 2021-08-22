package acmicpc.io.ex11022;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        if(count > 0){
            int[][] param = new int[count][2];
            for(int i = 0; i < count; i++) {
               param[i][0] = scanner.nextInt();
               param[i][1] = scanner.nextInt();
            }

            for(int i = 0; i < count; i++) {
                System.out.println("Case #"+ (i + 1) + ": " + param[i][0] + " + " + param[i][1] + " = " + (param[i][0]+param[i][1]));
            }
        }
    }
}
