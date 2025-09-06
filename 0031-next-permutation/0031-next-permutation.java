class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int len = nums.length;
        int right =  len - 1;
        int left = 0;
        
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                left = i;
                break;
            }
        }

        if (left != 0 || nums[0] < nums[1]) {
            for (int i = len - 1; i > left; i--) {
                if (nums[i] > nums[left]) {
                    right = i;
                    break;
                }
            }

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        } else {
            left = -1;
        }

        int start = left + 1;
        int end = len - 1;
        
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }       
    }
}