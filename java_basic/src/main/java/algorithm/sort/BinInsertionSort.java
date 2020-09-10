package algorithm.sort;

public class BinInsertionSort {
    static void binInsertionSort(int[] a, int n){
        for(int i = 1; i < n; i++){
            int key = a[i];
            int pl = 0;
            int pr = i - 1;
            int pc;
            int pd;

            do{
                pc = (pl + pr) / 2;
                if(a[pc] == key){
                    break;
                }else if(a[pc] < key){
                    pl = pc + 1;
                }else{
                    pr = pc - 1;
                }
            }while(pl <= pr);
            pd = (pl <= pr) ? pc + 1 : pr + 1;

            for(int j = i; j > pd; j--){
                a[j] = a[j - 1];
            }
            a[pd] = key;
        }
    }

    public static void main(String[] args){
        int[] x = new int[]{6,4,3,7,1,9,8};
        binInsertionSort(x, x.length);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < x.length; i++){
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }
}
