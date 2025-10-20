class Solution {
    public void rotate(int[][] matrix) {
        int left = 0, right = matrix.length - 1;
        while (left < right) {
            int top = left, bottom = right;

            for (int i = 0; i < right - left; i++) {
                // save top left
                int topLeft = matrix[top][left + i];

                // move bottom left to top
                matrix[top][left + i] = matrix[bottom - i][left];

                // move bottom right to bottom left
                matrix[bottom - i][left] = matrix[bottom][right - i];

                // move top right to bottom right
                matrix[bottom][right - i] = matrix[top + i][right];

                // move top left to top right
                matrix[top + i][right] = topLeft;
            }

            left += 1;
            right -= 1; 
        }
    }
}