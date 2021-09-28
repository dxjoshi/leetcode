import java.util.ArrayList;
import java.util.List;

/*
*
* 82. Remove Duplicates from Sorted List II
*
* Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
*
* */
public class RemoveDuplicatesfromSortedListII82 {
    public ListNode deleteDuplicates(ListNode head) {
        //use two pointers, slow - track the node before the dup nodes,
        // fast - to find the last node of dups.
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while(fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;    //while loop to find the last node of the dups.
            }
            if (slow.next != fast) { //duplicates detected.
                slow.next = fast.next; //remove the dups.
                fast = slow.next;     //reposition the fast pointer.
            } else { //no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }

        }
        return dummy.next;
    }
}
