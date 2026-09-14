class Node {
    int key;
    int val;
    Node prev = null;
    Node next = null;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node mru;
    Node lru;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mru = new Node(0, 0);
        lru = new Node(0, 0);
        mru.prev = lru;
        lru.next = mru;
    }

    public void add(Node node){
        Node prev = mru.prev;
        Node next = mru;

        prev.next = next.prev = node;
        node.prev = prev;
        node.next = next;
    }

    public void remove(Node node){
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    };
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node cpy = map.get(key);
            remove(cpy);
            add(cpy);
            return cpy.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }

        map.put(key, new Node(key, value));
        add(map.get(key));
        if(map.size() > capacity) {
            Node cpy = lru.next;
            remove(cpy);
            map.remove(cpy.key);
        }
    }
}
