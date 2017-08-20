/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 */

/*
    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    Example 1:
        2
       / \
      1   3
    Binary tree [2,1,3], return true.
    Example 2:
        1
       / \
      2   3
    Binary tree [1,2,3], return false.
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


/////////////////
// Squeeze it  //
/////////////////

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

public class Solution {
    /* 
        I think the O-(n) where n is the range of the problem.
        Could be faster than we thought 
     */
    public boolean isValidBST(TreeNode root) {
        /* range of values in problem */        
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE); 
    }
    private boolean checkBST(TreeNode node, long min, long max) {
        /* Base case */
        if (node == null) {
            return true;
        } else if (node.val <= min || node.val >= max) { /* Note the Edge */
            return false;
        }
        return checkBST(node.left, min, Math.min(max, node.val)) && checkBST(node.right, Math.max(min, node.val), max); /* Note the Edge */
    }
}

///////////////////////
// Inorder  Traverse //
///////////////////////

public class Solution {
    /* Global Variable */
    private TreeNode lastNode = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        /* Left */
        if (!isValidBST(root.left)) {
            return false;
        }

        /* Root */
        if (lastNode != null && lastNode.val >= root.val) {
            return false;
        }
        lastNode = root;

        /* Right */
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

///////////////
// Recursive //         Good practice for ResultType
///////////////

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
 */

////////////////////////
// Inorder traversal  //    The goto option
////////////////////////

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            /* Solve problem */
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
