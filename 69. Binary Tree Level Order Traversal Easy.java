/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * -- LeetCode 102, 107 
 * -- LintCode 69, 70
 * -- TreeDemo 4
 */

/*
    Example
    Given binary tree {3,9,20,#,#,15,7},

        3
       / \
      9  20
        /  \
       15   7
     

    return its level order traversal as:

    [
      [3],
      [9,20],
      [15,7]
    ]
 */

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
 
/////////////////////////////////
// Solution 0 Single Queue BFS //
/////////////////////////////////

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }                
            }
            result.add(level);

        }

        return result;
    }
}

////////////////////
// Solution 1 DFS //
////////////////////

/* This is called iterative recursion */
public class Solution {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new
        ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return results;
        }

        int maxLevel = 0;
        while (true) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            dfs(root, level, 0, maxLevel);
            if (level.size() == 0) {
                break;
            }
            results.add(level);
            maxLevel++;
        }

        return results;
    }

    private void dfs(TreeNode root,
                     ArrayList<Integer> level,
                     int curtLevel,
                     int maxLevel) {
        if (root == null || curtLevel > maxLevel) {
            return;
        }

        if (curtLevel == maxLevel) {
            level.add(root.val);
            return;
        }

        dfs(root.left, level, curtLevel + 1, maxLevel);
        dfs(root.right, level, curtLevel + 1, maxLevel);
    }
}

/*
    I think there are too much unnecessary iterations during the process since
    each DFS starts from the root. There might be an optimization.
 */

/////////////////////////////////
// Solution 2: BFS. two queues //
/////////////////////////////////

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> Q1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> Q2 = new ArrayList<TreeNode>();

        Q1.add(root);
        while (Q1.size() != 0) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            Q2.clear();
            for (int i = 0; i < Q1.size(); i++) {
                TreeNode node = Q1.get(i);
                level.add(node.val);
                if (node.left != null) {
                    Q2.add(node.left);
                }
                if (node.right != null) {
                    Q2.add(node.right);
                }
            }

            /* Swap Q1 and Q2 */
            /* The swap operation would cost a bit more */
            ArrayList<TreeNode> temp = Q1;
            Q1 = Q2;
            Q2 = temp;

            result.add(level);
        }

        return result;
    }
}

///////////////////////////////
// Solution 3 BFS dummy node //
///////////////////////////////


public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        Q.offer(null); // dummy node
        
        ArrayList<Integer> level = new ArrayList<Integer>();
        while (!Q.isEmpty()) {
            TreeNode node = Q.poll();
            if (node == null) {
                if (level.size() == 0) {
                    break;
                }
                result.add(level);
                level = new ArrayList<Integer>();
                Q.offer(null); // add a new dummy node
                continue;
            }
            
            level.add(node.val);
            if (node.left != null) {
                Q.offer(node.left);
            }
            if (node.right != null) {
                Q.offer(node.right);
            }
        }
        
        return result;
    }
}

/*
    Have a little attitude towards null. So...
 */