class Solution {

    int fresh = 0;
    int minute = 0;
    int ROW, COL;

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        ROW = grid.length;
        COL = grid[0].length;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }

                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        if (fresh == 0) return 0;

        while (!queue.isEmpty() && fresh != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int row = arr[0];
                int col = arr[1];
                if (row - 1 >= 0 && grid[row-1][col] == 1) {
                    grid[row - 1][col] = 2;
                    queue.add(new int[] {row - 1, col});
                    fresh--;
                }
                if (row + 1 < ROW && grid[row+1][col] == 1) {
                    grid[row + 1][col] = 2;
                    queue.add(new int[] {row + 1, col});
                    fresh--;
                }
                if (col + 1 < COL && grid[row][col+1] == 1) {
                    grid[row][col + 1] = 2;
                    queue.add(new int[] {row, col + 1});
                    fresh--;
                }
                if (col - 1 >= 0 && grid[row][col-1] == 1) {
                    grid[row][col - 1] = 2;
                    queue.add(new int[] {row, col - 1});
                    fresh--;
                }
            }
            minute++;
        }
        
        if (fresh != 0) return -1;
        return minute;
    }
}