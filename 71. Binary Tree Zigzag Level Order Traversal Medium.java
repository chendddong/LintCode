/*
    Given a binary tree, return the zigzag level order traversal of its nodes'
    values. (ie, from left to right, then right to left for the next level and alternate between).

    -- LeetCode 103
    -- LintCode 71
    -- TreeDemo 4.7.1

    Have you met this question in a real interview? Yes
    Example
    Given binary tree {3,9,20,#,#,15,7},

        3
       / \
      9  20
        /  \
       15   7
     

    return its zigzag level order traversal as:

    [
      [3],
      [20,9],
      [15,7]
    ]
 */

////////////////
// ArrayDeque //
////////////////

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }  

        /* BFS */  
        ArrayDeque<TreeNode> q1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> q2 = new ArrayDeque<>();
        q1.offer(root);
        q2.offer(root);
        boolean leftToRight = true;

          //      3
          //     / \
          //    9   20
          //   / \ /  \
          //  1  4 15   7
          //  [ 
          //   [3],
          //   [20,9]
          //   [1,4,15,7]

        while (!q1.isEmpty()) {
            int size = q1.size();
            List<Integer> level = new ArrayList<>();
            addLevel(level, q2, leftToRight);
            for (int i = 0; i < size; i++) {
                TreeNode node = q1.poll();
                if (node.left != null) {
                    q1.offer(node.left);
                    q2.offer(node.left);
                }
                if (node.right != null) {
                    q1.offer(node.right);
                    q2.offer(node.right);
                }
            }
            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }
    private void addLevel(List<Integer> level, 
                          ArrayDeque<TreeNode> q2, 
                          boolean leftToRight) {
        if (leftToRight) {
            int size = q2.size();
            for (int i = 0; i < size; i++) {
                level.add(q2.removeFirst().val);
            }
        } else {
            int size = q2.size();
            for (int i = 0; i < size; i++) {
                level.add(q2.removeLast().val);
            }
        }

    }
}


////////////////
// Two Stacks //
////////////////

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        /* Edge */
        if (root == null) {
            return result;
        }

        /* Two stacks since the order is zigzagged */
        ArrayDeque<TreeNode> currLevel = new ArrayDeque<>();
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<>();
        ArrayDeque<TreeNode> tmp;

        currLevel.push(root);
        boolean normalOrder = true;


          //      3
          //     / \
          //    9   20
          //   / \ /  \
          //  1  4 15   7
          //  [ 
          //   [3],
          //   [20,9]
          //   [1,4,15,7]

        while (!currLevel.isEmpty()) {
            List<Integer> currLevelResult = new ArrayList<>();
            int size = currLevel.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);

                if (normalOrder) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }

            result.add(currLevelResult);

            /* Swap level */
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;

            /* Change order */
            normalOrder = !normalOrder;
        }
        
        return result;
    }
}

//////////////////////////
// Just Using one Queue //
//////////////////////////

public class Solution {
    /* A little trick about the ArrayList by adding element both ways */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean normalOrder = true;

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                /* Add from the tail */
                if (normalOrder) {
                    level.add(node.val);
                /* Add from the head */    
                } else {
                    level.add(0, node.val);
                }

                if (node.left != null) {
                    q.offer(node.left);
                } 
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            result.add(level);
            normalOrder = !normalOrder;
        }
        return result;
    }
}