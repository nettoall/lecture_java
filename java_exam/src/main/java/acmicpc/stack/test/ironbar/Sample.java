package acmicpc.stack.test.ironbar;

import java.util.Scanner;
import java.util.Stack;

public class Sample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        int n = str.length();
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for(int i = 0; i < n; i++ ){
            char c = str.charAt(i);
            if( c == '(') {
                stack.push(i);
            } else {
                if(stack.peek() + 1 == i) {
                   stack.pop();
                   ans += stack.size();
                } else {
                    stack.pop();
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
