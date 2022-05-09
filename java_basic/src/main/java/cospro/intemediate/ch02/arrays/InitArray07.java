package cospro.intemediate.ch02.arrays;

/**
 * 25  16  15  6  5
 * 24  17  14  7  4
 * 23  18  13  8  3
 * 22  19  12  9  2
 * 21  20  11  10 1
 */
public class InitArray07 {
    public static void main(String[] args){
        int row = 5;
        int col = 5;
        int element = 1;
        int[][] array = new int[row][col];

        for(int i = col -1; i >= 0; i--){
            if( i % 2 == 0 )
                for (int j = row - 1; j >= 0; j--){
                    array[j][i] = element++;
                }
            else
                for (int j = 0; j < col; j++){
                    array[j][i] = element++;
                }
        }

        InitArray07 arr = new InitArray07();
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
