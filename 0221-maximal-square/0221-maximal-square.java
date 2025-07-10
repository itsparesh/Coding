class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] memo = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        memo[i][j] = 1;
                    } else {
                        memo[i][j] = Math.min(Math.min(memo[i-1][j], memo[i][j-1]), memo[i-1][j-1]) + 1;
                    }
                    max = Math.max(max, memo[i][j]);
                }
            }
        }
        return max * max;
    }
}