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
    int idx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i< preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length-1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int left, int right) {
        if(left > right) {
            return null;
        }
        int val = preorder[idx];
        idx++;

        TreeNode node = new TreeNode(val);
        int mid = map.get(val);

        node.left = dfs(preorder, inorder, left,mid-1);
        node.right = dfs(preorder, inorder, mid+1, right);
        return node;
    }
}
