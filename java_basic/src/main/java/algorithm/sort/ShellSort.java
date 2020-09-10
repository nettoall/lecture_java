package algorithm.sort;

/**
 * 쉘 정렬
 */
public class ShellSort {
    static void shellSort(int[] a, int n){
        for(int h = n /2; h > 0; h /= 2){
            for(int i = h; i < n; i++){
                int j ;
                int tmp = a[i];
                for(j = i - h; j >= 0 && a[j] > tmp; j -= h){
                    a[j + h] = a[j];
                }
                a[j + h] = tmp;
            }
        }
    }

    public static void main(String[] args){
        int[] x = new int[]{6,4,3,7,1,9,8};
        shellSort(x, x.length);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < x.length; i++){
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }
}
