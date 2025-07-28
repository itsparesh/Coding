class Solution {
    int fresh = 0;
    int ROW, COL;
    int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } 
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        
        return bfs(grid, queue);
    } 

    private int bfs(int[][] grid, Queue<int[]> queue) {
        int minutes = 0;
        
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] pair = queue.poll();
                for (int[] direction: DIRECTIONS) {
                    int nrow = pair[0] + direction[0];
                    int ncol = pair[1] + direction[1];
                    if (nrow >= 0 && nrow < ROW && ncol >= 0 && ncol < COL && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        queue.add(new int[]{nrow, ncol});
                        fresh--;
                    }
                }
            }

            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}