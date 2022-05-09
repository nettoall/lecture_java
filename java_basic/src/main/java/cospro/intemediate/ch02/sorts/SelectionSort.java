package cospro.intemediate.ch02.sorts;

/**
 * 선택 정렬
 * 시간 복잡도
 * N + (N -1) + (N-2) + ... + 2
 * o(n2)
 */
public class SelectionSort {
    public static void main(String[] args){
        int n = 10;
        int[] arr = {3,5,8,1,4,9,2,6,7,0};

        for(int i = 0; i < arr.length; i++){
            int min_index = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[min_index] > arr[j])
                    min_index = j;
            }
            // 교체
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        for(int tmp : arr){
            System.out.print(tmp + " ");
        }
    }
}
