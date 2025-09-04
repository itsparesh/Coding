/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildBST(int[] preorder, int lower, int upper) {
        if (index >= preorder.length) return null;
        int rootVal = preorder[index];
        if (rootVal < lower || rootVal > upper) return null;
        TreeNode head = new TreeNode(rootVal);
        index++;
        head.left = buildBST(preorder, lower, rootVal);
        head.right = buildBST(preorder,rootVal, upper);
        return head;
    }
}