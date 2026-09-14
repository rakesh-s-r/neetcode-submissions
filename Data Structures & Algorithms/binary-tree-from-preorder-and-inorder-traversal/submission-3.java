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
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(0, preorder.length - 1, preorder, inorder);
    }

    public TreeNode dfs(int left, int right, int[] p, int[] i) {
        if (left > right) {
            return null;
        }
        int val = p[idx];
        idx++;
        TreeNode root = new TreeNode(val);
        int mid = map.get(val);

        root.left = dfs(left, mid - 1, p, i);
        root.right = dfs(mid + 1, right, p, i);
        return root;
    }
}
