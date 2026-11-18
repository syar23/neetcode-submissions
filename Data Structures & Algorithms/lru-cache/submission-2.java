public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}


class LRUCache {

    private int size;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
            this.size = capacity;
            this.cache = new HashMap<>();
            this.left = new Node(0,0);
            this.right = new Node(0,0);
            this.left.next = this.right;
            this.right.prev = this.left;
    }
    

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node); //
            insert(node); //at rightmost 
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            cache.remove(node.key);
        }
        Node node = new Node(key, value);
        
        if(this.cache.size() >= this.size) {
            Node n = this.left.next;
            remove(n);
            System.out.println(" " + n.key);
            if(cache.containsKey(n.key))
                cache.remove(n.key);
        }
        cache.put(key,node);
        insert(node);
    }
}
