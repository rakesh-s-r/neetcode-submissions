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
    Map<Integer, Integer> map = new HashMap<>();
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length-1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int l, int r) {
        if(l > r) {
            return null;
        }
        int val = preorder[idx];
        idx++;

        TreeNode root = new TreeNode(val);
        int mid = map.get(val);

        root.left = dfs(preorder, inorder, l, mid-1);
        root.right = dfs(preorder, inorder, mid+1, r);
        return root;
    }
}
