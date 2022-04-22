package algorithm.simul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 알파벳 대문자와 숫자(0~9)로만 구성된 문자열이 입력으로 주어짐
 * 이때 모든 알파벳을 오름차순으로 정렬하여 이어서 출력한 뒤에 그 뒤에 모든 숫자를 더한 값을 이어서 출력
 * 예 ) K1KA5CB7 이라는 값이 들어오면 ABCKK13 출력
 * 알파벳을 알파벳끼리 숫자는 숫자끼리 모음 다음 알파벳은 정렬 숫자는 합친다.
 */
public class SimulExam08 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        ArrayList<Character> arrayList = new ArrayList<>();

        String str = "";
        int sum = 0;
        for(int i = 0; i < input.length(); i++){
            if(Character.isLetter(input.charAt(i)))
                arrayList.add(input.charAt(i));
            else
                sum += input.charAt(i) - '0';


        }
        Collections.sort(arrayList);
        for(int j = 0; j < arrayList.size(); j++){
            System.out.print(arrayList.get(j));
        }
        System.out.println(str + ":" + sum);
    }
}
