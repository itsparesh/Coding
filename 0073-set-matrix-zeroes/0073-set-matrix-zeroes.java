class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<int[]> zeroSet = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroSet.add(new int[] {i, j});
                }
            }
        }

        for (int[] nums: zeroSet) {
            int i = nums[0];
            int j = nums[1];
            Arrays.fill(matrix[i], 0);

            for (int k = 0; k < matrix.length; k++) {
                matrix[k][j] = 0;
            }
        }
    }
}