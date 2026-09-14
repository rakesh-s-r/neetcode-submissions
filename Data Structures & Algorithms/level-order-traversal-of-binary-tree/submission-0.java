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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    public void dfs(TreeNode root, int index, List<List<Integer>> list) {
        if(root == null) {
            return;
        }
        if(list.size() == index) {
            list.add(new ArrayList<>());
        }
        list.get(index).add(root.val);
        dfs(root.left, index+1, list);
        dfs(root.right, index+1, list);
    }
}
