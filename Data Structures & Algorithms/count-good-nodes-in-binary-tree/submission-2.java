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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode root, int pv) {
        if(root == null) {
            return 0;
        }

        int res = root.val >= pv ? 1 : 0;
        pv = Math.max(pv, root.val);
        res+=dfs(root.left, pv);
        res+=dfs(root.right, pv);
        return res;
    }
}
