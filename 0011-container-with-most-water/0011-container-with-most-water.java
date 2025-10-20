import static java.lang.Math.max;

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max((right - left) * Math.min(height[left], height[right]), maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}