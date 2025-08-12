class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        HashMap<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (numIndexMap.containsKey(diff)) {
                result[0] = numIndexMap.get(diff);
                result[1] = i;
                return result;
            }
            numIndexMap.put(num, i);
        }
        return result;
    }
}