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