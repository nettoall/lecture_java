package test.hash;

import java.util.HashMap;

/**
 * 완주하지 못한 선수
 *
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다 .
 *
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion 이 주어질 때, 완주하지 못한 선수의 이름을 return하도록 solution함수를 작성해 주세요.
 *
 * 제한사항
 * - 마라톤 경기에 참여한 선수의 수는 1명이상 100,000명 이하입니다.
 * - completion의 길이는 participant의 길이보다 1작습니다.
 * - 참가자의 이름은 1개이상 20개 이하의 알파벳 소문자로 이루어져 잇습니다.
 * - 참가자 중에는 동명이인이 있을 수 있습니다.
 *
 * 입출력 예
 * participant              completion      return
 * ["leo:,"kiki","eden"]  ["eden","kiki"]    "leo"
 */
public class Marathon {

    public String solution(String[] participant, String[] completion){
        String answer = "";
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
/*
        int i = 0;
        for(String tmp : paricipant){
           for(String tmp2: completion){
               if(tmp.equals(tmp2)){
                   if(hashMap.containsKey(tmp)){
                       i = hashMap.get(tmp);
                       hashMap.put(tmp,i+1);
                   }
                   else
                       hashMap.put(tmp,1);
               }
           }
        }

        for(String tmp3:paricipant){
            if(!hashMap.containsKey(tmp3)) {
                answer = tmp3;
            }
        }

        if(answer == null || answer.equals("")){
            for(String key : hashMap.keySet()){
                if(hashMap.get(key) > 1){
                    answer = key;
                }
            }
        }
        */

        int i = 0;
        for(String tmp : participant){

//            if(hashMap.containsKey(tmp)){
//                i = hashMap.get(tmp);
//                hashMap.put(tmp,i+1);
//            }else {
//                hashMap.put(tmp,1);
//            }
            hashMap.put(tmp, hashMap.getOrDefault(tmp,0) +1);
        }

        for(String tmp2: completion){
//            if(hashMap.containsKey(tmp2)){
//                i = hashMap.get(tmp2);
//                hashMap.put(tmp2, i-1);
//            }
            hashMap.put(tmp2, hashMap.get(tmp2) -1);
        }

        for(String key: hashMap.keySet()){
//            if(hashMap.get(key) == 1)
//                answer = key;
            if(hashMap.get(key) != 0)
                answer = key;
        }

        /*
        HashMap<string, Integer> hm = new HashMap();
        for(String player : participant)
            hm.put(player,hm.getOrDefault(player,0) + 1);

        for(String player : completion)
            hm.put(player, hm.get(player)-1);

        for(String key : hm.keySet()){
            if(hm.get(key) != 0){
                answer = key;
            }
        }
         */

        /*
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i ;
        for(i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
         */

        return answer;
    }

    public static void main(String[] args){
        String result = "";
        String[] participant01 = {"leo","kiki","eden"};
        String[] competion01 = {"eden","kiki"};

        String[] participant02 = {"marina","josipa","nikola","vinko","filipa"};
        String[] competion02 = {"josipa","filipa","marina","nikola"};

        String[] participant03 = {"mislav","stanko","mislav","ana"};
        String[] competion03 = {"stanko","ana","mislav"};

        Marathon marathon = new Marathon();
        result = marathon.solution(participant01,competion01);
      System.out.println(result);
    }
}
