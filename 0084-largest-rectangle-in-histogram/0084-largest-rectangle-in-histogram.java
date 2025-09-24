class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> numStack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int num = heights[i];
            int start = i;
            while (!numStack.isEmpty() && num < numStack.peek()[1]) {
                int[] arr = numStack.pop();
                start = arr[0];
                max = Math.max(max, (i-start) * arr[1]);
            }
            numStack.push(new int[] {start, num});
        }
        while (!numStack.isEmpty()) {
            int[] arr = numStack.pop();
            max = Math.max(max, (heights.length - arr[0]) * arr[1]);
        }
        return max;
    }
}