public class Solution {

    public ListNode detectCycle(ListNode head) {  
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        /* find the meeting point */
        while (fast != null  && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        /* Error check - there is no meeting point and therefore no loop */
        if (fast == null || fast.next == null) {
            return null;
        }

        /*  
            Move slow to Head. Keep fast at Meeting Point. Each are k steps
            from the Loop Start. If they move at the same pace, they must
            meet at Loop Start. 
        */

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        /* Now fast or slow all points to the start of the loop */
        return fast;
    }
}