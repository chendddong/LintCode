/**
 * Given an expression string array, return the final result of this expression
 * The expression contains only integer, +, -, *, /, (, ).
 */

/*
    Example
    For the expression 2*6-(23+7)/(1+2),
    input is

    [
      "2", "*", "6", "-", "(",
      "23", "+", "7", ")", "/",
      (", "1", "+", "2", ")"
    ],
    return 2
 */

/* Building the Tree is the same as always */

class TreeNode {
    public int val;
    public String s;
    public TreeNode left, right;

    public TreeNode(int val, String ss) {
        this.val = val;
        this.s = ss;
        this.left = this.right = null;
    }
}

public class Solution {

    public int evaluateExpression(String[] expression) {
        List<String> rpn = convertToRPN(expression);
        String[] str = new String[rpn.size()];
        rpn.toArray(str);
        return evalreversepolish(str);
    }   

    private int evalreversepolish(String[] tokens) {
        int returnValue = 0;
        String operators = "+-*/";
        ArrayDeque<String> stack = new Stack<>();

        for (String s : tokens) {
            if (!operators.contains(s)) { /* Push numbers */
                stack.push(s);
            } else {
                int one = Integer.valueOf(stack.pop());
                int two = Integer.valueOf(stack.pop());
                if (s.equals("+")) {
                    stack.push(String.valueOf(a + b));
                } else if (s.equals("-")) {
                    stack.push(String.valueOf(a - b));                    
                } else if (s.equals("*")) {
                    stack.push(String.valueOf(a * b));                    
                } else if (s.equals("/")) {
                    stack.push(String.valueOf(a / b));                    
                }
            }

        }

        /* Should be just one result over there */
        return returnValue = stack.isEmpty() ? 0 : Integer.valueOf(stack.pop());

    }

    private List<String> convertToRPN(String[] expression) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = null;
        int val = 0;
        Integer base = 0;

        for (int i = 0; i <= expression.length; i++) {
            if (i != expression.length) {
                if (expression[i].equals("(")) {
                    base += 10;
                    continue;
                }
                if (expression[i].equals(")")) {
                    base -= 10;
                    continue;
                }

                val = getValue(expression[i], base);
            }

            TreeNode right = i == expression.length ?
                new TreeNode(Integer.MIN_VALUE, "") :
                new TreeNode(val, expression[i]);

            while (!stack.isEmpty()) {
                if (right.val <= stack.peek().val) {
                    TreeNode nodeNow = stack.pop();

                    if (stack.isEmpty()) {
                        right.left = nodeNow;
                    } else {
                        TreeNode left = stack.peek();
                        if (left.val < right.val) {
                            right.left = nodeNow;
                        } else {
                            left.right = nodeNow;
                        }
                    }
                } else {
                    break;
                }
            }

            stack.push(right);
        }

        ArrayList<String> reversePolish = new ArrayList<>();
        dfs(stack.peek().left, reversePolish);

        return reversePolish;
    }

    private int getValue(String a, Integer base) {
        if (a.equals("+") || a.equals("-"))
            return base + 1;
        if (a.equals("*") || a.equals("/"))
            return base + 2;

        return Integer.MAX_VALUE;
    }

    /* Postorder traverse the tree and add the node along the way */
    private void dfs(TreeNode root, ArrayList<String> as) {
        if (root == null)   return;
        if (root.left  != null) dfs(root.left,  as);
        if (root.right != null) dfs(root.right, as);
        as.add(root.s);
    }    
}

/*
Example from WIKI

The infix expression ((15 ÷ (7 − (1 + 1))) × 3) − (2 + (1 + 1)) can be written like this in reverse Polish notation:

15 7 1 1 + − ÷ 3 × 2 1 1 + + −

Evaluating this postfix expression with the above left-to-right algorithm yields:

15 7 1 1 + − ÷ 3 × 2 1 1 + + − =
15 7     2 − ÷ 3 × 2 1 1 + + − =
15         5 ÷ 3 × 2 1 1 + + − =
             3 3 × 2 1 1 + + − =
                 9 2 1 1 + + − =
                 9 2     2 + − =
                 9         4 − =
                             5

The following table shows the state of the operand stack at each stage of the above left-to-right algorithm:
Token       Type                    Stack               Actions
15          Operand                 15              Push onto stack.
7           Operand                 15 7            Push onto stack.
1           Operand                 15 7 1          Push onto stack.
1           Operand                 15 7 1 1        Push onto stack.
+           Operator                15 7 2          Pop from stack twice (1, 1), calculate (1 + 1 = 2) and push onto stack.
−           Operator                15 5            Pop from stack twice (7, 2), calculate (7 − 2 = 5) and push onto stack.
÷           Operator                3               Pop from stack twice (15, 5), calculate (15 ÷ 5 = 3) and push onto stack.
3           Operand                 3 3             Push onto stack.
×           Operator                9               Pop from stack twice (3, 3), calculate (3 × 3 = 9) and push onto stack.
2           Operand                 9 2             Push onto stack.
1           Operand                 9 2 1           Push onto stack.
1           Operand                 9 2 1 1         Push onto stack.
+           Operator                9 2 2           Pop from stack twice (1, 1), calculate (1 + 1 = 2) and push onto stack.
+           Operator                9 4             Pop from stack twice (2, 2), calculate (2 + 2 = 4) and push onto stack.
−           Operator                5               Pop from stack twice (9, 4), calculate (9 − 4 = 5) and push onto stack.
 */