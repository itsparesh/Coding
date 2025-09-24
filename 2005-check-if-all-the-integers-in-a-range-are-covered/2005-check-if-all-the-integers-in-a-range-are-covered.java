class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[53];
        for (int[] arr: ranges) {
            diff[arr[0]] += 1;
            if (arr[1]+ 1  < diff.length) {
                diff[arr[1]+ 1] -= 1;
            }
        }

        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i-1];
        }

        for (int i = left; i <= right; i++) {
            if (diff[i] <= 0) {
                return false;
            }
        }
        
        return true;
    }
}