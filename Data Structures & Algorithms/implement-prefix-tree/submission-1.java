class Node {
    boolean eow;
    HashMap<Character, Node> childrens;

    public Node() {
        this.eow = false;
        this.childrens = new HashMap<>();
    }
}
class PrefixTree {
    Node root = new Node();

    public PrefixTree() {
         
    }

    public void insert(String word) {
        Node cur = root;
        for(char ch: word.toCharArray()) {
            if(!cur.childrens.containsKey(ch)) {
                cur.childrens.put(ch, new Node());
            }
            cur = cur.childrens.get(ch);
        }
        cur.eow = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for(char ch: word.toCharArray()) {
            if(!cur.childrens.containsKey(ch)) {
                return false;
            }
            cur = cur.childrens.get(ch);
        }
        return cur.eow;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char ch: prefix.toCharArray()) {
            if(!cur.childrens.containsKey(ch)) {
                return false;
            }
            cur = cur.childrens.get(ch);
        }
        return true;
    }
}
