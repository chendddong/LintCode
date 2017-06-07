/**
 * Given a binary tree, find its maximum depth.
 */

/*
    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Example
    Given a binary tree as follow:

      1
     / \ 
    2   3
       / \
      4   5
    The maximum depth is 3.
 */


/////////////////////////
// Solution 1 Traverse //
/////////////////////////


public class Solution {
    /* global var is bad */
    private int depth;
    public int maxDepth(TreeNode root) {
        depth = 0;
        helper(root, 1);

        return depth;
    }

    private void helper(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }

        if (curDepth > depth) {
            depth = curDepth;
        }

        helper(root.left, curDepth + 1);
        helper(root.right, curDepth + 1);

    }
}

//////////////////////
// Solution 2 D & C //
//////////////////////

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
     
    /* The task */
    public int maxDepth(TreeNode root) {
        /* Base */
        if (root == null) {
            return 0;
        }

        /* Divide */
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}

/*
    Always think about the connection between the answer and the left child and
    right child in binary tree problem
 */


/////////////////////////
// Solution 3 non-recu //
/////////////////////////


public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int count = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        
        /* Use queue since it requires the number of 'levels' */
        /* preorder */
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
 
            }
        }
        
        return count;
    }
}