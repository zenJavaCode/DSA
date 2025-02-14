package StriverSDESheet.arrays;

public class Arrays {
    /*TODO:Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
                                            You must do it in place.*/


    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        matrixSumZero(arr);
    }
    //brute-force Approach.
    public static int[][] matrixSumZero(int[][] matrix){
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == 0){
                    markRow(i,matrix);
                    markCol(j,matrix);
                }
            }
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] =0;
                }
            }
        }




        return matrix;
    }

    private static void markCol(int j, int[][] matrix) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns
        for(int i =0;i<m;i++){
            if(matrix[i][j] !=0){
                matrix[i][j] =-1;
            }
        }
    }

    private static void markRow(int i, int[][] matrix) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns
        for(int j =0;j<n;j++){
            if(matrix[i][j] !=0){
                matrix[i][j] =-1;
            }
        }
    }
    //TODO: Better Approach

    public static int[][] zeroMatrixBetter(int[][] mat){
        int m = mat.length; // rows
        int n = mat[0].length; // columns
        int[] row = new int[m];
        int[] col = new int[n];

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(mat[i][j] ==0){
                    row[i] =1;
                    col[j] =1;
                }
            }
        }

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(row[i] ==1 || col[j]==1){
                    mat[i][j] =0;
                }
            }
        }
        return mat;
    }




}
