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
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode curr = root;
    	TreeNode prev = null;
    	if (root == null) {
    		return postorder;
    	}
    	stack.push(root);
    	
    	while (!stack.empty()) {
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