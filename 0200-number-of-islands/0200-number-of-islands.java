class Solution {
    int m, n, count;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    countIsIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void countIsIsland(char[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != '1') return;
        if (grid[row][col] == '1') {
            grid[row][col] = '2';
        } 

        countIsIsland(grid, row + 1, col);
        countIsIsland(grid, row - 1, col);
        countIsIsland(grid, row, col + 1);
        countIsIsland(grid, row, col - 1);
    }
}