class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        findCombination(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }
    private void findCombination(int[] candidates, int target, int index, ArrayList<Integer> current, int total) {
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (index >= candidates.length || total > target) {
            return;
        }

        current.add(candidates[index]);
        findCombination(candidates, target, index, current, total + candidates[index]);
        current.remove(current.size() - 1);
        findCombination(candidates, target, index + 1, current, total);
    }
}