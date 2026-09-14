/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return String.join(",", res);
    }

    public void dfs(TreeNode root, List<String> res) {
        if(root == null) {
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfs(root.left, res);
        dfs(root.right, res);
    }


    int idx = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] chs = data.split(",");
        return build(chs);
    }

    public TreeNode build(String[] chs) {
        if(chs[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(chs[idx]));
        idx++;

        root.left = build(chs);
        root.right = build(chs);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));