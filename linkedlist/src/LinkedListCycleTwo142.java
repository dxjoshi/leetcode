/*
*
* 142. Linked List Cycle II
*
* Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
* There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
*
* */
public class LinkedListCycleTwo142 {
    public ListNode detectCycle(ListNode head) {
        // If single node then return null
        if (head == null || head.next == null) {
            return null;
        }

        ListNode start = head;
        ListNode slow = head;
        ListNode fast = head;
        // Solving this problem using slow and fast pointer
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Got the cycle here
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }
}
