class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        int pre = 1, post = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = pre * nums[i]; 
            } else {
                prefix[i] = nums[i] * prefix[i-1];  
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                postfix[i] = post * nums[i]; 
            } else {
                postfix[i] = nums[i] * postfix[i+1];  
            }
             
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[i] = pre * postfix[i+1]; 
            } else if (i == nums.length - 1) {
                nums[i] = post * prefix[i-1]; 
            } else {
                nums[i] = prefix[i-1] * postfix[i+1]; 
            }
        }

        return nums;
    }
}