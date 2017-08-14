// Given a node from a cyclic linked list which has been sorted, 
// write a function to insert a value into the list such that it 
// remains a cyclic sorted list. The given node can be any single node in the list. 
// Return the inserted new node.
/**
 * Definition for ListNode
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
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
   		if (node == null) {
   			node = new ListNode(x);
   			node.next = node;
   			return node;
   		}

   		ListNode p = node;
   		ListNode prev = null;

   		do {
   			prev = p;
   			p = p.next;
   			if (x <= p.val && x >= prev.val) {
   				break;
   			}
   			if ((prev.val) > p.val) && (x < p.val || x > prev.val) {
   				break;
   			}
   		} while (p != node)

   		ListNode newNode = new ListNode(x);
   		newNode.next = p;
   		prev.next = newNode;
   		return newNode;
   	}
}

/*
// edge cases

// set pointers

// do while()

// think about the cases!

// connect
*/