class Solution {
    public int[] frequencySort(int[] nums) {
        TreeMap<Integer, TreeSet<Integer>> countMap = new TreeMap<>();

        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int num: nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            countMap.computeIfAbsent(entry.getValue(), k -> new TreeSet<>(Collections.reverseOrder())).add(entry.getKey());
        }

        int index = 0;
        for (Map.Entry<Integer, TreeSet<Integer>> entry : countMap.entrySet()) {
            int frequency = entry.getKey();
            for (int i : countMap.get(frequency)) {
                for (int j = 0; j < entry.getKey(); j++) {
                    nums[index++] = i;
                }
            }
        }
        return nums;
    }
}