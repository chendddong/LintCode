/**
 * Give a binary tree, and a target number, find all path that the sum of   nodes
 * equal to target, the path could be start and end at any node in the tree.
 */

/*
    Example
    Given binary tree:

        1
       / \
      2   3
     /
    4
    and target = 6. Return :

    [
      [2, 4],
      [2, 1, 3],
      [3, 1, 2],
      [4, 2]
    ]
 */

/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public int val;
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    

    
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        List<List<Integer>> results = new ArrayList<>();
        helper(root, target results);
        return results;
    }

    //     1
    //    / \
    //   2   3
    //  /
    // 4
    // and target = 6. Return :

    // [
    //   [2, 4],
    //   [2, 1, 3],
    //   [3, 1, 2],
    //   [4, 2]
    // ]        
    
    private void helper(ParentTreeNode root,
                        int target,
                        List<List<Integer>> results) {
        if (root == null) {
            return;
        }

        /* Find the target with this root node as the root */
        List<Integer> path = new ArrayList<Integer>();
        findSum(root, null, target, path, results);

        helper(root.left, target, results);
        helper(root.right, target, results);
    }

    private void findSum(ParentTreeNode root,
                         ParentTreeNode father,
                         int target,
                         List<Integer> path,
                         List<List<Integer>> results) {
        path.add(root.val);
        target -= root.val;

        if (target == 0) {
            /* Deep copy an ArrayList */
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            Collections.addAll(tmp, new Integer[path.size()]);
            Collections.copy(tmp, path);

            /* Add one of the paths to the results */
            results.add(tmp);
        }

        if (root.parent != null && root.parent != father) {
            findSum(root.parent, root, target, path, results);
        }

        if (root.left != null && root.left != father) {
            findSum(root.left, root, target, path, results);
        }

        if (root.right != null && root.right != father) {
            findSum(root.right, root, target, path, results);
        }

        /* DFS backtracking */
        path.remove(path.size() - 1);
    }
}