// Given a binary tree, return all root-to-leaf paths.

/*
    Example
    Given the following binary tree:

       1
     /   \
    2     3
     \
      5
    All root-to-leaf paths are:

    [
      "1->2->5",
      "1->3"
    ]
 */

///////////////////////////
// Solution 0 : traverse //
///////////////////////////

public class Solution {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        helper(root, String.valueOf(root.val), result);
        return result;
    }
    
    private void helper(TreeNode root, String path, List<String> result) {
        /* precaution */
        if (root == null) {
            return;
        }
        
        /* Leaf */
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        
        /* Go left */
        if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), result);
        }
        
        /* Go right */
        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
}

/*
    Thoughts:

    Because the path is constantly changing, we do not need to backtracking the
    path like what we did in the problem 376.

    We could try to use a string builder for this mission. It turns out we can't
    use the stringBuilder as what we did in 376 since we cannot backtracking a
    string builder and the length of the string is unknown.

    Convert the int val to a string String.valueOf(int val);
*/


///////////////////////////////
// Solution 1 Divide Conquer //
///////////////////////////////

public class Solution {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        /* Loop and concatenate the path */
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }
        
        /* root is a leaf */
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }
        
        return paths;
    }
}

/*
    Pretty neat and no need to convert the value and WOW!
 */