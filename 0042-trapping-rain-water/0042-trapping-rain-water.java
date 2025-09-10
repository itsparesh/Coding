class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int sum = 0;
        int maxL = height[0], maxR = height[height.length - 1];
        while (left < right) {
            if (maxL <= maxR) {
                left++;
                maxL = Math.max(maxL, height[left]);
                sum += maxL - height[left];
            } else {
                right--;
                maxR = Math.max(maxR, height[right]);
                sum += maxR - height[right];
            }
        }
        return sum;
    }
}