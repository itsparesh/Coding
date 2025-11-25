class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> boxQueue = new PriorityQueue<>((a,b) ->   b[1] - a[1]);
        for (int[] box: boxTypes) {
            boxQueue.add(box);
        }

        int result = 0;
        while (!boxQueue.isEmpty() && truckSize > 0) {
            int[] box = boxQueue.poll();
            result += box[1];
            box[0] = box[0] - 1;
            if (box[0] > 0) {
                boxQueue.add(box);
            }
            truckSize--;
        }

        return result;
    }
}