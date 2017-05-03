
// Given a linked list, determine if it has a cycle in it.
//  Follow up: Can you solve it without using extra space?
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
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
		if (head == null || head.next == null) {
			return false;
		}		

		ListNode fast;
		ListNode slow;
		fast = head.next;
		slow = head;

		while (fast != slow) {
			if (fast == null || fast.next == null) {
				return false;
			}

			fast = fast.next.next;
			slow = slow.next;
		}

		return true;
    }
}