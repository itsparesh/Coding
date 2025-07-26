class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        // 1. Count frequencies
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 2. Build bucket: index = frequency, the value is the list of numbers with that frequency
        List<Integer>[] countList = new ArrayList[nums.length + 1];
        for (int key : countMap.keySet()) {
            int count = countMap.get(key);
            if (countList[count] == null) {
                countList[count] = new ArrayList<Integer>();
            }
            countList[count].add(key);
        }

        // 3. Collect k most frequent from the buckets, going from high to low frequency
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 0 && res.size() < k; i--) {
            if (countList[i] != null) {
                res.addAll(countList[i]);
            }
        }

        // 4. Return only k elements
        return res.stream().limit(k).mapToInt(Integer::intValue).toArray();
    }
}
