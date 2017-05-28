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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);

        results.addAll(left);
        /* remember to add integer */
        results.add(root.val);
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        
        traverse(root.left, result);
        result.add(root.val);
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        TreeNode curt = root;
        /* curt != null || !stack.empty() double while */
        while (curt != null || !stack.isEmpty()) {
            /* goes to the bottom left */
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
            /* peek pop add go to right */
            curt = stack.peek();
            stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }

        return result;
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