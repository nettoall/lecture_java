/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.thread;

/**
 *
 * @author dongwookhan
 */
public class CountThreadMain {
    public static void main(String[] args){
        CountThread1 t1 = new CountThread1();
        CountThread2 t2 = new CountThread2();
        
        t1.start();
        t2.start();
        for(int i =0; i < 10; i++){
            System.out.println("[Main] : " + i);
        }
        
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
