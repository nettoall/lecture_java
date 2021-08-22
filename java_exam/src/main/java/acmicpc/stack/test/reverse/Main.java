package acmicpc.stack.test.reverse;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        char[] stack = new char[20];
        int size = 0;

        while (n > 0) {
                String st = sc.nextLine();
                if(!st.equals("")) {
                    char[] temp = st.toCharArray();
                    for(int i = 0; i < temp.length; i++) {
                        if(temp[i] == 32) {
                            int charLength = size;
                             for(int j = charLength; j > 0; j--) {
                                  bw.write(stack[j - 1]);
                                  size--;
                               }
                             bw.write(" ");
                        } else if(i == temp.length - 1) {
                            stack[size++] = temp[i];
                            int charLength = size;
                            for(int j = charLength; j > 0; j--) {
                                bw.write(stack[j - 1]);
                                size--;
                            }
                        }
                        else {
                            stack[size++] = temp[i];
                        }
                    }
                    bw.write("\n");
                    n--;
                }

        }
        bw.flush();
    }
}
