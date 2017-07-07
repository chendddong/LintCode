/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that 
 * every key of the original BST is changed to the original key plus sum of all
 * keys greater than the original key in BST.
 *
 * -- LeetCode 538
 * -- LintCode 661
 */

/*
    Example:

    Input: The root of a Binary Search Tree like this:
                  5
                /   \
               2     13

    Output: The root of a Greater Tree like this:
                 18
                /   \
              20     13

    preorder: root left right
    stack: add root before stack | add right, add left |

    inorder: left root right
    stack: add left then go to far left | add roots | add right

    postorder: left right root
    stack add root before stack | add left, add right |
    last use another stack to flip

    funky order: right root left
    just go right

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

///////////////////////////////////////
// Solution #0 Funky order traversal //
///////////////////////////////////////

public class Solution {
    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.right;
            }

            cur = s.peek();
            s.pop();

            /* Solve the problem */

            if (sum == 0) {
                sum = cur.val;
            } else {
                cur.val += sum;
                sum = cur.val;
            }
            cur = cur.left;
        }
        
        return root;
    }
}

///////////////////////////////////
// Solution #1  Recursive Helper //
///////////////////////////////////

public class Solution {
    int sum = 0;    
    public TreeNode convertBST(TreeNode root) {
        convertBSTHelper(root);
        return root;
    }
    private void convertBSTHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        /* Right */
        if (root.right != null) {
            convertBSTHelper(root.right);
        }
        /* Root */
        root.val = (sum += root.val);

        /* Left */
        if (root.left != null) {
            convertBSTHelper(root.left);            
        }

    }
}