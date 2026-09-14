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
        for(int i=0; i< inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, inorder.length-1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int left, int right) {
        if(idx == preorder.length) {
            return null;
        }

        if(left > right) {
            return null;
        }

        int nodeval = preorder[idx];
        idx++;

        TreeNode node = new TreeNode(nodeval);
        int mid = map.get(nodeval);

        node.left = dfs(preorder, inorder, left, mid-1);
        node.right = dfs(preorder, inorder, mid+1, right);
        return node;
    }
}
