class Trie {
    boolean e;
    HashMap<Character, Trie> c;
    public Trie() {
        this.e = false;
        this.c = new HashMap<>();
    }
}
class PrefixTree {
    Trie root;
    public PrefixTree() {
         root = new Trie();
    }

    public void insert(String word) {
        Trie cur = root;
        for(char ch: word.toCharArray()) {
            if(!cur.c.containsKey(ch)) {
                cur.c.put(ch, new Trie());
            }
            cur = cur.c.get(ch);
        }
        cur.e = true;
    }

    public boolean search(String word) {
        Trie cur = root;
        for(char ch: word.toCharArray()) {
            if(!cur.c.containsKey(ch)) {
                return false;
            }
            cur = cur.c.get(ch);
        }
        return cur.e;
    }

    public boolean startsWith(String prefix) {
        Trie cur = root;
        for(char ch: prefix.toCharArray()) {
            if(!cur.c.containsKey(ch)) {
                return false;
            }
            cur = cur.c.get(ch);
        }
        return true;
    }
}
