class Solution {
    static int canReach(int[] A, int N) {
        int maxReach = 0, current = 0;
        for (int i = 0; i < A.length; i++) {
            maxReach = Math.max(maxReach , i + A[i]);
            if (current == i) {
                current = maxReach;
            }
        }
        if (current >= A.length - 1) return 1;
        return 0;
    }
}