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
public class ThreadSample {
    
    public static void main(String[] args){
        ThreadClass tc1 = new ThreadClass();
        
        tc1.start();
        
        try{
            tc1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
