package cospro.intemediate.ch02.arrays;

/**
 * 25  24  23  22  21
 * 16  17  18  19  20
 * 15  14  13  12  11
 *  6   7   8   9  10
 *  5   4   3   2   1
 */
public class InitArray06 {
    public static void main(String[] args){
        int row = 5;
        int col = 5;
        int element = 1;
        int[][] array = new int[row][col];

        for(int i = row -1; i >= 0; i--){
            if( i % 2 == 0)
                for (int j = col - 1; j >= 0; j--){
                    array[i][j] = element++;
                }
            else
                for (int j = 0; j < col; j++){
                    array[i][j] = element++;
                }
        }

        InitArray06 arr = new InitArray06();
        arr.print(array);
    }

    public void print(int[][] input){
        for(int[] intArr : input){
            for(int tmp : intArr){
                System.out.print(tmp + "\t");
            }
            System.out.println();
        }
    }
}
