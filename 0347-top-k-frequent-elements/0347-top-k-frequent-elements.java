class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] countList = new ArrayList[nums.length + 1];
        for (int key : countMap.keySet()) {
            int count = countMap.get(key);
            if (countList[count] == null) {
                countList[count] = new ArrayList<Integer>();
            }
            countList[count].add(key);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0 && index < k; i--) {
            if (countList[i] != null) {
                for (int num : countList[i]) {
                    res[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return res;
    }
}
