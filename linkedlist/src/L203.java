/*
*
* 203. Remove Linked List Elements
*
* Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
*
* */

public class L203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }
}
