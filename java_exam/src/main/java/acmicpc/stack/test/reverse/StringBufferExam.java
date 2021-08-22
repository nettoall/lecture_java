package acmicpc.stack.test.reverse;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 단어 뒤집기
 * https://www.acmicpc.net/problem/9093
 */
public class StringBufferExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb;
        int tc = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<tc;i++) {
            String sr="";
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            while(st.hasMoreTokens()) {
                sb=new StringBuffer(st.nextToken());
                sr+=sb.reverse()+" ";
            }
            System.out.println(sr.trim());
        }
    }
}
