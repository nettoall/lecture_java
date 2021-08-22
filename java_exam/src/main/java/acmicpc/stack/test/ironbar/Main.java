package acmicpc.stack.test.ironbar;

import java.io.*;
import java.util.Stack;

/**
 * 쇠막대
 * https://www.acmicpc.net/problem/10799
 * 레이저는 인접한 () 의 쌍
 * 쇠막대기는 왼쪽끝은 (, 오른쪽 끝은 ). 인접하지 않음.
 * () (((()())(())()))(())
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int i = 0;

        for(char ch : str.toCharArray()) {
            i++;
            if(ch == '(') {
                stack.push(i);
            } else if(ch == ')'){
                if(i - stack.peek().intValue() == 1) {
                    stack.pop();
                    sum += stack.size();
                } else {
                    stack.pop();
                    sum += 1;
                }
            }
        }
//        bw.write(sum);
//        bw.flush();
        System.out.println(sum);
    }
}
