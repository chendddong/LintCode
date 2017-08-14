/*
    The structure of Expression Tree is a binary tree to evaluate certain
    expressions.

    All leaves of the Expression Tree have an number string value. All
    non-leaves of the Expression Tree have an operator string value.

    Now, given an expression array, build the expression tree of this expression, return the root of this expression tree.
 */

/*
    Example:

    For the expression (2*6-(23+7)/(1+2)) (which can be represented by ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]). 
    The expression tree will be like

                     [ - ]
                 /          \
            [ * ]              [ / ]
          /     \           /         \
        [ 2 ]  [ 6 ]      [ + ]        [ + ]
                         /    \       /      \
                       [ 23 ][ 7 ] [ 1 ]   [ 2 ] .
    After building the tree, you just need to return root node [-].
 */

/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /* Create a TreeNode for handling the level */
    class TreeNode {
        int val;
        ExpressionTreeNode eNode;
        public TreeNode(int val, String s) {
            this.val = val;
            eNode = new ExpressionTreeNode(s);
        }
    }
    public ExpressionTreeNode build(String[] expression) {
        if (expression == null || expression.length == 0) return null;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int base = 0;
        int val = 0;

        for (int i = 0; i < expression.length; i++) {

            /* For differentiating the level */
            if (expression[i].equals("(")) {
                base += 10;
                continue;
            }
            if (expression[i].equals(")")) {
                base -= 10;
                continue;
            }

            /* Get the weight of the TreeNode and create a new one */
            val = getWeight(base, expression[i]);
            TreeNode node = new TreeNode(val, expression[i]);

            /* There could be some waste connections */
            while (!stack.isEmpty() && node.val <= stack.peek().val) {
                node.eNode.left = stack.pop().eNode;
            }

            if (!stack.isEmpty()) {
                stack.peek().eNode.right = node.eNode;
            }
            stack.push(node);
        }

        if (stack.isEmpty()) { /* Checking conditions */
            return null;
        }

        /* Get the lastNode on the stack */

        // TreeNode res = stack.pop();
        // while (!stack.isEmpty()) {
        //     res = stack.pop();
        // }
        // return res.eNode;

        return stack.peekLast().eNode;
    }

    private int getWeight(int base, String s) {
        if (s.equals("+") || s.equals("-")) {
            return base + 1;
        }
        if (s.equals("*") || s.equals("/")) {
            return base + 2;
        }
        /* Weight transfer; Integer are leaves */
        return Integer.MAX_VALUE;
    }
}

/* Algorithm Walkthrough */

// ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]). 
// 
//                  Expression Tree <ExpressionTreeNode>:
//                  
//                                  EN(-)
//                             /            \
//                          EN(*)            EN(/)    
//                         /    \          /       \
//                      EN(2)   EN(6)    EN(+)      EN(+)
//                                      /    \      /   \
//                                  EN(23)  EN(7) EN(1) EN(2)
//                                               
//                             
//                             EN(+)
//                             /
//                                  
//                                                  
// 
// 
// 
//                          stack<TreeNode>:
//              n(2) n(+) n(1) n(/) n(7) n(+) n(23)  n(-) n(6) n(*) n(2) |
//                         x         x   x     x      √    x     x    x
// base = 0
//                                 
// node(2) = {
//              val : MAX_VALE,
//              eNode :  ExpressionTreeNode("2");
//            }
//            
// node(*) = {
//              val : 2,
//              eNode : ExpressionTreeNode("*");
//            }
//            
// node(6) = {
//              val : MAX_VALE,
//              eNode : ExpressionTreeNode("6");
//            }
// 
// node(-) = {
//              val : 1,
//              eNode : ExpressionTreeNode("-");
//            }
//            
// base = 10
// 
// node(23) = {
//              val : MAX_VALE,
//              eNode : ExpressionTreeNode("23");
//            }
// 
// node(+) = {
//              val : 11,
//              eNode : ExpressionTreeNode("+");
//            }
// 
// node(7) = {
//              val : MAX_VALE,
//              eNode : ExpressionTreeNode("7");
//            }
// 
// base = 0
// 
// node(/) = {
//              val : 2,
//              eNode : ExpressionTreeNode("/");
//            }
// 
// base = 10
// 
// node(1) = {
//              val : MAX_VALE,
//              eNode :  ExpressionTreeNode("1");
//            }
// 
// node(+) = {
//              val : 11,
//              eNode : ExpressionTreeNode("+");
//            }
// 
// node(2) = {
//              val : MAX_VALE,
//              eNode :  ExpressionTreeNode("2");
//            }
//                 
// base = 0

