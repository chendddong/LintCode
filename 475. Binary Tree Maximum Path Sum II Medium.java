/**
 * Given a binary tree, find the maximum path sum from root.
 * The path may end at any node in the tree and contain at least one node in
 * it.
 */
 
/*
    Example
    Given the below binary tree:
    
      1
     / \
    2   3
    return 4. (1->3)
*/

public class Solution {
     
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        /* 
           Must have the root value, if the children are smaller than 0, 
           just drop it
        */
        return Math.max(0, Math.max(left, right)) + root.val;
        
    }
}