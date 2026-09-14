class Node {
    int k;
    int v;
    Node prev = null, next = null;
    public Node(int k, int v) {
        this.k = k;
        this.v = v;
    }
}

class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    int c;
    Node lru, mru;
    
    public LRUCache(int capacity) {
        this.c = capacity;
        lru = new Node(0,0);
        mru = new Node(0,0);
        lru.next = mru;
        mru.prev = lru;
    }

    public void add(Node node) {
        Node prev = mru.prev;
        Node next = mru;

        prev.next = mru.prev = node;
        node.next = next;
        node.prev = prev;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node cpy = map.get(key);
            remove(cpy);
            add(cpy);
            return cpy.v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        map.put(key, new Node(key, value));
        add(map.get(key));
        if(map.size() > this.c) {
            Node cpy = lru.next;
            remove(cpy);
            map.remove(cpy.k);
        }
    }
}
