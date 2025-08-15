/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private TreeMap<Integer, List<int[]>> colMap = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, 0);
        for (List<int[]> list : colMap.values()) {
            list.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });
            List<Integer> valList = new ArrayList<>();
            for (int[] colArr : list) {
                valList.add(colArr[1]);
            }
            result.add(valList);
        }
        return result;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) return;
        dfs(node.left, row + 1, col - 1); //left
        dfs(node.right, row + 1, col + 1); //rightl
        colMap.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[] {row, node.val});
    }
} 