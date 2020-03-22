package com.nettoall.operator;

public class BitShiftExample {
    /**
     * a >> b : 정수 a의 각 비트를 b만큼 왼쪽으로 이동
     * a << b : 정수 a의 각 비트를 b만큼 오른쪽으로 이동
     * a >>> b : 정수 a의 각 비트를 b만큼 오른쪽으로 이동(빈자리는 0으로 채워짐)
     * @param args
     */
    public static void main(String[] args){

        System.out.println("1 << 3 = " + (1 << 3));
        System.out.println("-8 >> 3 = " + (-8 >> 3));
        System.out.println("-8 >>> 3 = " + (-8 >>> 3));
    }
}
