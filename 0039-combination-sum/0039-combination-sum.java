class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int len;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        len = candidates.length;
        findCombination(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }
    private void findCombination(int[] candidates, int target, int index, ArrayList<Integer> current, int total) {
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (index >= len || total > target) {
            return;
        }

        current.add(candidates[index]);
        findCombination(candidates, target, index, current, total + candidates[index]);
        current.removeLast();
        findCombination(candidates, target, index + 1, current, total);
    }
}