class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] widthArr = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            widthArr[i] = points[i][0];
        }
        Arrays.sort(widthArr);
        int max = 0;
        for (int i = 1; i < widthArr.length; i++) {
            max = Math.max(max, widthArr[i] - widthArr[i-1]);
        }
        return max;
    }
}