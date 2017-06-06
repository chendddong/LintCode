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
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;

    }
}
