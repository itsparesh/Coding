class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return result;
        }
        spiral(matrix, matrix.length, matrix[0].length, 0, 0);
        return result;
    }

    private void spiral(int[][] matrix, int m, int n, int rowStart, int colStart) {
        int i = 0;
        while (rowStart < m && colStart < n) {
            // right
            i = colStart;
            while (i < n) {
                result.add(matrix[rowStart][i++]);
            }
            
            // down
            i = ++rowStart;
            while (i < m) {
                result.add(matrix[i++][n-1]);
            }

            //left
            --n;
            if (rowStart < m) {
                i = n;
                while (i > colStart) {
                    result.add(matrix[m-1][--i]);
                }
            }
             
            //up
            --m;
            if (colStart < n) {
                i = m;
                while (i > rowStart) {
                    result.add(matrix[--i][colStart]);
                }
                colStart++;
            }
        }
    }
    
}