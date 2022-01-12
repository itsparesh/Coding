class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        if (Intervals == null || Intervals.length == 0 || Intervals[0].length == 0) return Intervals;
        Arrays.sort(Intervals, Comparator.comparingInt(o -> o[0]));
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int[] current : Intervals) {
            if (second >= current[0]) {
                second = Math.max(second, current[1]);
            } else {
                first = current[0];
                second = current[1];
            }
            linkedHashMap.put(first, second);
        }
        int[][] array = new int[linkedHashMap.size()][2];
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : linkedHashMap.entrySet()) {
            array[count][0] = entry.getKey();
            array[count][1] = entry.getValue();
            count++;
        }
        return array;
    }
}