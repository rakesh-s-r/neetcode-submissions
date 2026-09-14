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
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfss(root, list);
        String s = String.join(",", list);
        return s;
    }

    public void dfss(TreeNode root, List<String> list) {
        if(root == null) {
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        dfss(root.left, list);
        dfss(root.right, list);
    }

    int idx = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] list = data.split(",");
        idx = 0;
        return dfsd(list);
    }

    public TreeNode dfsd(String[] list) {
        if(list[idx].equals("N")) {
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list[idx]));
        idx++;
        node.left = dfsd(list);
        node.right = dfsd(list);
        return node;
    }
}
