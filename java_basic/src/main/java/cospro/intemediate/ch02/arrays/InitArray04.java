package cospro.intemediate.ch02.arrays;

/**
 * 1 10 11 20 21
 * 2 9 12 19 22
 * 3 8 13 18 23
 * 4 7 14 17 24
 * 5 6 15 16 25
 */
public class InitArray04 {
    public static void main(String[] args){
        int row = 5;
        int col = 5;
        int element = 1;
        int[][] array = new int[row][col];

        for(int i = 0; i < row; i++){
            if(i % 2 == 0 )
                for (int j = 0; j < col; j++){
                    array[j][i] = element++;
                }
            else
                for (int j = row - 1; j >= 0; j--){
                    array[j][i] = element++;
                }
        }

        InitArray04 arr = new InitArray04();
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
