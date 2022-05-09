package cospro.intemediate.ch02.arrays;

/**
 * 21  22  23  24  25
 * 16  17  18  19  20
 * 11  12  13  14  15
 *  6   7   8   9  10
 *  1   2   3   4   5
 */
public class InitArray05 {
    public static void main(String[] args){
        int row = 5;
        int col = 5;
        int element = 1;
        int[][] array = new int[row][col];

        for(int i = row -1; i >= 0; i--){
            for (int j = 0; j < col; j++){
                array[i][j] = element++;
            }
        }

        InitArray05 arr = new InitArray05();
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
