/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dongwookhan
 */
public class SampleServer {
    public static void main(String[] args) throws IOException{
        ServerSocket listener = new ServerSocket(9090);
        try{
            Socket socket = listener.accept();
            
            try{
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                String today = format.format(date);
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                out.println(today);
            }finally{
                socket.close();
            }
        }finally{
            listener.close();
        }
    }
    
}
