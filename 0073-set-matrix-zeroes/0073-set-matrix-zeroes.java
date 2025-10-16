class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[] rows = new boolean[row];
        boolean[] columns = new boolean[column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            if (rows[i]) {
                Arrays.fill(matrix[i], 0);    
            }
        }

        for (int j = 0; j < column; j++) {
            if (columns[j]) {
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;    
                }
            }
        }
    }
}