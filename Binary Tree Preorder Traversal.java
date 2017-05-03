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
    	results.add(root.val);
    	ArrayList<Integer> left = preorderTraversal(root.left);
    	ArrayList<Integer> right = preorderTraversal(root.right);
        
        results.addAll(left);
        results.addAll(right);
        
    	return results;
    }
}