/**
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 */

/*
  Here we use the right pointer in TreeNode as the next pointer in ListNode.

  Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

  Example
                1
                 \
       1          2
      / \          \
     2   5    =>    3
    / \   \          \
   3   4   6          4
                       \
                        5
                         \
                          6
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
/**
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 */

/*
  Here we use the right pointer in TreeNode as the next pointer in ListNode.

  Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

  Example
                1
                 \
       1          2
      / \          \
     2   5    =>    3
    / \   \          \
   3   4   6          4
                       \
                        5
                         \
                          6
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

///////////////////////////
// Solution 0 Two Stacks //
///////////////////////////

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            stack1.push(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        TreeNode last = stack1.pop();
        last.left = null;
        last.right = null;
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            node.left = null;
            node.right = last;
            last = node;
        }

        root = last;   
    }
}

///////////////////////////////
// Solution 1 Just One Stack //
///////////////////////////////

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            
            /* Connect right in the loop */
            node.left = null;
            if (stack.!stack.isEmpty()) {
                node.right = null;
            } else {
                /* The peek time */
                node.right = stack.peek();
            }
        }
    }
}


//////////////////////////////////
// Solution 2: Traverse - Recur //
//////////////////////////////////

public class Solution {
    private TreeNode lastNode = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        /* Move down the tree */
        lastNode = root;
        /* Temporary storage of those right nodes */
        TreeNode right = root.right;
        /* Go left first and then go right */
        flatten(root.left);
        flatten(right);
    }
}

/*
    Comparing to other recursive method, this one is bit tricky because of the
    asymmetric pattern of the code.
 */
 

//////////////////////////////////
// Solution 3: Divide & Conquer //
//////////////////////////////////

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    // flatten root and return the last node
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        
        // connect leftLast to root.right
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (rightLast != null) {
            return rightLast;
        }
        
        if (leftLast != null) {
            return leftLast;
        }
        
        return root;
    }
}

