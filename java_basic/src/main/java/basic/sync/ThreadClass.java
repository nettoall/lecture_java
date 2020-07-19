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
public class ThreadClass implements Runnable{
    static ReentrantLock lock = new ReentrantLock();
    
    public void run(){
        lock.lock();
        try{
            //saveFile(data);
        }finally{
            lock.unlock();
        }
    }
}
