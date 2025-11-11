class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 2) return 0;
        int length = height.length;
        int leftMax = height[0], rightMax = height[length -  1];
        int left = 0, right = length - 1, sum = 0;

        while (left < right) {
            if (leftMax <= rightMax) {  
                left++;
                leftMax = Math.max(leftMax, height[left]);
                sum += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                sum += rightMax - height[right];
            }
        }

        return sum;
    }
}