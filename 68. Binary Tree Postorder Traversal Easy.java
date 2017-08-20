/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */

/*
    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [3,2,1].

    Note: Recursive solution is trivial, could you do it iteratively?
 */

//////////////////////
// Divide & Conquer //
//////////////////////

public class Solution {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);

        results.addAll(left);
        results.addAll(right);
        results.add(root.val);

        return results;
    }
}

//////////////
// Traverse //
//////////////

public class Solution {
    /*
        Use str output, void method, null return;
        Left->Right->Root
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

//////////////////////////
// Normal Non-Recursion //
//////////////////////////

public class Solution {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
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

/////////////////////////////
// Two Stack Non-Recursive //           Easy to remember 
/////////////////////////////

public class Solution {
    /*
        The postorder is the same as the inverse of the preorder from the
        right-hand side. So we use two stacks.
    */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayDeque<TreeNode> s = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> out = new ArrayDeque<TreeNode>();

        s.push(root);

        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            /* Solve later */
            out.push(cur);

            if (cur.left != null) {
                s.push(cur.left);
            }

            if (cur.right != null) {
                s.push(cur.right);
            }
        }

        while (!out.isEmpty()) {
            result.add(out.pop().val);
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

 */

/////////////////
// Interesting //
/////////////////

/*
    Summarize the iterative implementation for preorder, inorder, and postorder
    traverse.

    Pre Order Traverse
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(p.val);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;   
            }
        }
        return result;
    }
    In Order Traverse
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;   
            }
        }
        return result;
    }
    Post Order Traverse
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }
 */     
