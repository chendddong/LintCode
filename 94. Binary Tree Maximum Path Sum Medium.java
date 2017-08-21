/*
 * Given a binary tree, find the maximum path sum. The path may start and
 * end at any node in the tree.
 */

/*
    Have you met this question in a real interview? Yes
    Example
    Given the below binary tree:

      1
     / \
    2   3
    return 6.
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

////////////////////////////////////////
// SinglePath must contain >= 1 nodes //
////////////////////////////////////////

public class Solution {
    private class ResultType {
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }

    /* Task: find the single_path and max_path of the tree with the root */
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        /* Divide */
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        /* Solve problem */
        int singlePath = 
            Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;
        /* Draw and think about the comparison */
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath,
                               Math.max(left.singlePath, 0)
                               + Math.max(right.singlePath, 0) 
                               + root.val);

        return  new ResultType(singlePath, maxPath);
    }
}

/////////////////////////////
// singlePath can be empty //
/////////////////////////////

public class Solution {
    private class ResultType {
        int singlePath, maxPath; 
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }

        /* Divide */
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        /* Conquer */
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
}

/*
    Good one. Must review.
    Stick to the Overview there are three big situation
    1.  the maxPath comes from left child
    2.  the maxPath comes from right child
    3.  the maxPath must go through the root
    
    draw it accordingly it's a must
 */


/*
    Thought:

    A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or more steps. Once it goes down, it can't go up. Each path has a highest node, which is also the lowest common ancestor of all other nodes on the path.

    A recursive method maxPathDown(TreeNode node):
        (1) computes the maximum path sum with highest node is the input node, update maximum if necessary 
        (2) returns the maximum sum of the path that can be extended to input node's parent.    
 */

///////////////////////
// A Global variable //         Recursive is much cleaner
///////////////////////

public class Solution {
    int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left)); /* Pruning negative */
        int right = Math.max(0, maxPathDown(node.right));
        
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}   
 