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

// Merge two sorted linked lists and return it as a new list. 
// The new list should be made by splicing together the nodes 
// of the first two lists.

public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(0);
    	ListNode lastNode = dummy;

    	while (l1 != null && l2 != null) {
    		if (l1.val < l2.val) {
    			lastNode.next = l1;
    			l1 = l1.next;
    		} else {
    			lastNode.next = l2;
    			l2 = l2.next;
    		}

    		lastNode = lastNode.next;
    	}

    	if (l1 != null) {
    		lastNode.next = l1;
    	} else {
    		lastNode.next = l2;
    	}

    	return dummy.next;
    }
}