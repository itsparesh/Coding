class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int maxOverall = nums[0], maxEnding = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(nums[i], maxEnding + nums[i]); 
            maxOverall = Math.max(maxOverall, maxEnding);
        }
        return maxOverall;
    }
}