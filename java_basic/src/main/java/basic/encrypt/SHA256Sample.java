/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author dongwookhan
 */
public class SHA256Sample {
    public void SHA256(String input) throws NoSuchAlgorithmException{
        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
        byte[] result = mDigest.digest(input.getBytes());
        
        StringBuffer sb = new StringBuffer();
        
        for(int i =0; i < result.length; i++){
            sb.append(Integer.toString((result[i] &0xFF) + 0x100, 16).substring(1));
        }
        System.out.println(sb.toString());
    }
    
    public static void main(String[] args) throws Exception{
        SHA256Sample sample = new SHA256Sample();
        sample.SHA256("1234");
    }   
}
