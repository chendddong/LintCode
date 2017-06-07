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
 * 
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    private ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
    private TreeNode curt;
    public BSTIterator(TreeNode root) {
        curt = root;
    }

    /* True if there has next node, or false */
    public boolean hasNext() {
        return (curt != null || !stack.isEmpty());
    }
    
    /* return: return next node */
    public TreeNode next() {
        /* remember this (curt != null) */
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }

        curt = stack.pop();
        TreeNode node = curt;
        curt = curt.right;

        return node;
    }
}