package test.greedy;

public class LeisureSuit {

    public int solution(int n, int[] lost, int[] reserve){

/*
int answer  = 0;
        // 풀이1
        int[] student = new int[n];

        for(int i = 0; i < student.length; i++){
            student[i] = 1;
        }

        int k = 0;
        int j = 0;
        for(int i = 0; i < reserve.length; i++){
            j = reserve[i]-1;
            student[j] = student[j] + 1;
        }

        for(int i = 0; i < lost.length; i++){
            k = lost[i]-1;
            student[k] = student[k] - 1;
        }

        for(int i = 0; i < student.length; i++){
            if(student[i] == 0){
                if(i == 0){
                    if(student[i+1] == 2){
                        student[i] = 1;
                        student[i+1] = student[i+1] -1;
                    }
                }else {
                    if(student[i-1] ==2){
                        student[i] = 1;
                        student[i-1] = student[i-1] -1;
                    }else if((i+1) < student.length && student[i+1] == 2){
                            student[i] = 1;
                            student[i+1] = student[i+1] -1;
                    }
                }
            }


        }

        int count = 0;
        for(int i = 0; i < student.length; i++){
            if(student[i] > 0){
                count++;
            }
        }
        System.out.println("------");
        answer = count;
*/

        //풀이2
        int[] student = new int[n];
        int answer = n;

        for(int i : lost)
            student[i-1]--;

        for(int j : reserve)
            student[j-1]++;

        for(int k = 0; k < student.length; k++){
            if(student[k] == -1){
                if(k-1 >= 0 && student[k-1] == 1){
                    student[k]++;
                    student[k-1]--;
                }else if( k+1 < student.length && student[k+1] == 1){
                    student[k]++;
                    student[k+1]--;
                }else{
                    answer--;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args){
        int n1 = 5;
        int[] lost1 = {2,4};
        int[] reserve1 = {1,3,5};

        int n2 = 5;
        int[] lost2 = {2,4};
        int[] reserve2 = {3,};

        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};

        LeisureSuit suit = new LeisureSuit();
        System.out.println(suit.solution(n1,lost1,reserve1));
        System.out.println(suit.solution(n2,lost2,reserve2));
        System.out.println(suit.solution(n3,lost3,reserve3));
    }
}
