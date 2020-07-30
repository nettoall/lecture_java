package test.hash;

import java.util.Arrays;
import java.util.HashMap;

public class Camouflage {
    public int solution(String[][] clothes){
        int answer = 0;

        /*
        String[] temp = new String[2];
        for(int j = 0; j < clothes.length; j++){
            for(int k = 0; k < clothes.length; k++){
                if(clothes[j][0].equals(clothes[k][0]) && clothes[j][1].equals(clothes[k][1])){
                    if(hashMap.get(clothes[j][0]) == null){
                        answer++;
                        hashMap.put(clothes[j][0],clothes[j][1]);
                    }

                }else if(!clothes[j][0].equals(clothes[k][0]) && !clothes[j][1].equals(clothes[k][1])){
                    temp[0] = clothes[j][0];
                    temp[1] = clothes[k][0];
                    Arrays.sort(temp);
                    if(hashMap.get(temp[0]+"_"+temp[1]) == null){
                        answer++;
                        hashMap.put(temp[0]+"_"+temp[1],clothes[j][1]+"_"+clothes[k][1]);
                    }
                }
            }
        }
        */
        /*
        HashMap<String, String> hashMap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            answer++;
            if(i+1 < clothes.length){
                for(int j = i + 1; j < clothes.length; j++) {
                    if(!clothes[i][0].equals(clothes[j][0]) && !clothes[i][1].equals(clothes[j][1])){
                        answer++;
                    }
                }
            }

        }

         */
// 경우의 수 문제 종류별 개수 (2,3,1)   공식 (2+1) * (3+1) * (1+1) -1
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            hashMap.put(clothes[i][1],(hashMap.getOrDefault(clothes[i][1],0) +1 ));
        }

        int count = 1;
//        for(int j = 1; j <= clothes.length;j++){
//            count = count *j;
//            System.out.println("j : "+ j);
//        }

//        System.out.println("count :" + count);
        for(String str: hashMap.keySet()){
//            System.out.println("str : " + str + "("+hashMap.get(str)+")");
            if(hashMap.get(str) > 0){
                count = count * (hashMap.get(str) + 1);
                //System.out.println("count : " + count);
            }
        }

        answer = count -1;



        return answer;
    }

    public static void main(String[] args){
        String[][] clothes1 = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}};
        String[][] clothes2 = {{"crow_mask","face"},{"blue_sunglasses","face"},{"smoky_makeup","face"}};
        String[][] clothes3 = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"},{"crow_mask","face"},{"blue_sunglasses","face"},{"smoky_makeup","face"}};

        Camouflage cam = new Camouflage();
        System.out.println(cam.solution(clothes1));
        System.out.println(cam.solution(clothes2));
        System.out.println(cam.solution(clothes3));
    }
}
