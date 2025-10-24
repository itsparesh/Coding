class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] range = intervals[0];
        for (int[] arr: intervals) {
            if (arr[0] >= range[0] && arr[0] <= range[1]) {
                range[0] = Math.min(arr[0], range[0]);
                range[1] = Math.max(arr[1], range[1]);
            } else {
                result.add(range);
                range = arr;
            }
        }
        result.add(range);
        return result.toArray(new int[0][]);
    }
}