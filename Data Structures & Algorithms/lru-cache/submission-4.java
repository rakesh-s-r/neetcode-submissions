class Node {
    int key;
    int value;
    Node prev = null, next = null;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    int cap;
    Node lru = new Node(0,0);
    Node mru = new Node(0,0);

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.lru.next = mru;
        this.mru.prev = lru;
    }

    public void add(Node node) {
        Node prev = mru.prev, next = mru;
        prev.next = next.prev = node;
        node.prev = prev;
        node.next = next;
    }

    public void remove(Node node) {
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node cpy = map.get(key);
            remove(cpy);
            add(cpy);
            return cpy.value;
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
            Node cpy = lru.next;
            remove(cpy);
            map.remove(cpy.key);
        }
    }
}
