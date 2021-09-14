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
}
