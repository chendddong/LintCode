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

/*
Given a linked list and a value x, partition it such that all nodes 
less than x come before nodes greater than or equal to x. 
You should preserve the original relative order of the nodes in
 each of the two partitions. For example, Given 1->4->3->2->5->2 
 and x = 3, return 1->2->2->4->3->5.
*/
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     * using DummyNode
     */
    public ListNode partition(ListNode head, int x) {
    	if (head == null) {
    		return null;
    	}

    	ListNode leftDummy = new ListNode(0);
    	ListNode rightDummy = new ListNode(0);
    	ListNode left = leftDummy;
    	ListNode right = rightDummy;

    	// left -> [nums[] < 3] -> right -> [nums[] > 3]
    	while (head != null) {
    		if (head.val < x) {
    			// connect
    			left.next = head;
    			left = head;
    		} else {
    			right.next = head;
    			right = head;
    		}
    		// move right
    		head = head.next;
    	}

    	right.next = null;
    	left.next = rightDummy.next;
    	return leftDummy.next;
    }
}
