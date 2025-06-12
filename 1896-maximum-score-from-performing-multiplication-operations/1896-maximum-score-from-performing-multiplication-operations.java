class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int op = m-1; op >= 0; op--) {
            for (int left = op; left >= 0; left--) {
                int right = n - 1 - (op - left);
                
                int pickLeft = multipliers[op] * nums[left] + dp[op+1][left+1];
                int pickRight = multipliers[op] * nums[right] + dp[op+1][left];
                dp[op][left] = Math.max(pickLeft, pickRight);
            }
        }
        return dp[0][0];
    }
}
