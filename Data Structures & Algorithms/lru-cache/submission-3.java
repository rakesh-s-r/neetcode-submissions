class Node {
    int key;
    int val;
    Node prev = null, next = null;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    int cap = 0;
    Node lru;
    Node mru;

    public LRUCache(int capacity) {
        this.cap = capacity;
        lru = new Node(0,0);
        mru = new Node(0,0);
        lru.next = mru;
        mru.prev = lru;
    }

    public void add(Node node){
        Node prev = mru.prev;
        Node next = mru;

        prev.next = node;
        next.prev = node;
        node.prev = prev;
        node.next = next;
    }

    public void remove(Node node){
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
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
        if(map.size() > cap) {
            Node l = lru.next;
            remove(l);
            map.remove(l.key);
        }
    }
}
