import java.util.HashMap;
import java.util.Map;

public class LRUCache146_V2 {
//    https://leetcode.com/problems/lru-cache/discuss/640199/Java%3A-3-in-1-solution(LinkedList%2BHashMap-OR-LinkedHashMap-OR-Custom-LinkedList-%2B-HashMap)/549072/
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value ) {
            this.key=key;
            this.value=value;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    private int capacity;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache146_V2(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev= head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            delete(curr);
            setListHead(curr);
            return curr.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            curr.value = value;
            delete(curr);
            setListHead(curr);
        } else {
            if(map.size()==capacity) delete(tail.prev);
            setListHead(new Node(key, value));
        }
    }

    //setListHead received node after head
    private void setListHead(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        node.next=headNext;
        headNext.prev = node;

        head.next=node;
        node.prev = head;
    }

    //delete received node
        private void delete(Node node) {
        map.remove(node.key);
        Node nodeNext = node.next;
        Node prev = node.prev;

        prev.next= nodeNext;
        nodeNext.prev=prev;
    }
}
