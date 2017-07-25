/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 */

/*
     Notice

    The minimum number of nodes in list is n.

    Example
    Given linked list: 1->2->3->4->5->null, and n = 2.
                       i     j
    After removing the second node from the end, the linked list becomes 1->2->3->5->null.
 */

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 

//////////////////////////////
// Straightforward thinking //
//////////////////////////////

public class Solution {
    /* We could use two pointers */ 
    ListNode removeNthFromEnd(ListNode head, int n) {
        /* Check edges */ 
        if (head == null || n == 0 || checkN(head, n) == -1) {
            return null;
        }

        // Given linked list: 1->2->3->4->5->null, and n = 2.
        //                          i     j
        
        /* If the node is the head */                              
        if (checkN(head, n) == n) {
            return head.next;
        }

        /* Find the node before the nth form end which is 'slow' */
        int i = 0;              
        int j = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (j - i == n) {
                break;
            }
            fast = fast.next;
            j++;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        /* Delete and Connect */
        slow.next = slow.next.next;

        return head;
    }
    private int checkN(ListNode head, int n) {
        int numNode = 0;
        ListNode cur = head;
        while (head != null) {
            head = head.next;
            numNode++;
        }
        if (numNode >= n) {
            return numNode;
        }
        return -1;
    }
}


////////////////
// Dummy node //
////////////////

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }

        // Given linked list: 1->2->3->4->5->null, and n = 2.  
        // dummy(0)->1->2->3->4->5->null      
        //                 p        h
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode preDelete = dummy;
        /* 
            Check the n in here; Clever move; Fast-forward n step to be the
            fast node.
         */
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            } 
            head = head.next;
        }
        /* Go right, lock the preDelete to the right position */
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        /* Delete and connect */
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}