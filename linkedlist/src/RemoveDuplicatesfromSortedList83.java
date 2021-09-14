/*
*
* 83. Remove Duplicates from Sorted List
*
* Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well
*
* */
public class RemoveDuplicatesfromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) { return head;}
        ListNode curr = head.next, prev = head;
        while (curr != null) {
            if (prev.val != curr.val) {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = curr;
        return head;

    }
}
