class Solution {
    private List<List<Integer>> result = new ArrayList<>(); 

    public List<List<Integer>> permute(int[] nums) {
        findPermutation(nums, new ArrayList<>());
        return result;
    }

    private void findPermutation(int[] nums, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        } 
        for (Integer num : nums) {
            if (current.contains(num)) continue;
            current.add(num);
            findPermutation(nums, current);
            current.removeLast();
        }
    }
}