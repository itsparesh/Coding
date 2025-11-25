class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> boxQueue = new PriorityQueue<>((a,b) ->   b[1] - a[1]);
        for (int[] box: boxTypes) {
            boxQueue.add(box);
        }

        int result = 0;
        while (!boxQueue.isEmpty() && truckSize > 0) {
            int[] box = boxQueue.poll();
            int boxCount = Math.min(box[0], truckSize);
            result += boxCount * box[1];
            truckSize -= boxCount;
        }

        return result;
    }
}