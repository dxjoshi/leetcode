/*
*
* 19. Remove Nth Node From End of List
*
* Given the head of a linked list, remove the nth node from the end of the list and return its head.
*
* */
public class L19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (n < 0) {
                slow = slow.next;
            }
            fast = fast.next;
            --n;
        }

        if(n == 0) {
            head = slow.next;
        } else {
            slow.next = slow.next.next;
        }

        return head;

    }
}
