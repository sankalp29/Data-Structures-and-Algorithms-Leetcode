/*
    https://leetcode.com/problems/lru-cache/
*/

class LRUCache {
    int capacity;
    DoublyLinkedList ll;
    Map<Integer, Node> cache;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.ll = new DoublyLinkedList();
        this.cache = new HashMap<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        int value = node.value;
        ll.placeInFront(node);

        return value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            ll.placeInFront(node);
            return;
        }

        Node node = ll.addNode(key, value);
        cache.put(key, node);
        
        if (cache.size() > capacity) {
            Node tail = ll.removeTail();
            cache.remove(tail.key);
        }
    }

    private static class DoublyLinkedList {
        Node head, tail;
        
        public DoublyLinkedList() {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        public Node addNode(int key, int value) {
            Node node = new Node(key, value);
            addInFront(node);
            
            return node;
        }

        public void addInFront(Node node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public Node removeTail() {
            if (tail.prev == head) return null;
            Node last = tail.prev;
            last.prev.next = tail;
            tail.prev = last.prev;

            return last;
        }

        public void placeInFront(Node node) {
            removeNode(node);
            addInFront(node);
        }
    }

    private static class Node {
        Node next;
        Node prev;
        int value;
        int key;

        public Node (int key, int value) {
            this.next = null;
            this.prev = null;
            this.value = value;
            this.key = key;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */