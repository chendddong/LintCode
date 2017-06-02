/*
    Given a linked list, determine if it has a cycle in it.
    Follow up: Can you solve it without using extra space?
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

public class Solution {
    /* If "slow" and "fast" collide, we must have a cycle */
    public boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        
        Node slow = head; // moves 1 Node  at a time
        Node fast = head; // moves 2 Nodes at a time
        
        /* Work both for odd and even number of Nodes */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // since "slow" and "fast" collided
            }
        }
        return false;
    }
}