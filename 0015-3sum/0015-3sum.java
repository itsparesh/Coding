class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> checkSet = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int x = nums[i];
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int y = nums[j];
                int z = nums[k];
                int sum = x + y + z;
                if (sum == 0) {
                    String checkString = x + "" + y + ""+z;
                    if (!checkSet.contains(checkString)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(x);
                        list.add(y);
                        list.add(z);
                        res.add(list);
                        checkSet.add(checkString);
                    }
                    
                    j++;
                    k--;
                } else {
                    if (sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}