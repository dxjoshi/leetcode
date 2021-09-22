/*
*
* 706. Design HashMap
*
* Design a HashMap without using any built-in hash table libraries.
*
* Implement the MyHashMap class:
*
* MyHashMap() initializes the object with an empty map.
* void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
* int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
* void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
*
* */
public class DesignHashMap706 {
    class Node {
        int key;
        int val;
        Node next;
        Node (int key, int value) {
            this.key = key;
            this.val = value;
            this.next = null;
        }
    }
    Node[] nodes;
    int length;

    /** Initialize your data structure here. */
    public DesignHashMap706() {
        nodes = new Node[10000];
        length = nodes.length;
    }

    int hashCode(int key) {
        return key % length;
    }

    Node find(Node bucket, int key) {
        Node curr = bucket, prev = null;
        while (curr != null) {
            if (curr.key == key) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = hashCode(key);
        if (nodes[idx] == null) {
            nodes[idx] = new Node(-1, -1);
        }
        Node prev = find(nodes[idx], key);

        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = hashCode(key);
        if (nodes[idx] == null) {
            return -1;
        }
        Node prev = find(nodes[idx], key);

        if (prev.next != null) {
            return prev.next.val;
        }
        return -1;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = hashCode(key);
        if (nodes[idx] == null) {
            return;
        }
        Node prev = find(nodes[idx], key);

        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

}
