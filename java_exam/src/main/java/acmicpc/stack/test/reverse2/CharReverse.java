package acmicpc.stack.test.reverse2;

import java.io.*;
import java.util.Stack;

/**
 * 단어뒤집기 2
 * https://www.acmicpc.net/problem/17413
 */
public class CharReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean tag = false;

        Stack<Character> stack = new Stack<>();

        char[] input = br.readLine().toCharArray();

        for(int i = 0; i < input.length; i++){
            if(input[i] == '<') {
                print(bw,stack);
                bw.write(input[i]);
                tag = true;
            } else if (input[i] == '>') {
                bw.write(input[i]);
                tag = false;
            } else if(tag) {
                bw.write(input[i]);
            } else {
                if(input[i] == ' ') {
                    print(bw,stack);
                    bw.write(input[i]);
                } else {
                    stack.push(input[i]);
                }
            }
        }

        print(bw,stack);
        bw.flush();
    }

    static void print(BufferedWriter bw, Stack<Character> stack) throws IOException {
        while(!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }
}
