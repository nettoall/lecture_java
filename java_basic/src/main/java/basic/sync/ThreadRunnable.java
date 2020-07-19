/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.sync;

/**
 *
 * @author dongwookhan
 */
public class ThreadRunnable {
    public static void main(String[] args){
        Thread t1 = new Thread(new ThreadClass());
        t1.start();
        try{
            t1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
