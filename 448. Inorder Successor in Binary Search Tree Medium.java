/**
 * Given a binary search tree (See Definition) and a node in it, find  the
 * in-order successor of that node in the BST.
 */

/*
    If the given node has no in-order successor in the tree, return null.

    It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)


    Example
    Given tree = [2,1] and node = 1:

      2
     /
    1
    return node 2.

    Given tree = [2,1,3] and node = 2:

      2
     / \
    1   3
    return node 3.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

////////////////////////////////////////////
// Solution #0 Straight forward traversal //
////////////////////////////////////////////

class ResultType {
    public boolean found;
    public int target;
    public ResultType(boolean found, int target) {
        this.found = found;
        this.target = target;
    }
}

public class Solution {
    /* for the final answer */
    TreeNode targetNode = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        /* Check the edge */
        if (root == null || p == null) {
            return null;
        }
        /* Get the traversal list */
        ArrayList<Integer> list = getList(root);

        /* Find the target we are looking for */ 
        ResultType targetRT = findTarget(p.val, list);

        /* Get that node we need */
        if (targetRT.found) {
            findNode(root, targetRT.target);
            return targetNode;
        } 
        
        return null;
        
    }

    private ArrayList<Integer> getList(TreeNode root) { 
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        ArrayList<Integer> left = getList(root.left);
        ArrayList<Integer> right =  getList(root.right);

        list.addAll(left);
        list.add(root.val);
        list.addAll(right);

        return list;
    }

    private ResultType findTarget(int p, ArrayList<Integer> list) {
        int size = list.size();

        for (int element : list) {
            if (element == p) {
                break;
            }
            size--;
        }
        // last position
        if (size <= 1) {
            return new ResultType(false, 0);
        }

        return new ResultType(true, list.get(list.size() - size + 1));        
    }


    private void findNode(TreeNode root, int targetValue) {
        if (root == null) {
            return;
        }

        if (root.val == targetValue) {
            targetNode = root;
            return;
        }

        findNode(root.left, targetValue);
        findNode(root.right, targetValue);
    }
}



public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        /* Record the successor along the way */
        TreeNode successor = null;
        /* Find p */
        while (root != null && root != p) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        /* p is null */
        if (root == null) {
            return null;
        }
        /* p's right is null */
        if (root.right == null) {
            return successor;
        }
        
        /* Go right */
        root = root.right;
        /* Go deep to the far left*/
        while (root.left != null) {
            root = root.left;
        }
        
        return root;
    }
}

