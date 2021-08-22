package acmicpc.stack.test.reverse2;

import java.io.*;
import java.util.Stack;

public class Main {
    static void print(BufferedWriter bw, Stack<Character> stack) throws IOException {
        while(!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        boolean tag = false;
        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()) {
            if(ch == '<') {
                print(bw, stack);
                tag = true;
                bw.write(ch);
            } else if(ch == '>') {
                tag = false;
                bw.write(ch);
            } else if(tag) {
                bw.write(ch);
            } else {
                if(ch == ' ') {
                    print(bw, stack);
                    bw.write(ch);
                } else {
                    stack.push(ch);
                }
            }
        }
        print(bw, stack);
        bw.write("\n");
        bw.flush();
    }

}
