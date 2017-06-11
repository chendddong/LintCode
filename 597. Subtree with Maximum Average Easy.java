/**
 * Given a binary tree, find the subtree with maximum average. 
 * Return the root of the subtree.
 */

/*
    LintCode will print the subtree which root is your return node.
    It's guaranteed that there is only one subtree with maximum average.

    Example
    Given a binary tree:

         1
       /   \
     -5     11
     / \   /  \
    1   2 4    -2 
    return the node 11.
 */


public class Solution {
    private class ResultType {
        public int sum, size;
        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }
    
    private TreeNode subtree = null;
    private ResultType subtreeResult = null;
    
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return subtree;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType result = new ResultType(
            left.sum + right.sum + root.val,
            left.size + right.size + 1
        );
        
        /* 
            Compare the avg between the current best Result and the current
            result.

            say if sumA / sizeA > sumB / sizeB <==> sumA * sizeB > sumB * sizeA 
        */
        if (subtree == null ||
            subtreeResult.sum * result.size < result.sum * subtreeResult.size
        ) {
            subtree = root;
            subtreeResult = result;
        }
        return result;
    }
}

/*
    Thought:

    The idea to isolate the answer outside of the loop!

    If we want to directly calculate the sum and the size at the same time, it
    would be a mess out there.
    
    But honestly, I simply do not like the global variable.
 */