/*
    Write a program to find the node at which the intersection of two singly
    linked lists begins.
 */


/*
    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.

    You may assume there are no cycles anywhere in the entire linked structure.
    Example
    The following two linked lists:

    ++++++++++++++++++++++++++++++++++++++
    A:          a1 → a2
                       ↘
                         c1 → c2 → c3 → null
                       ↗            
    B:     b1 → b2 → b3
    ++++++++++++++++++++++++++++++++++++++
    a1 → a2 → c1 → c2 → c3
               ^        |
               |        v
              b3<- b2<- b1

    ==> find the cycle start
    ++++++++++++++++++++++++++++++++++++++
    a1 → a2 → c1 → c2 → c3 → null
               ^        
               |        
              b3<- b2<- b1

    ==> transform back
    ++++++++++++++++++++++++++++++++++++++    
    begin to intersect at node c1.
 */



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
        /* get the tail of list A */
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }   

        /* connect the two nodes plug in and use */
        node.next = headB;
        ListNode result = listCycleII(headA);

        /* put the pointer back! */
        node.next = null;
        return result;
    }  

    private ListNode listCycleII(ListNode head) {
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
        /* Now n2 points to the start of the loop */
        return fast;
    }
}