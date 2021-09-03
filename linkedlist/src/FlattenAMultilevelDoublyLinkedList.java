/*
*
* 430. Flatten a Multilevel Doubly Linked List
*
* You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
* Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
*
* */

import java.util.LinkedList;
import java.util.List;

public class FlattenAMultilevelDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        List<Node> parentNodes = new LinkedList<>();
        Node trav = head;

        while(trav != null) {
            if (trav.child != null) {
                if  (trav.next != null) {
                    parentNodes.add(trav.next);
                }
                trav.next = trav.child;
                trav.child.prev = trav;
                trav.child = null;
            }
            if (trav.next == null && parentNodes.size() > 0) {
                Node next = parentNodes.get(parentNodes.size()-1);
                trav.next = next;
                next.prev = trav;
                parentNodes.remove(parentNodes.size()-1);
            }
            trav = trav.next;
        }
        return head;
    }

}
