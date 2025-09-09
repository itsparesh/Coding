class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombination(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }
    private void findCombination(int[] candidates, int target, int index, ArrayList<Integer> current, int total) {
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (total > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (total + candidates[i] > target) {
                break;
            }
            current.add(candidates[i]);
            findCombination(candidates, target, i, current, total + candidates[i]);
            current.removeLast();
        }
    }
}