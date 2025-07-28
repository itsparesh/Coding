class Solution {
    int fresh = 0;
    int ROW, COL;
    int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair<Integer, Integer>(i, j));
                } 
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        
        return bfs(grid, queue);
    } 

    private int bfs(int[][] grid, Queue<Pair<Integer, Integer>> queue) {
        int minutes = 0;
        
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            boolean rotten = false;
            for (int j = 0; j < size; j++) {
                Pair<Integer, Integer> pair = queue.poll();
                for (int[] direction: DIRECTIONS) {
                    int nrow = pair.getKey() + direction[0];
                    int ncol = pair.getValue() + direction[1];
                    if (nrow >= 0 && nrow < ROW && ncol >= 0 && ncol < COL && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        queue.add(new Pair<Integer, Integer>(nrow, ncol));
                        fresh--;
                        rotten = true;
                    }
                }
            }

            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}