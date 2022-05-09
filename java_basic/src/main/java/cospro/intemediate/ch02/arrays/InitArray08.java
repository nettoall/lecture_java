package cospro.intemediate.ch02.arrays;

/**
 *  1   2   4   7   11
 *  3   5   8  12   16
 *  6   9  13  17   20
 * 10  14  18  21   23
 * 25  19  22  24   25
 */
public class InitArray08 {
    public int[][] solution(int row, int col){
        int[][] result  = new int[row][col];
        int num = 1;

        for(int c = 0; c <= row + col; c++){
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(i + j == c)
                        result[i][j] = num++;
                }
            }
        }
        return result;
    }

    public int[][] mysolution(int row, int col){
        int element = 1;
        int[][] array = new int[5][5];
        int loop = (row -1 ) + (col -1);
        int m = 0;
        int k;
        for(int i = 0; i <= loop; i++){
            if( i <= (loop/2)){
                for(int j = 0; j <= i; j++){
                    int tmp = i - j;
                    if((i-j) >= 0)
                        array[j][tmp] = element++;
                }
            } else {
                k = i;
                for(int l = 1+ m; l < k-m; l++){
                    array[l][k-l] = element++;
                }
                m++;
            }
        }
        return array;
    }
    public static void main(String[] args){


        int row = 5;
        int col = 5;

        int[][] res;

        InitArray08 arr = new InitArray08();
        res = arr.solution(row,col);
        arr.print(res);
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
