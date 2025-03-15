class Node {
    int key;
    int val;
    Node prv, nxt;

    public Node(int key, int val){
        this.key= key;
        this.val= val;
        this.prv= null;
        this.nxt= null;
    }
}
class LRUCache {
    int cap;
    HashMap<Integer,Node> cache;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.cap= capacity;
        this.cache= new HashMap<>();
        this.head= new Node(0,0);
        this.tail= new Node(0,0);
        this.head.nxt= this.tail;
        this.tail.prv= this.head;
    }
    private void remove(Node node){
        Node left= node.prv;
        Node right= node.nxt;
        left.nxt= right;
        right.prv= left;
    }
    private void insert(Node node){
        Node prev= this.tail.prv;
        prev.nxt= node;
        node.prv= prev;
        node.nxt= this.tail;
        this.tail.prv= node;
    }
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node= cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node= cache.get(key);
            remove(node);
            node.val= value;
            insert(node);
        }
        else{
            if(cache.size()==cap){
                Node lru= head.nxt;
                cache.remove(lru.key);
                remove(lru);
            }
            Node node= new Node(key, value);
            cache.put(key,node);
            insert(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */