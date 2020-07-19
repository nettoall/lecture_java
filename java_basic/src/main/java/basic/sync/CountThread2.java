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
public class CountThread2 implements Runnable{
    static ReentrantLock lock = new ReentrantLock();
    
    public void run(){
        lock.lock();
        try{
            System.out.println("[Thread2]");
            for(int i = 0; i <= 30; i++){
                System.out.print(i+"\t");
            }
            System.out.println("\r\n");
        }finally{
            lock.unlock();
        }
    }    
}
