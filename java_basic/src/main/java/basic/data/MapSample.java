/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.data;

import java.util.HashMap;

/**
 *
 * @author dongwookhan
 */
public class MapSample {
    public void basic(){
        HashMap<String,String> m = new HashMap<String,String>();
        m.put("kit@gmail.com","Michael Knight");
        m.put("knife@gmail.com","Mac Guyver");
        m.put("supermane@gmail.com","Clark Kent");
        m.put("batman@gmail.com","Bruce Wayne");
        m.put("ironman@gmail.com","Tony Stark");
        
        for(String key : m.keySet()){
            System.out.println(key + ":" + m.get(key));
        }
        System.out.println();
        
        m.remove("superman@gmail.com");
        
        for(String key : m.keySet()){
            System.out.println(key + ":" + m.get(key));
        }
        System.out.println();
        
        m.remove("batman@gmail.com", "Robin");
        for(String key : m.keySet()){
            System.out.println(key + ":" + m.get(key));
        }
        
    }
    
}
