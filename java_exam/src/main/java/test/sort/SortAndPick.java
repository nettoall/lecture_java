package test.sort;

import java.util.Arrays;

public class SortAndPick {
    public int[] solution(int[] array, int[][] commands){
        /*
        // 풀이 1
        int[] answer = new int[commands.length];
        int[] command;
        int[] temp;
        int k;
        System.out.println(commands.length);
        for(int i = 0; i < commands.length; i++){
            command = commands[i];

            temp = new int[command[1] - command[0] +1];
            System.out.println("length : " + temp.length);
            k = 0;
            for(int j = command[0] - 1 ; j < command[1]; j++){
                temp[k] = array[j];
                System.out.println("temp[" + k + "] : " + temp[k]);
                k++;
            }
            Arrays.sort(temp);
            answer[i] = temp[command[2] - 1];
        }
        */

        // 풀이2
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] -1];
        }


        return answer;
    }

    public static void main(String[] args){
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] result;
        SortAndPick pick = new SortAndPick();
        result = pick.solution(array, commands);

        for(int in: result){
            System.out.println(in);
        }
    }
}
