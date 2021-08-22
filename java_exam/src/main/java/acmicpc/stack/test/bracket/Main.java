package acmicpc.stack.test.bracket;

import java.io.*;
import java.util.Stack;

/**
 * 괄호
 * https://www.acmicpc.net/problem/9012
 * 올바른 괄호 문자 () Valid PS
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String size = br.readLine();
        int n = Integer.parseInt(size);
        Stack<Character> stack = new Stack<>();
        boolean vps = true;

        while(n-- > 0) {
            String str = br.readLine();
            for(char ch : str.toCharArray()) {
                if(ch == '(') {
                    stack.push(ch);
                }
                else if(ch == ')') {
                    if(!stack.isEmpty())
                        stack.pop();
                    else {
                        vps = false;
                    }
                }
            }

            if(stack.isEmpty() && vps) {
                bw.write("YES\n");
            } else {
                while(!stack.isEmpty()) {
                    stack.pop();
                }
                vps = true;
                bw.write("NO\n");
            }
        }
        bw.flush();
    }
}
