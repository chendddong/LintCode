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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);

        results.addAll(left);
        results.addAll(right);
        results.add(root);

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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        
        traverse(root.left, result);
        traverse(root.right, result);
        result.add(root.val);
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // traverse down the tree
        // traverse up the tree from the left
        // traverse up the tree from the right
        ArrayList<Integer> postorder = new ArrayList<Integer>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode curr = root;
        TreeNode prev = null;
        if (root == null) {
            return postorder;
        }
        stack.push(root);
        
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
                if (curr.left != null) {
                    stack.push(curr.left);
                }else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) { // traverse up the tree from the left
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else { // traverse up the tree from the right
                postorder.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }

        return postorder;

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

    2. The non-recursion version -- draw it leave it there maybe. It's bit hard
    to remember all of it correctly. But I can definitely go through it without
    a sweat

 */