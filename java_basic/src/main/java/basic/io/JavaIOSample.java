/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author dongwookhan
 */
public class JavaIOSample {
    public void printFile(String fileName){
        String line = null;
        try{
//            문자 입력 스트림
            FileReader fileReader = new FileReader(fileName);
//            문자 입력 스트림으로부터 문자를 읽을 때 버퍼링
            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            버퍼로부터 한줄씩 읽기
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            bufferedReader.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void copyFile(String inputFile, String outputFile){
        final int BUFFER_SIZE = 4096;
        int readLen;
        
        try{
            InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);
            
            byte[] buffer = new byte[BUFFER_SIZE];
            
            while((readLen = inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0, readLen);
            }
            inputStream.close();
            outputStream.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void fileDirList(){
        File directory = new File(".");
        File[] fList = directory.listFiles();
        
        for(File file : fList){
            if(file.isDirectory()){
                System.out.println("["+ file.getName() + "]");
            }else{
                System.out.println(file.getName());
            }
                
        }
    }
    
}
