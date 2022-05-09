package cospro.intemediate.ch02.sorts;

/**
 * 기준 데이터(pivot)를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 정렬
 * 일반적인 상황에서 자주 사용되는 알고리즘
 *
 */
public class QuickSort {
    static int pivot = 0;
    public static void main(String[] args){
        int[] arr = {3,5,8,1,4,9,2,6,7,0};

        quickSort(arr, 0, arr.length - 1);

    }

    public static void quickSort(int[] arr, int start, int end) {
        if( start >= end) return; // 원소가 1개인 경우 종료
        pivot = start; // 기준 숫자를 첫번째 원소로 설정
        int left = start + 1;
        int right = end;

        while(left <= right){
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while(left <= end && arr[left] <= arr[pivot])
                left++;

            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while(right > start && arr[right] >= arr[pivot])
                right--;

            // 엇갈렸다면 작은 데이터와 피벗을 교체
            if(left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else {
                //엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        quickSort(arr, start, right -1);
        quickSort(arr, right + 1, end);
    }
}
