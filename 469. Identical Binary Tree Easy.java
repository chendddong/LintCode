/**
 * Check if two binary trees are identical. Identical means the two binary tree 
 * shave the same structure and every identical position has the same value.
 */

/*
    Example
        1             1
       / \           / \
      2   2   and   2   2
     /             /
    4             4
    are identical.

        1             1
       / \           / \
      2   3   and   2   3
     /               \
    4                 4
    are not identical.
 */


///////////////////////////
// Solution #0 Recursive //
///////////////////////////

    /*
        (1) if two tree are all empty return true.
        (2) if one of those is empty and the other is not, return false
        (3) if two trees are both not empty if their val and their children are
        all the same return true, else return false;
    */
public class Solution {
    public static boolean isSameRec(TreeNode r1, TreeNode r2) {
        /* (1) */
        if (r1 == null && r2 == null) {
            return true;
        }
        
        /* (2) */
        if (r1 == null || r2 == null) {
            return false;
        }

        /* (3) */
        return r1.val == r2.val && 
                isSameRec(r1.left, r2.left) && isSameRec(r1.right, r2.right);
    }
}

////////////////////////////////////////
// Solution #1 Non-Recursion Preorder //
////////////////////////////////////////

public class Solution {
    public boolean isIdentical(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        ArrayDeque<TreeNode> s1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> s2 = new ArrayDeque<>();
        s1.push(p);
        s2.push(q);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode node1 = s1.pop();
            TreeNode node2 = s2.pop();

            /* The root */
            if (node1.val != node2.val) {
                return false;
            }

            /* Right: push right node respectively and then judge the stack */
            if (node1.right != null) {
                s1.push(node1.right);
            }
            if (node2.right != null) {
                s2.push(node2.right);
            }
            if (s1.size() != s2.size()) {
                return false ;
            }

            /* Left: push left node respectively and then judge the stack */
            if (node1.left != null) {
                s1.push(node1.left);
            }

            if (node2.left != null) {
                s2.push(node2.left);
            }

            if (s1.size() != s2.size()) {
                return false ;
            }
        }

        /* Important step to make sure two tree are identical */
        return s1.size() == s2.size();

    }
}

