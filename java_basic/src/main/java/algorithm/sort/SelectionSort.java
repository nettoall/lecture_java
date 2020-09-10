package algorithm.sort;

/**
 * 선택정렬
 */
public class SelectionSort {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void selectionSort(int[] a, int n){
        for(int i = 0; i < n - 1; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            for(int m = 0; m < n - 1; m++){
                System.out.print((m == i) ? "  * " : (m == min) ? "  + " : "    ");
            }
            System.out.println();

            for(int m = 0; m < n; m++){
                System.out.printf("%3d ", a[m]);
            }
            System.out.println("\n");
            swap(a, i, min);
        }
    }

    public static void main(String[] args){
        int[] x = new int[]{6,4,3,7,1,9,8};
        selectionSort(x, x.length);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < x.length; i++){
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }
}
