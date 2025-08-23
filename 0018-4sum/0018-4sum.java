class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        kSum(nums, 0, (long) target, 4, new ArrayList<>());
        return result;
    }

    private void kSum(int[] nums, int start, long target, int k, List<Integer> current) {
        if (k != 2) {
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i-1]) continue;
                current.add(nums[i]);
                kSum(nums, i + 1, target - nums[i], k-1, current);
                current.remove(current.size() - 1);
            }
            return;
        }

        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            long sum = (long) nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                current.add(nums[left]);
                current.add(nums[right]);
                result.add(new ArrayList<>(current));
                current.remove(current.size() - 1);
                current.remove(current.size() - 1);
                left++;
                while (left < right && nums[left] == nums[left-1]) left++;
            }
        }
    }
}