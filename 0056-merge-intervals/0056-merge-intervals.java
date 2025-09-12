class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int next = 1;
        int[] num = intervals[0];
        while (next < len) {
            if (num[1] >= intervals[next][0]) {
                num[1] = Math.max(num[1], intervals[next][1]);
            } else {
                res.add(num);
                num = intervals[next];
            }
            next++;
        }
        res.add(num);
        return res.toArray(new int[res.size()][]);
    }
}