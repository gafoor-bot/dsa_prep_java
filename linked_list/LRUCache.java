import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /* Link: https://neetcode.io/problems/lru-cache/solution
     * Doubly Linked List Node
     * Stores key-value pairs
     */
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Cache capacity
    private int capacity;

    // HashMap for O(1) access to nodes
    private Map<Integer, Node> map;

    // Dummy head and tail nodes
    // head.next -> Most Recently Used
    // tail.prev -> Least Recently Used
    private Node head;
    private Node tail;

    /**
     * Initialize LRU Cache with given capacity
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy nodes to simplify add/remove logic
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get value by key
     * Moves accessed node to the front (MRU)
     *
     * @param key key to retrieve
     * @return value if key exists, else -1
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Move node to front (MRU)
        remove(node);
        addToFront(node);

        return node.value;
    }

    /**
     * Insert or update key-value pair
     *
     * @param key key to insert/update
     * @param value value to associate with key
     */
    public void put(int key, int value) {

        // If key already exists, update value and move to front
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            remove(node);
            addToFront(node);
            return;
        }

        // If capacity reached, remove LRU item
        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        // Insert new node at front
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToFront(newNode);
    }

    /**
     * Removes a node from the doubly linked list
     */
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * Adds a node right after head (MRU position)
     */
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    /*
     * Time Complexity:
     * - get(key): O(1)
     * - put(key, value): O(1)
     *
     * Space Complexity:
     * O(n)
     * - HashMap + Doubly Linked List storing up to 'capacity' nodes
     */
}
