public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
    	if (head == null || head.next == null) {
    		return null;
    	} 
    	ListNode fast;
    	ListNode slow;
    	fast = head.next;
    	slow = head;
    	while (fast != slow) {
    		if (fast == null || fast.next == null) {
    			return null;
    		}
    		fast = fast.next.next;
    		slow = slow.next;
    	}	

    	// this judgement is most important
    	while (head != slow.next) {
    		head = head.next;
    		slow = slow.next;
    	}

    	return head;
    }
}
