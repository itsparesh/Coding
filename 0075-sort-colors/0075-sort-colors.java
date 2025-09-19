class Solution {
    public void sortColors(int[] nums) {
        int current = 0, first = 0, last = nums.length - 1;
        while (current <= last) {
            if (nums[current] == 0) {
                int temp = nums[current];
                nums[current] = nums[first];
                nums[first] = temp;
                current++;
                first++;
            } else if (nums[current] == 1) {
                current++;
            } else {
                int temp = nums[current];
                nums[current] = nums[last];
                nums[last] = temp;
                last--;
            }
        }
    }
}