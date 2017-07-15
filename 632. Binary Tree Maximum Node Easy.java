/**
 * Find the maximum node in a binary tree, return the node.
 */

/*
    Example
    Given a binary tree:

         1
       /   \
     -5     2
     / \   /  \
    0   3 -4  -5 
    return the node with value 3.
 */

///////////////
// Recursive //
///////////////

public class Solution {
    int maxValue = Integer.MIN_VALUE;
    TreeNode maxNode = null;
    public TreeNode maxNode(TreeNode root) {
        maxNodeHelper(root);
        return maxNode;
    }
    //      1
    //    /   \
    //  -5     2
    //  / \   /  \
    // 0   3 -4  -5 
    private void maxNodeHelper(TreeNode root) {
        /* Base */
        if (root == null) {
            return;
        }
        /* Update the result */
        if (root.val > maxValue) {
            maxNode = root;
            maxValue = root.val;
        }  
        maxNodeHelper(root.left);
        maxNodeHelper(root.right);              
    }
}

///////////////
// Traversal //
///////////////

public class Solution {
    /* Use preorder traversal */
    public TreeNode maxNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        int maxValue = Integer.MIN_VALUE;
        TreeNode result = null;

        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node.val > maxValue) {
                result = node;
                maxValue = node.val;
            }
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }

        return result;
    }
}