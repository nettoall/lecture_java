package algorithm.basic;

/**
 * 1부터 9까지 곱셈표 구성
 *
 */
public class Multi99_2Table {
    public static void main(String[] args){
        System.out.println("---- 곱셈표 ----");

        System.out.printf("   |");
        for(int i = 1; i <= 9; i++){
            System.out.printf("%3d", i);
        }
        System.out.println();
        System.out.println("---+----------------------------");
        for(int i = 1; i <= 9; i ++){
            System.out.printf("%2d |", i);
            for(int j = 1; j <= 9; j++){
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
    }
}
