class Solution {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        if (row == col) {
            for (int i = 0; i < row; i++) {
                for (int j = i; j < col; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            return matrix;
        } else {
            int[][] transpose = new int[col][row];
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    transpose[i][j] = matrix[j][i];
                }
            }
            return transpose;
        }
    }
}