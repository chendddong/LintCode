/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Given a linked list and two values v1 and v2. Swap the two nodes in the linked 
// ist with values v1 and v2. Its guaranteed there is no duplicate values in the 
// nked list. If v1 or v2 does not exist in the given linked list, do nothing.
// Notice
// You should swap the two nodes with values v1 and v2. 
// Do not directly swap the values of the two nodes

// Given 1->2->3->4->null and v1 = 2, v2 = 4.
// Return 1->4->3->2->null.


public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
    //dummy->1->   2  ->3->   4   ->null
        ListNode node1Prev = null;
        ListNode node2Prev = null;
    //pointer
        ListNode cur = dummy;
    // remember the boundry
        while (cur.next != null) {
            if (cur.next.val == v1) {
                node1Prev = cur;
            } else if (cur.next.val == v2) {
                node2Prev = cur;
            }
        // increment
            cur = cur.next;
        }

    // no nead to swap!
        if (node1Prev == null || node2Prev == null) {
            return head;
        }

        if (node2Prev.next == node1Prev) {
        // make sure node1Prev is before node2Prev
        // swaps the prenode if they are not in the order they are supposed to be
            ListNode t = node1Prev;
            node1Prev = node2Prev;
            node2Prev = t;
        }

    //dummy->1->   2  ->3->   4   ->null
        ListNode node1 = node1Prev.next;
        ListNode node2 = node2Prev.next;
        ListNode node2Next = node2.next;
    // they are adjacent
        if (node1Prev.next == node2Prev) {
            node1Prev.next = node2;
            node2.next = node1;
            node1.next = node2Next;

    // they are not adjacent
        } else {
            node1Prev.next = node2;
            node2.next = node1.next;

            node2Prev.next = node1;
            node1.next = node2Next;
        }

        return dummy.next;
    }
}