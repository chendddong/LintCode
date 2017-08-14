/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
    	// what we should do is to break this problem into pieces
    	// 					1->2->3->4->5 
    	// For k = 2 return 2->1->4->3->5


    	// For k = 3 return 3->2->1->4->5
    	// head : 1
    	// => 3->2->1->4->5
    	// return 

    	// dummy->1->2->3->4->5
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;

    	head = dummy;
    	while (true) {
    		head = reverseK(head, k);
    		if (head == null) {
    			break;
    		}
    	}

    	return dummy.next;
    }

    // head -> n1 -> n2 ... nk -> nk+1
    // =>
    // head -> nk -> nk-1 ... n1 -> nk+1
    // return n1

    public ListNode reverseK(ListNode head, int k) {
    	ListNode nk = head;
    	for (int i = 0; i < k; i++) {
    		if (nk == null) {
    			return null;
    		}
    		nk = nk.next;
    	}
    	// there are k number in total
    	if (nk == null) {
    		return null;
    	}

    	// reverse
    	ListNode n1 = head.next;
    	ListNode nkplus = nk.next;
    	ListNode prev = null;
    	ListNode curt = n1;
    	while (curt != nkplus) {
    		ListNode temp = curt.next;
    		curt.next = prev;
    		prev = curt;
    		curt = temp;
    	}

    	// connect
    	head.next = nk;
    	n1.next = nkplus;
    	return n1;
    }

}