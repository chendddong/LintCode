/**
 * Given a singly linked list where elements are sorted in ascending
 * order,convert it to a height balanced BST.
 *
 * -- TreeDemo 22.2
 * -- LintCode 106
 * -- LeetCode 109
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/*
    Example && work through
    1->2->3 ->4-> 5->6->7->null
    s  s  s   s
       f      f     f     f

    1->2->3->4->5->6->null
    s  s  s
       f     f     f
       
                4
              /  \
             2    6
            /\    /\
           1 3   5  7

 */
public class Solution {
    /* Recording the node before the mid */
    ListNode pre = null;
    /* We are going to find the middle for each part */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;    
        }
        
        /* Find middle */        
        ListNode middle = findMid(head);
        
        /* Create the root */
        TreeNode root = new TreeNode(middle.val);   
        
        /* Right part 'root' */
        ListNode temp = middle.next;
        /* There is only one node */
        if (temp == null) {
            return root;
        } 
        
        /* Set left part tail to null */
        if (pre != null) {
            pre.next = null;   
        }

        /* Go left -- Do not need to do the recursive thing if the middle is head */
        if (middle != head) {
            root.left = sortedListToBST(head);
        }
        
        /* Go right */
        root.right = sortedListToBST(temp);

        return root;
    }
    /* Find the middle node of a linked list */
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }
}

///////////////////////////////
// Inorder Binary Connecting //
///////////////////////////////

public class Solution {

    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        int size;
        current = head;
        size = getListLength(head);

        return sortedListToBSTHelper(size);
    }
    /* Algorithm walk through */

    //      4
    //    /   \
    //   2     6
    //  / \   / \ 
    // 1   3  5  7

    // 1->2->3->4->5->6->7->null 
    // sortedListToBSTHelper(7) return T-4  left = T-2  right = T-6
    // sortedListToBSTHelper(3) return T-2, left = T-1, right = T-3
    // sortedListToBSTHelper(1) return T-1, left = null, right = null, 
    // sortedListToBSTHelper(0) return null  
    // sortedListToBSTHelper(0) return null 
    // sortedListToBSTHelper(3) return T-6, left = T-5, right = T-7

    private TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }
        /* Inorder traversal left root right */
        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next; /* Move the LinkedList Pointer */
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }
    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}

/////////////////////////
// Head Tail Recursive //
/////////////////////////

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        /* Edge */
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }
    private TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;

        /* Clever Base */
        if (head == tail) {
            return null;
        }

        // 1->2->3->4->5->6->7->null 
        //          s
        //                   f  

        /* Get the middle node slow by using TAIL */
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        /* Preorder */
        TreeNode newHead = new TreeNode(slow.val);
        newHead.left = toBST(head, slow);
        newHead.right = toBST(slow.next, tail);

        return newHead;
    }
}
