/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.sync;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author dongwookhan
 */
public class CountThreadMain {
    static ReentrantLock lock = new ReentrantLock();
    
    public static void main(String[] args){
        Thread t1 = new Thread(new CountThread1());
        Thread t2 = new Thread(new CountThread2());
        
        t1.start();
        
        try{
            t1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        t2.start();
        
        try{
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        lock.lock();
        try{
            System.out.println("[Main]");
            for(int i =0; i <= 30; i++){
                System.out.print(i+"\t");
            }
        }finally{
            lock.unlock();
        }
    }
    
}
