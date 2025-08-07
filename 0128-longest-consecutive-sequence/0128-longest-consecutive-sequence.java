class Solution {
    Set<Integer> numSet = new HashSet<>();
    int maxLength =  0;

    public int longestConsecutive(int[] nums) {
        for (int num: nums) {
            numSet.add(num);
        }

        for (int num: numSet) {
            if (!numSet.contains(num - 1)) {
                int current = num;
                int len = 1;
                while (numSet.contains(current + 1)) {
                    current++;
                    len++;
                }
                maxLength = Math.max(maxLength, len);
            }
        }

        return maxLength;
    }
}