package acmicpc.stack.test.rightmax;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

/**
 * 오큰수
 * a,b,c,d 순으로 숫자가 있을 때 a의 오큰수는 a의 오른쪽에 있으면서 a보다 큰 수 중 가장 왼쪽에 있는 수를 의미
 * 그러한 수가 없을 경우 -1 임 NGE로 표시
 * [3,5,2,7] 의 오큰 수 NGE = [5,7,7,-1]
 * 오큰수를 찾지 못한 수를 스택에 넣음.
 * 스택의 top에 있는 수가 가장 내림차순처럼 저장됨.
 * System.out.println() 사용시 시간초과 발생 -> BufferedWriter 로 변경함.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] a = new int[n];
        int[] result = new int[n];
        String[] tmp = br.readLine().split(" ");

        for(int i = 0; i < tmp.length; i++) {
            a[i] = Integer.parseInt(tmp[i]);
        }

        stack.push(0);
        for(int i = 1; i < a.length; i++) {
            if(stack.isEmpty()){
                stack.push(i);
            }

            while(!stack.isEmpty() && a[stack.peek()] < a[i]) {
                result[stack.pop()] = a[i];
            }
            stack.push(i);

        }

        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int j = 0; j < result.length; j++) {
            bw.write(result[j] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
