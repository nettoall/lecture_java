package test.hash;

import java.util.HashMap;

public class PhoneBook {
    public boolean solution(String[] phone_book){
        boolean answer = true;
/*
//풀이1
        String prefix = "";
        for(int i = 0; i < phone_book.length; i++){
            prefix = phone_book[i];
            for(int j = 0; j < phone_book.length; j++){
                if(i != j  && phone_book[j].startsWith(prefix)){
                        answer = false;
                        break;
                }
            }
        }
        */
        //풀이2 헤쉬를 꼭 사용 -> 속도가 더 잘 나옴?
        /*
        String prefix = "";
        HashMap<Integer, String> hashmap = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++){
            hashmap.put(i,phone_book[i]);
        }

        int length = 0;
        for(int j = 0; j < phone_book.length; j++){
            for(int k = 0; k < hashmap.size(); k++){
                if(j != k && phone_book[j].contains(hashmap.get(k))){
                    length = hashmap.get(k).length();
                    prefix = phone_book[j].substring(0,length);
                    if(prefix.equals(hashmap.get(k))){
                        answer = false;
                        break;
                    }

                }
            }
        }

         */

        // 풀이3
        for(int i = 0; i < phone_book.length-1; i++){
            for(int j = i+1; j < phone_book.length; j++){
                if(phone_book[i].startsWith(phone_book[j])) {return false;}
                if(phone_book[j].startsWith(phone_book[i])) {return false;}
            }
        }
        return true;
    }



    public static void main(String[] args){
        String[] phone_book1 = {"119","97674223","1195524421"};
        String[] phone_book2 = {"123","456","789"};
        String[] phone_book3 = {"12","123","1235","567","88"};

        PhoneBook phone = new PhoneBook();
        System.out.println(phone.solution(phone_book1));
        System.out.println(phone.solution(phone_book2));
        System.out.println(phone.solution(phone_book3));
    }
}
