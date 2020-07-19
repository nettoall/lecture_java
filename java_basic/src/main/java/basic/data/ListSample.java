/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 기본 입출력
 * @author dongwookhan
 */
public class ListSample {
    public static void main(String[] args){
        
    }
    
    public void basic(){
        ArrayList<String> al = new ArrayList<String>();
        
        al.add("Michael Knight");
        al.add("Mac Guyver");
        al.add("Clark Kent");
        al.add("Bruce Wayne");
        al.add("TOny Stark");
        
        for(String name : al){
            System.out.println(name);
        }
        System.out.println();
        
        al.remove("Clark Kent");
        
        for(int i =0; i < al.size(); i++){
            System.out.println(al.get(i));
        }
        System.out.println();
        
        al.remove(al.get(0));
        
        Iterator<String> itr = al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
    
    public void sort(){
       ArrayList<String> al = new ArrayList<String>();
        
        al.add("Michael Knight");
        al.add("Mac Guyver");
        al.add("Clark Kent");
        al.add("Bruce Wayne");
        al.add("TOny Stark");
        
//        정렬 오름차순
        Collections.sort(al);
        for(String name : al){
            System.out.println(name);
        }
        System.out.println();
        
//        정렬 Comparator
        Comparator<String> co = new Comparator<String>(){
            public int compare(String o1, String o2){
                return (o2.compareTo(o1)); //내림차순 o1,o2 자리 변경시 오름차순
            }
        };
        Collections.sort(al,co);  // 정렬 Comparator 사용
        
        for(String name: al){
            System.out.println(name);
        }
        System.out.println();
        
        // 정렬(람다식 사용) 오름차순
        Collections.sort(al,(g1,g2) -> g1.compareTo(g2));
        for(String name: al){
            System.out.println(name);
        }
    }
    
}
