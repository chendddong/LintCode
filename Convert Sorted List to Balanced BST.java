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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 

// Given a singly linked list where elements are sorted in ascending order, 
// convert it to a height balanced BST.

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     * data structure conversion
     */
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head) {  
    	// we first divide the task into small tasks
    	// get size
    	int size;
    	current = head;
    	size = getListLength(head);
    	return sortListToBSTHelper(size);
    }

    private int getListLength(ListNode head) {
    	int size = 0;
    	while (head != null) {
    		size++;
    		head = head.next;
    	}
    	return size;
    }

    private TreeNode sortListToBSTHelper(int size) {
    	// end of recursion
    	if (size <= 0) {
    		return null;
    	}

    	// left root current right
    	// connect
    	// return root;
    	TreeNode left = sortListToBSTHelper(size / 2);
    	TreeNode root = new TreeNode(current.val);
    	current = current.next;
    	TreeNode right = sortListToBSTHelper(size - 1 - size / 2);

    	root.left = left;
    	root.right = right;

    	return root;
    }
}
