package algorithm.basic;

public class MaxMinExample {
    public static void main(String[] args){
        System.out.println("최대값 : " + max4(3,9,5,1));
        System.out.println("최소값 : " + min3(8,3,5));
        System.out.println("최소값 : "+ min4(3,2,1,5));
    }

    static int max4(int a, int b, int c, int d){
        int max = 0;
        max = a;
        if(max < b) max = b;
        if(max < c) max = c;
        if(max < d) max = d;

        return max;
    }

    static int min3(int a, int b, int c){
        int min;
        min = a;
        if(min > b) min = b;
        if(min > c) min = c;

        return min;
    }

    static int min4(int a, int b, int c, int d){
        int min;
        min = a;

        if(min > b) min = b;
        if(min > c) min = c;
        if(min > d) min = d;


        return min;
    }
}
