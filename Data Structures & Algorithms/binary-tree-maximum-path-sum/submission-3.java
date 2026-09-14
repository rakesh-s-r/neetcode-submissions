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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = max(root.left);
        int right = max(root.right);
        int path = root.val + Math.max(left, right);
        return Math.max(path, 0);
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int left = max(root.left);
        int right = max(root.right);
        res = Math.max(res, root.val + left + right);
        dfs(root.left);
        dfs(root.right);
    }
}
