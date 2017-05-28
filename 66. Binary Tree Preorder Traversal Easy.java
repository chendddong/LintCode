
/////////////////////////////////
// Solution 1 Divide & Conquer //
/////////////////////////////////


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
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        
        results.add(root.val);
        results.addAll(left);
        results.addAll(right);
        
        return results;
    }
}

/////////////////////////
// Solution 2 Traverse //
/////////////////////////

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
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}

//////////////////////////////
// Solution 3 Non-Recursion //
//////////////////////////////

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
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // Stack<TreeNode> stack = new Stack<TreeNode>();
        /* Rumor says that deck performs slightly better than stack :) */
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        ArrayList<Integer> preorder = new ArrayList<Integer>();

        if (root == null) {
            return preorder;
        }
        /* push root outside, pop it, and goes right then left */
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            preorder.add(node.val);
            if (node.right != null) {
                deque.push(node.right);
            }
            if (node.left != null) {
                deque.push(node.left);
            }
        }

        return preorder;
    }
}

/*
    Thoughts:

    1. The difference between the traverse and DC method.
    
       ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
       The traverse method is like a knight doing all the stuff himself -- Ned
       Stark. He would go all the way to all the nodes carry the king's wish.

       There would always be a 'result' being carried around when the
       recursion happens.
       
       Whereas the DC method is like The King's small counsel each Lord would
       bring the message from his part and the king will process the message and
       merge the message with his own thoughts.

       Lord little finger and Lord Varys would do their own thing first and
       bring out the 'left' result and 'right' result and then solve the
       problem with the king together.
       ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    2. The non-recursion version -- draw it and remember it.

 */

