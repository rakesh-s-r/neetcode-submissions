class Node {
    int k;
    int v;
    Node left = null;
    Node right = null;

    public Node(int k, int v) {
        this.k = k;
        this.v = v;
    }
}
class LRUCache {
    int cap = 0;
    Node lru;
    Node mru;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
        lru = new Node(0,0);
        mru = new Node(0, 0);
        lru.right = mru;
        mru.left = lru;
    }

    public void add(Node node) {
        Node prev = mru.left;
        Node next = mru;

        prev.right = next.left = node;
        node.left = prev;
        node.right = next;
    }

    public void remove(Node node) {
        Node prev = node.left, next = node.right;
        prev.right = next;
        next.left = prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        map.put(key, new Node(key, value));
        add(map.get(key));
        if(map.size() > cap) {
            Node node = lru.right;
            remove(node);
            map.remove(node.k);
        }
    }
}
