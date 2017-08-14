// Given a list, rotate the list to the right by k places, where k is non-negative. 
// For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.

public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
    	if (head == null) {
    		return null;
    	}
    	// we can use a function to acheive this!
    	int length = getLength(head);
    	// because it's rotating 
    	k = k % length;
    	// 1->2->3->4->5->NULL and k = 2, return 
    	// 4->5->1->2->3->NULL.
    	// dummy->1->2->3->4->5->NULL
    	// head
    	// tail
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	head = dummy;

    	ListNode tail = dummy;
    	for (int i = 0; i < k; i++) {
    		head = head.next;
    	}
    	// dummy->1->  2  ->3->4->5->NULL
    	// 			  head
    	// tail

    	while (head.next != null) {
    		tail = tail.next;
    		head = head.next;
    	}
   		// dummy->1->  2  ->  3  ->  4   ->   5   ->NULL
    	// 			  						head
    	// 			  		tail


        // the most important part!!!
        // check the swap postion
        // a = b
        // b = c
        // c = null;...
    	head.next = dummy.next;
    	dummy.next = tail.next;
    	tail.next = null;
    	return dummy.next;
    }

    private int getLength(ListNode head) {
    	int length = 0;
    	while (head != null) {
    		length++;
    		head = head.next;
    	}
    	return length;
    }
}