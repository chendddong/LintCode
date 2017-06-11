/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 */

/*
  The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

  Example
  For example,

     1
      \
       3
      / \
     2   4
          \
           5
  Longest consecutive sequence path is 3-4-5, so return 3.

     2
      \
       3
      / 
     2    
    / 
   1
  Longest consecutive sequence path is 2-3,not 3-2-1, so return 2.
 */


///////////////////////////////////////////
// Solution 0: Traverse + Divide Conquer //
///////////////////////////////////////////

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0); // root , parent, numWithoutRoot
    }
    
    private int helper(TreeNode root, TreeNode parent, int numWithoutRoot) {
        if (root == null) {
            return 0;
        }
        
        int length = 1; // at least we have root
        if (parent != null && root.val == (parent.val + 1)) {
            length = numWithoutRoot + 1;
        }
        
        int left = helper(root.left, root, length);
        int right = helper(root.right, root, length);
        return Math.max(length, Math.max(left, right));
        
    }
}

////////////////////////////////////////////////////
// Solution 1: Another Traverse + Divide Conquer  //
////////////////////////////////////////////////////

public class Solution {
    int longest;
    public int longestConsecutive(TreeNode root) {
        longest = 0;
        helper(root);
        return longest;
    }
    
    // find the longest consecutive from the 'root' node;
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int subLongest = 1; // has the root, important initialization

        int left = helper(root.left);
        int right = helper(root.right);
        
        if (root.left != null && root.left.val - 1 == root.val) {
            subLongest = Math.max(left + 1, subLongest);
        }
        
        if (root.right != null && root.right.val - 1 == root.val) {
            subLongest = Math.max(right + 1, subLongest);
        }
        
        longest = Math.max(longest, subLongest);
        
        return subLongest;
        
    }
}

////////////////////////////////
// Solution 2: Divide Conquer //
////////////////////////////////

public class Solution {
    private class ResultType {
        int maxInSubtree;
        int maxFromRoot;
        public ResultType(int maxInSubtree, int maxFromRoot) {
            this.maxInSubtree = maxInSubtree;
            this.maxFromRoot = maxFromRoot;
        }
    }
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        return helper(root).maxInSubtree;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        // 1 is the root itself.
        ResultType result = new ResultType(0, 1);
        
        if (root.left != null && root.val + 1 == root.left.val) {
            result.maxFromRoot = Math.max(
                result.maxFromRoot,
                left.maxFromRoot + 1
            );
        }
        
        if (root.right != null && root.val + 1 == root.right.val) {
            result.maxFromRoot = Math.max(
                result.maxFromRoot,
                right.maxFromRoot + 1
            );
        }
        
        result.maxInSubtree = Math.max(
            result.maxFromRoot,
            Math.max(left.maxInSubtree, right.maxInSubtree)
        );
        
        return result;
    }
}
