/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        return dfs(node);
    }

    public Node dfs(Node node) {
        if(map.containsKey(node)) {
            return map.get(node);
        }

        Node cpy = new Node(node.val);
        map.put(node, cpy);
        for(Node child: node.neighbors) {
            cpy.neighbors.add(dfs(child));
        }
        return cpy;
    }
}