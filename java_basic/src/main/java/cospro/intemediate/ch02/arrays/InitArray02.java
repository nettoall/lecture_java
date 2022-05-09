package cospro.intemediate.ch02.arrays;

/**
 * 1 6 11 16 21
 * 2 7 12 17 22
 * 3 8 13 18 23
 * 4 9 14 19 24
 * 5 10 15 20 25
 */
public class InitArray02 {
    public static void main(String[] args){
        int row = 5;
        int col = 5;
        int element = 1;
        int[][] array = new int[row][col];

        for(int i = 0; i < col; i++){
            for (int j = 0; j < row; j++){
                array[j][i] = element++;
            }
        }

        InitArray02 arr = new InitArray02();
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
