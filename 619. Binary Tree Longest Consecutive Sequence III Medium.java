/**
 * It's follow up problem for Binary Tree Longest Consecutive Sequence II
 */

/*
    Given a k-ary tree, find the length of the longest consecutive sequence path.
    The path could be start and end at any node in the tree

    Example
    An example of test data: k-ary tree 5<6<7<>,5<>,8<>>,4<3<>,5<>,3<>>>, denote the following structure:


         5
       /   \
      6     4
     /|\   /|\
    7 5 8 3 5 3

    Return 5, // 3-4-5-6-7
 */

/**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<TreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
 * }
 */
class ResultType {
    public int max_len, max_down, max_up;
    ResultType(int len, int down, int up) {
        max_len = len;
        max_down = down;
        max_up = up;    
    }
}

public class Solution {
    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive3(MultiTreeNode root) {
        return helper(root).max_len;
    }
    
    ResultType helper(MultiTreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }

        int down = 0, up = 0, max_len = 1;
        for (MultiTreeNode node : root.children) {
            ResultType type = helper(node);
            //      x
            //    /   \
            //   6     x
            //  /|\   /|\
            // x 5 x             
            if (node.val + 1 == root.val)
                down = Math.max(down, type.max_down + 1);
            //      x
            //    /   \
            //   5     x
            //  /|\   /|\
            // x 6 x              
            if (node.val - 1 == root.val)
                up = Math.max(up, type.max_up + 1);

            max_len = Math.max(max_len, type.max_len);
        }

        max_len = Math.max(down + 1 + up, max_len);
        return new ResultType(max_len, down, up);
    }
}
/*
    Just compare this with the 614, basically both of these two are somewhat
    symmetric to write.

    1.  three variables for the resultType
    2.  Use for each for accessing the children and there are only two
    situation comparing to 614.
    3.  Draw it and understand it.
 */