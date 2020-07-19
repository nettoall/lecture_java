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
public class CountThread1 extends Thread{
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("[Thread1] : " + i);
        }
    }
}
