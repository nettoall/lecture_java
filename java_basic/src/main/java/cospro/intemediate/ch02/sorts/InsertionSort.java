package cospro.intemediate.ch02.sorts;

/**
 * 삽입 정렬
 * 처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입
 */
public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {3,5,8,1,4,9,2,6,7,0};

        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else break;
            }
        }

        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
