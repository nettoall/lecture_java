package algorithm.sort;

public class ShakerSort {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void shakerSort(int[] a, int n){
        int left = 0;
        int right = n - 1;
        int last = right;

        while(left < right){
            for(int j = right; j > left; j--){
                if(a[j - 1] > a[j]){
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            left = last;

            for(int j = left; j < right; j++){
                if(a[j] > a[j + 1]){
                    swap(a, j , j + 1);
                    last = j;
                }
            }
            right = last;
        }
    }

    public static void main(String[] args){
        int[] x = new int[]{6,4,3,7,1,9,8};
        shakerSort(x, x.length);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < x.length; i++){
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }
}
