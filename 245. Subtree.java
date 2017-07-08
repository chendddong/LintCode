/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 * -- LeetCode 572
 * -- LintCode 245 
 */

/*
    Example 1:
    Given tree s:

         3
        / \
       4   5
      / \
     1   2
    Given tree t:
       4 
      / \
     1   2
    Return true, because t has the same structure and node values with a subtree of s.
    Example 2:
    Given tree s:

         3
        / \
       4   5
      / \
     1   2
        /
       0 
    Given tree t:
       4
      / \
     1   2
    Return false.
 */

public class Solution {
    /* Use Recursion */
    public static boolean isSubtree(TreeNode T1, TreeNode T2) {
        /* Edge cases */
        if (T2 == null) {
            return true;
        }
        
        if (T1 == null) {
            return false;
        }

        return helper(T1, T2);
    }

    /* Recursively traverse node s */
    private static boolean helper(TreeNode T1, TreeNode T2) {
        if (T1 == null) {
            return false;
        }

        if (isSameRec(T1, T2)) {
            return true;
        } 

        return helper(T1.left, T2) || helper(T1.right, T2);
    }

    /* 
        To see if two trees are the same 
        -- TreeDemo 8 
        -- LintCode 469
        -- LeetCode 100 
     */
    private static boolean isSameRec(TreeNode T1, TreeNode T2) {
        /* (1) */
        if (T1 == null && T2 == null) {
            return true;
        }

        /* (2) */
        if (T1 == null || T2 == null) {
            return false;
        }

        /* (3) */
        return T1.val == T2.val &&
                isSameRec(T1.left, T2.left) && isSameRec(T1.right, T2.right);
    }    
}
