// Write a program to find the node at which the intersection of two singly linked lists begins.

//  Notice

// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function returns.
// You may assume there are no cycles anywhere in the entire linked structure.
// Example
// The following two linked lists:

// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗            
// B:     b1 → b2 → b3
// begin to intersect at node c1.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) {
    		return null;
    	}	
    	// get the tail of list A
    	ListNode node = headA;
    	while (node.next != null) {
    		node = node.next;
    	}	
    	// connect the two nodes
    	node.next = headB;
    	ListNode result = listCycleII(headA);
    	// put the pointer back!
    	node.next = null;
    	return result;
    }  

    private ListNode listCycleII(ListNode head) {
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