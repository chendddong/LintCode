/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 */

/*
    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

    Note: We do not consider a binary tree to be a binary search tree if it
    contains duplicate values. And a single node tree is a BST
 */



////////////////////////////
// Solution 0 Squeeze it  //
////////////////////////////

/**
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

/* 
    I think the O-(n) where n is the range of the problem.
    Could be faster than we thought 
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        /* range of values in problem */        
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
    }
    private boolean checkBST(TreeNode node, int min, int max) {
        /* Base case */
        if (node == null) {
            return true;
        } else if (node.val < min || node.val > max) {
            return false;
        }
        return checkBST(node.left, min, node.val - 1) && checkBST(node.right, node.val + 1, max);
    }
}

/////////////////////////
// Solution 1 Traverse //
/////////////////////////

public class Solution {
    /* Global Variable */
    private TreeNode lastNode = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (lastNode != null && lastNode.val >= root.val) {
            return false;
        }

        lastNode = root;

        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}

/*
    Based on the in-order traversal since the in-order traversal is sequential.
    left - root - right
 */

////////////////////////////////////
// Solution 2  Divide and Conquer //
////////////////////////////////////

/**
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
 
class ResultType {
    boolean isBST;
    int max, min;
    ResultType(boolean isBST, int max, int min) {
        this.isBST = isBST;
        this.max = max;
        this.min = min;
    }
}
public class Solution {
    public boolean isValidBST(TreeNode root) {
        ResultType r = validHelper(root);
        return r.isBST;
    }
    /* Task: return the ResultType of the tree with the root of 'root' */
    private ResultType validHelper(TreeNode root) {
        /* Base Case */
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        /* Divide */
        ResultType left = validHelper(root.left);
        ResultType right = validHelper(root.right);
        
        /* Early stops where the tree is not the BST */
        if (!left.isBST || !right.isBST || 
            root.left != null && left.max >= root.val ||
            root.right != null && right.min <= root.val) {
            return new ResultType(false, 0, 0);
        }
        /* Go deep */
        return new ResultType(true, Math.max(right.max, root.val), 
                                    Math.min(left.min, root.val));
    }
}

/*
    The [resultType] of things!

    An experience:
        When writing the long if clause, it's better to consider the abnormal
        situation first, and then process the normal ones; It would reduce the
        chance to make some errors during constructing the clause.

        E.G.
            if (!something || !elsesomething) {
                // return;
                // return false;
                // break;...
                // continue;...
            }

            
 */


