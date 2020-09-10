package algorithm.search;

import java.util.Arrays;
import java.util.Scanner;

public class StringBinarySearch {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        String[] x = {
                "abstract","assert","boolean","break","byte",
                "case","catch","char","class","const",
                "continue","default","do","double","else",
                "enum","extends","final","finally","float",
                "for","goto","if","implements","import",
                "instanceof","int","interface","long","native",
                "new","package","private","protected","public",
                "return","short","static","strictfp","super","" +
                "switch","synchronized","this","throw","throws",
                "transient","try","void","volatile","while"
        };

        System.out.println("원하는 키워드를 입력하세요 : " );
        String ky = stdIn.next();

        int idx = Arrays.binarySearch(x,ky);

        if(idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky +"은(는) x["+idx+"]에 있습니다.");
    }
}
