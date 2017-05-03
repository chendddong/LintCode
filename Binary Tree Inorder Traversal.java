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
    	// remember to add integer
    	results.add(root.val);
    	results.addAll(right);
    	return results;

    }
}