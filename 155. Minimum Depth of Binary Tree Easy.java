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

//////////////////////
// Solution 1 D & C //
//////////////////////

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        /* special occasion -- leaf node */
        if (root.left == null && root.right == null) {
            return 1;
        }
        /*
        int left, right;
        if (root.left == null) {
            left = Integer.MAX_VALUE;
        } else {
            left = minDepth(root.left);
        }
        
        if (root.right == null) {
            right = Integer.MAX_VALUE;
        } else {
            right = minDepth(root.right);
        }
        */
        int left = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
        int right = root.right == null ? Integer.MAX_VALUE : minDepth
        (root.right);

        return Math.min(left, right) + 1;
    }
}

/*
    Some details worth considering during the thinking process.
    Yield the weight when it's null since we want the smallest
 */

/////////////////////////
// Solution 2 Traverse //
/////////////////////////
    
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    public int getMin(TreeNode root){
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
}