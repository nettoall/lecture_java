package algorithm.sort;

public class InsertionSort {
    static void insertionSort(int[] a, int n){
        for(int i = 1; i < n; i++){
            int j;
            int tmp = a[i];
            for(j = i; j > 0 && a[j - 1] > tmp; j--){
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    public static void main(String[] args){
        int[] x = new int[]{6,4,3,7,1,9,8};
        insertionSort(x, x.length);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < x.length; i++){
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }
}
