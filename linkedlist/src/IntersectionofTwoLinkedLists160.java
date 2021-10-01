/*
*
* 160. Intersection of Two Linked Lists
*
* Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
* For example, the following two linked lists begin to intersect at node c1:
*
* */
public class IntersectionofTwoLinkedLists160 {
/*
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB== null) return null;
        ListNode t1= headA, t2=headB;
        while(t1!=t2) {
            t1 = t1!=null ? t1.next : headB;
            t2 = t2!=null ? t2.next : headA;
        }
        return t1;
    }
*/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB== null) return null;

        StringBuilder b = new StringBuilder(); 
        ListNode t1= headA, t2=headB;
        while(t1!=null && t2!=null && t1!=t2) {
            t1 = t1.next;
            t2 = t2.next;
            if (t1==t2) return t1;

            if (t1==null) t1 = headB;
            if (t2==null) t2 = headA;
        }
        return t1;



    }
}
