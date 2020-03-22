package com.nettoall.operator;

public class BitLogicalExample {
    /**
     * bit 에 대한 논리연산을 한다.
     * 1 & 1 = 1, 1& 0 = 0
     * @param args
     */
    public static void main(String[] args){
        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25));
        System.out.println("~45 = " + (~45));
    }
}
