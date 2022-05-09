package cospro.intemediate.ch01;

import java.util.Arrays;

public class Problem2_1_1 {
    public int[] solution(String[] shirtSize){
        // Write code here.
        int[] answer = {0,0,0,0,0,0};

        for(String str : shirtSize){

            switch(str) {
                case "XS":
                    answer[0]++;
                    break;
                case "S":
                    answer[1]++;
                    break;
                case "M":
                    answer[2]++;
                    break;
                case "L":
                    answer[3]++;
                    break;
                case "XL":
                    answer[4]++;
                    break;
                default:
                    break;
            }
        }

        // solution code end
        return answer;
    }

    public static void main(String[] args){
        Problem2_1_1 sol = new Problem2_1_1();
        String[] shirtSize = {"XS","S","M","L","XL"};
        int[] ret = sol.solution(shirtSize);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + Arrays.toString(ret) + " .");
    }
}
