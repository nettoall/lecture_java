package test.search;

import java.util.ArrayList;
import java.util.Arrays;

public class ExamTest{

    public int[] solution(int[] answers){

        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
/*
//풀이1

        int[] answer;
        int[] temp = new int[3];
        int sumOfPerson1 = 0;
        int sumOfPerson2 = 0;
        int sumOfPerson3 = 0;

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == person1[i%5]){
                System.out.println(person1[i%5]);
                sumOfPerson1++;
            }

            if(answers[i] == person2[i%8]){
                sumOfPerson2++;
            }

            if(answers[i] == person3[i%10]){
                sumOfPerson3++;
            }
        }

        temp[0] = sumOfPerson1;
        temp[1] = sumOfPerson2;
        temp[2] = sumOfPerson3;

        int[] temp2 = new int[3];
        System.arraycopy(temp,0,temp2,0,3);

        Arrays.sort(temp2);
        int max  = 0;
        int count = 0;
        for(int k = temp2.length -1; k >= 0;k--){
            if( max < temp2[k]){
                max = temp2[k];
            }
            if(max == temp2[k]){
                count++;
            }
        }


        if(count > 1){

            answer = new int[count];
            int l = 0;
            while(l < count){

                for(int m = 0; m < temp.length; m++){

                    if(max == temp[m]){

                        answer[l] = m + 1;
                        ++l;
                    }
                }
            }

        }else {
            answer = new int[1];
            for(int m = 0; m < temp.length; m++){
                if(max == temp[m]){
                    answer[0] = m + 1;
                }
            }
        }

 */

        //풀이2
        int[] score = new int[3];

        for(int i =0; i < answers.length; i++){
            if(answers[i] == person1[i%person1.length]) {score[0]++;}
            if(answers[i] == person2[i%person2.length]) {score[1]++;}
            if(answers[i] == person3[i%person3.length]) {score[2]++;}
        }

        int maxScore = Math.max(score[0], Math.max(score[1],score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]){list.add(1);}
        if(maxScore == score[1]){list.add(2);}
        if(maxScore == score[2]){list.add(3);}

        return list.stream().mapToInt(i -> i.intValue()).toArray();


        //return answer;
    }

    public static void main(String[] args){
        int[] answer01 = {1,2,3,4,5};
        int[] answer02 = {1,3,2,4,2};
        int[] result;

        ExamTest test = new ExamTest();
        result = test.solution(answer02);

        for(int i : result){
            System.out.println("result : " + i);
        }
    }
}
