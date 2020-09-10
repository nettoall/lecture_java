package algorithm.sort;

/**
 * 버블정렬
 * 더 이상 swap이 없을 때 정렬처리 스톱
 */
public class BubbleSort3 {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort(int[] a, int n){
        int ccnt = 0; //비교횟수
        int scnt = 0; //교환횟수

        int i = 0;
        int k = 0;
        while(k < n - 1){
            System.out.printf("패스%d:\n", ++i);
            int last = n - 1;
            for(int j = n - 1; j  > k; j--){
                for(int l = 0; l < n - 1; l++){
                    System.out.printf("%3d %c", a[l], (l != j - 1) ? ' ':(a[j - 1] > a[j]) ? '+':'-');
                }
                System.out.printf("%3d\n", a[n - 1]);
                ccnt++;
                if(a[j - 1] > a[j]){
                    swap(a, j - 1, j);
                    last = j;
                    scnt++;
                }
            }
            for(int l = 0; l < n; l++){
                System.out.printf("%3d  ", a[l]);
            }
            System.out.println();
            k = last;
        }
        System.out.println("비교를 " + ccnt + "회 했습니다.");
        System.out.println("교환을 " + scnt + "회 했습니다.");
    }

    public static void main(String[] args){
//        Scanner stdIn = new Scanner(System.in);
//
//        System.out.println("버블 정렬(버전1)");
//        System.out.print("요솟수:");
//        int nx = stdIn.nextInt();
//        int[] x= new int[nx];
//
//        for(int i = 0; i < nx; i++){
//            System.out.print("x[" + i + "]:");
//            x[i] = stdIn.nextInt();
//        }
//
//        bubbleSort(x, nx);
//
//        System.out.println("오름차순으로 정렬했습니다.");
//        for (int i = 0; i < nx; i++){
//            System.out.println("x[" + i + "]=" + x[i]);
//        }

        int[] x = new int[]{6,4,3,7,1,9,8};
        bubbleSort(x, x.length);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < x.length; i++){
            System.out.println("x[" + i + "]=" + x[i]);
        }

    }
}
