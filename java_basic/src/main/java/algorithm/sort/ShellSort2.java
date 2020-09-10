package algorithm.sort;

/**
 * 쉘 정렬 2
 */
public class ShellSort2 {
    static void shellSort(int[] a, int n){
        int h;
        for(h = 1; h < n/9; h = h * 3 +1)
            ;
        for(; h > 0; h /= 3){
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
