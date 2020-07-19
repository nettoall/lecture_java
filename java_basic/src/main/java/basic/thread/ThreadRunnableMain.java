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
public class ThreadRunnableMain {
    public static void main(String[] args){
        ThreadRunnable m1 = new ThreadRunnable();
        Thread t1 = new Thread(m1);
        t1.start();
        
        try{
            t1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
