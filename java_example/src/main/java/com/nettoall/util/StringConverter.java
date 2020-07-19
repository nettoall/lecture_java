package com.nettoall.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class StringConverter {
    public static void main(String[] args){

    }

    public static String encode(Object vo) throws IOException{
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bo);
        os.writeObject(vo);
        return new BASE64Encoder().encode(bo.toByteArray());
        //return Base64.getEncoder().encodeToString(bo.toByteArray());
    }

    public static Object decode(String text) throws IOException,ClassNotFoundException{
        byte o[] = new BASE64Decoder().decodeBuffer(text);
        //byte o[] = Base64.getDecoder().decode(text);
        ByteArrayInputStream bi = new ByteArrayInputStream(o);
        ObjectInputStream os = new ObjectInputStream(bi);
        Object vo = os.readObject();
        return vo;
    }
}
