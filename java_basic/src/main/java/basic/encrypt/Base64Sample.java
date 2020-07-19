/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.encrypt;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 *
 * @author dongwookhan
 */
public class Base64Sample {
    
    public void sample(String testString) throws UnsupportedEncodingException{
        Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(testString.getBytes("UTF-8"));
        System.out.println(encodedString);
        
        Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(encodedString);
        String decodedString = new String(decodedBytes, "UTF-8");
        System.out.println(decodedString);
    }
    
    public static void main(String[] args) throws Exception{
        Base64Sample s = new Base64Sample();
        s.sample("This is a Base64 test");
    }
}
