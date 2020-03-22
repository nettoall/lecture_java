package com.nettoall.primitive;

public class BasicVariable {
    public static void main(String[] args){
        byte by = 0; // 1 byte, 8 bit, -128 ~ 127
        char ch = 'A'; // 2 byte, 16 bit /U0000~/uFFFF (0~65535)
        short sh = 1; // 2 byte, 16 bit -32768 ~ 32767
        int it = 1; // 4 byte, 32 bit, -2,147,483,648 ~ 2,147,483,647
        long lg = 1L; // 8 byte, 64 bit, -9,223,372,035,854,775,808 ~ 9,223,372,036,854,775,807

        float fl = 1.0f; // 4 byte, 32 bit 1.4E-45 ~ .402825E38
        double dl = 1.0d; // 8 byte, 64 bit

        boolean bl = false; // 1 byte, 8 bit

        char c = 'A';
        int uniCode = c;
        char c2 = 65;
        char c3 = '\u0041';

        System.out.println(c);
        System.out.println(c2);
        System.out.println(c3);
    }
}

