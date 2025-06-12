class Solution {

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int prev = 0;
        int prev2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = prev;
            prev = Math.max(prev, nums[i] + prev2);
            prev2 = temp;
        }
        return prev;
    }
}