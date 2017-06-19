/**
 * Given the root and two nodes in a Binary Tree. Find the lowest
 * common ancestor(LCA) of the two nodes.
 */

/*
    The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

    Assume two nodes are exist in tree.

    Example
    For the following binary tree:

      4
     / \
    3   7
       / \
      5   6

    LCA(3, 5) = 4

    LCA(5, 6) = 7

    LCA(6, 7) = 7
 */

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

/////////////////////
// Solution 0 D&C  //
/////////////////////


public class Solution {
    /* 
        Thoughts:
        Find the LCA of node A,B in the binary tree with root root
        If we find it, then return the LCA
        If we only find A, return A
        If we only find B, return B
        If we find neither of them, return null
    */
    /* Task: Find the LCA of node A,B in the binary tree */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B){
        /* Base case */
        if(root == null || root == A || root == B) {
            return root;
        }

        /* Divide */
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        /* Solve the problem */

        /* Both sides have LCA */
        if (left != null && right != null) {
            return root;
        }
        /* left side has LCA */
        if (left != null) {
            return left;
        }
        /* right side has LCA */
        if (right != null) {
            return right;
        }
        return null;

    }
}

///////////////////////////
// Solution 1 ResultType //
///////////////////////////

class ResultType {
    public TreeNode lca;
    public int count;
    public ResultType(TreeNode lca, int count) {
        this.lca = lca;
        this.count = count;
    }
}

public class Solution {
    /* 
        Thoughts:
        Find the LCA of node A,B in the binary tree with root root
        If we find it, then return the LCA
        If we only find A, return A
        If we only find B, return B
        If we find neither of them, return null
    */
    /* Task: Find the LCA of node A,B in the binary tree */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B){
        return helper(root, A, B).lca;
    }

    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(null, 0);
        }
        /* Base case */
        if (root == A || root == B) {
            return new ResultType(root, 1);
        }

        /* Divide */
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);

        /* Solve the problem */
        /* Count is the number A and B found in the tree */
        if (left.count == 1 && right.count == 1) {
            return new ResultType(root, 2);
        }
        if (left.count == 2) {
            return new ResultType(left.lca, 2);
        } 
        if (right.count == 2) {
            return new ResultType(right.lca, 2);
        }
        
        if (left.count == 1 && right.count == 0) {
            return new ResultType(left.lca, 1);
        }
        if (right.count == 1 && left.count == 0) {
            return new ResultType(right.lca, 1);
        }
        
        return new ResultType(null, 0);        
    }
}
