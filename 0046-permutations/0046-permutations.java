class Solution {
    private List<List<Integer>> result = new ArrayList<>(); 
    //private Set<Integer> usedSet = new HashSet<>();

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
            //usedSet.add(num);
            current.add(num);
            findPermutation(nums, current);
            current.remove(current.size() - 1); 
            //usedSet.remove(num);  
        }
    }
}