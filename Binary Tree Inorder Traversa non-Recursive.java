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
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	ArrayList<Integer> result = new ArrayList<Integer>();

    	TreeNode curt = root;
    	// curt != null || !stack.empty() double while
    	while (curt != null || !stack.empty()) {
    	    // goes to the bottom left
    		while (curt != null) {
    			stack.add(curt);
    			curt = curt.left;
    		}
            // peek pop add go to right
    		curt = stack.peek();
    		stack.pop();
    		result.add(curt.val);
    		curt = curt.right;
    	}

    	return result;
    }
}