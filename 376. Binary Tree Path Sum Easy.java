/**
 * Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
 * 
 * -- LeetCode 113
 * -- LintCode 376
 * -- TreeDemo 24.2
 */

/*
    A valid path is from root node to any of the leaf nodes.

    Example
    Given a binary tree, and target = 5:

         1
        / \
       2   4
      / \
     2   3
    return

    [
      [1, 2, 2],
      [1, 4]
    ]
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
//////////////////////////////////////
// Add value before recursion + sum //
//////////////////////////////////////

public class Solution {

    /* 
      Since we need the total sum from root to leaf, it's could not be more
      obvious that it's DFS
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        /* Add root val before the recursion starts */
        path.add(root.val);
        /* We need both single path the final result */
        pathSumIIHelper(root, root.val, sum, path, result);
        return result;
    }

    private void pathSumIIHelper(TreeNode root, 
                               int sum, 
                               int target, 
                               List<Integer> path, 
                               List<List<Integer>> result) {

        /* Base case; Down to the leaf node and solve the problem */
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path)); /* Deep copy */
            }
            /* Don't forget to return cause we're reaching the bottom */
            return;
        }

        /* Go left */
        if (root.left != null) {
            /* Add val before the recursion starts; Same as the root */
            path.add(root.left.val);
            pathSumIIHelper(root.left, sum + root.left.val, target, path, result);
            path.remove(path.size() - 1); /* Backtracking */
        }

        /* Go right (identical to the left side )*/
        if (root.right != null) {
            /* Add val before the recursion starts; Same as the root */
            path.add(root.right.val);
            pathSumIIHelper(root.right, sum + root.right.val, target, path, result);
            path.remove(path.size() - 1); /* Backtracking */
        }        

    }
}


////////////////////////////////
// Add value in the recursion //
////////////////////////////////

public class Solution {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        pathSumIIHelper(root, sum, path, result);
        return result;
    }
    private void pathSumIIHelper(TreeNode root,
                            int sum,
                            List<Integer> path,
                            List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);

        if (root.left == null && root.right == null) {
            /* Important judgment */
            if (sum == root.val) {
                result.add(new ArrayList<Integer>(path));
            } 
            return;
        }

        if (root.left != null) {
            /* Subtract the sum */
            pathSumIIHelper(root.left, sum - root.val, path, result);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            pathSumIIHelper(root.right, sum - root.val, path, result);
            path.remove(path.size() - 1);
        }        

    }
}


//////////////
// Sum == 0 //
//////////////

public class Solution {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        pathSumIIHelper(root, sum, path, result);
        return result;
    }
    private void pathSumIIHelper(TreeNode root,
                            int sum,
                            List<Integer> path,
                            List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        /* Subtract sum first */
        sum -= root.val;

        if (root.left == null && root.right == null) {
            /* Root is the leaf and find the path */
            if (sum == 0) {
                /* Don't forget to check the path and add the leaf */
                path.add(root.val);
                result.add(new ArrayList<Integer>(path));
                /* One more backtracking */                
                path.remove(path.size() - 1);
            } 
            return;
        }

        /* Add first and go recursively */
        path.add(root.val);

        pathSumIIHelper(root.left, sum, path, result);
        pathSumIIHelper(root.right, sum, path, result);

        /* One more backtracking */                
        path.remove(path.size() - 1);
    }
}


/*
    Thoughts:

    1.  It's a bit hard to construct because of the single path and the result
    final result to it and we actually need them all. So don't forget to pass
    all the values that we could.

    2.  Combine the base case and the leaf node together.
        We must always come up with the solutions from the base case.
        For this problem, the leaf node could be the last node or it could not
        be. So just check them before we go deeper

    3.  left and right are identical and we can first go left and then go right,
    and it wouldn't affect the outcome. Just pass the value and let the base
    case judge whether we should go further or directly return.

    4. Don't forget the backtracking.
*/