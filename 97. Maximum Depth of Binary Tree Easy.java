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
