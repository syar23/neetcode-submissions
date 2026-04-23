class LRUCache {


    private static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private final int capacity;
    private final Map<Integer, Node> map;

    // Dummy head/tail to avoid null checks
    private final Node head = new Node(-1, -1); // MRU side
    private final Node tail = new Node(-1, -1); // LRU side

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head.next = tail;
        tail.prev = head;      
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) 
            return -1;

        moveToFront(node);  // mark as recently used
        return node.value;     
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            node.value = value;
            moveToFront(node); // put counts as use
            return;
        }

        // Insert new
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToFront(newNode);

        // Evict if over capacity
        if (map.size() > capacity) {
            Node lru = tail.prev;     // real LRU node
            remove(lru);
            map.remove(lru.key);
        }

    }

    // ----- Doubly Linked List helpers -----

    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        // head <-> node <-> head.next
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
