class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombination(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }

    int prev = 0;

    private void findCombination(int[] candidates, int target, int index, ArrayList<Integer> current, int total) {
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (index >= candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (total + candidates[i] > target) break;
            if (prev == candidates[i]) {
                continue;
            }
            current.add(candidates[i]);
            findCombination(candidates, target, i + 1, current, total + candidates[i]);
            current.removeLast();
            prev = candidates[i];
        }
    }
}