/*
*
* */
public class RotateList61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode res = head;
        int i = 0;
        while (res != null) {
            res = res.next;
            i++;
        }
        k = k%i;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode prev = null;
        while (head != null) {
            if (k<= 0) {
                slow = slow.next;
            }
            prev = head;
            head = head.next;
            k--;
        }
        //
        prev.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if(head == null || k == 0) {
            return head;
        }
        ListNode p = head;
        int len = 1;
        while(p.next != null) {
            p = p.next;
            len++;
        }
        p.next = head;
        k %= len;
        for(int i = 0; i < len - k; i++) {
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
