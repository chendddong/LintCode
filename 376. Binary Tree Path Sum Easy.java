/**
 * Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
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
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        helper(root, path, root.val, target, result);
        return result;
    }

    private void helper(TreeNode root,
                        ArrayList<Integer> path,
                        int sum,
                        int target,
                        List<List<Integer>> result) {
        /* Down to the leaf */
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integr>(path));
            }
            return;
        }

        /* Go left */
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, path, sum + root.left.val, target, result);
            // backtracking
            path.remove(path.size() - 1);
        }

        /* Go right */
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, path, sum + root.right.val, target, result);
            path.remove(path.size() - 1);
        }
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

    4. Don't forget the back tracking.
*/