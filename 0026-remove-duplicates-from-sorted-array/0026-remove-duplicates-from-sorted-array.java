class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int count = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i-1] != nums[i]) {
                nums[count++] = nums[i];
            }
            i++;
        }
        return count;
    }
}