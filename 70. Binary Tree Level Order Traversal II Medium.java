/**
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (i.e. from left to right, level by level from leaf to root).
 * -- LeetCode 102, 107 
 * -- LintCode 69, 70
 * -- TreeDemo 4
 */

/*
    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    /* Classic  BFS, and just use the Collection.reverse() method */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            results.add(level);

        }
        
        Collections.reverse(results);
        return results;
    }
}
