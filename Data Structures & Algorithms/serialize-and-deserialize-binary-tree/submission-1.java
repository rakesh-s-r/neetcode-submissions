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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        dfss(root, res);
        return String.join(",", res);
    }

    public void dfss(TreeNode root, List<String> res) {
        if (root == null) {
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfss(root.left, res);
        dfss(root.right, res);
    }

    int idx;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.split(",");
        idx = 0;
        return dfsd(res);
    }

    public TreeNode dfsd(String[] res) {
        if (res[idx].equals("N")) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(res[idx]));
        idx++;
        root.left = dfsd(res);
        root.right = dfsd(res);
        return root;
    }
}
