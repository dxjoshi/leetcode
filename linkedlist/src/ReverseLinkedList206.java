/*
*
* 206. Reverse Linked List
*
* Given the head of a singly linked list, reverse the list, and return the reversed list.
*
* */
public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return curr;
    }

    //reverse iterative
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
