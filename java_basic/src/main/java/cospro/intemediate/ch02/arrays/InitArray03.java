package cospro.intemediate.ch02.arrays;

/**
 * 1 2 3 4 5
 * 10 9 8 7 6
 * 11 12 13 14 15
 * 20 19 18 17 16
 * 21 22 23 24 25
 */
public class InitArray03 {
    public static void main(String[] args){
        int row = 5;
        int col = 5;
        int element = 1;
        int[][] array = new int[row][col];

        for(int i = 0; i < row; i++){
            if( i %2 == 0)
                for (int j = 0; j < col; j++){
                    array[i][j] = element++;
                }
            else {
                for (int k = col - 1; k >= 0; k--) {
                    array[i][k] = element++;
                }
            }


        }

        InitArray03 arr = new InitArray03();
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
