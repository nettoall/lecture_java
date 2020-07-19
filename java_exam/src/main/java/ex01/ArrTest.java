package ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrTest {

    public int[] solution(int[] arr){
        int[] answer = {};
        int j = 0;
        answer = new int[arr.length];
        List<Integer> list = new ArrayList();
        for(int i = 1; i < arr.length; i++){
//            if(i+1 < arr.length){
            if(arr[i-1] != arr[i]){
                list.add(arr[i-1]);
//                    answer[j] = arr[i-1];
//                    j++;
            }else if(arr[i-1] == arr[i] && (i+1) == arr.length) {
                answer[j] = arr[i-1];
                list.add(arr[i-1]);
            }
            //}
        }
        answer = new int[list.size()];
        int k = 0;
        for(Integer i: list) {
            answer[k] = list.get(k).intValue();
            k++;
        }


        System.out.println("Hello Java");
        return answer;
    }
    public static void main(String[] args){
        int[] test1 = {1,1,3,3,0,1,1};
        int[] test2 = {4,4,4,3,3};
        ArrTest test = new ArrTest();
        int[] result1 = test.solution(test1);
        int[] result2 = test.solution(test2);

        test.printArray(result1);
        test.printArray(result2);

    }

    public void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
}

