/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author dongwookhan
 */
public class FileSample {
    public static void main(String[] args){
        FileSample sample = new FileSample();
        sample.listFiles("INPUT");
    }
    
    public void listFiles(String dirName){
        //버퍼크기 512 byte
        final int BUFFER_SIZE = 512;
        int readLen;
        
        File directory = new File(dirName);
        
//        INPUT 폴더의 파일 목록과 크기를 조회 및 출력
        File fList[] = directory.listFiles();
        InputStream inputStream;
        OutputStream outputStream;
        
        try{
            for(File file : fList){
                if(file.isFile()){
                    System.out.println(file.getName() + "\t" + file.length() + "byte");
                    
                    if(file.length() > ( 1024 * 10 * 2)){
                        File output = new File("OUTPUT");
                        if(!output.exists()){
                            output.mkdir();
                        }
                        
                        inputStream = new FileInputStream(file);
                        outputStream = new FileOutputStream(output + "\\" + file.getName());
                        
                        byte[] buffer = new byte[BUFFER_SIZE];
                        while((readLen = inputStream.read(buffer)) != -1){
                            outputStream.write(buffer);
                        }
                        
                        inputStream.close();
                        outputStream.close();
                    }
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
