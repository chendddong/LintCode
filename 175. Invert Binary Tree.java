/**
 * Invert a binary tree. -- LeetCode 226
 * Invert a binary tree. -- LintCode 175
 * Mirror a binary tree. -- TreeDemo 10
 * 
 */

/*
         4
       /   \
      2     7
     / \   / \
    1   3 6   9

    to
         4
       /   \
      7     2
     / \   / \
    9   6 3   1

    Trivia:
    This problem was inspired by this original tweet by Max Howell:
    Google: 90% of our engineers use the software you wrote (Homebrew), but you 
    can’t invert a binary tree on a white board so fuck off.
 */

///////////////////////////////
// Solution #0 recursive DFS //
///////////////////////////////

public class Solution {
    /* it's easy to write and pretty much concise. This won't change the tree */
    public void invertBinaryTree(TreeNode root) {
        
        if (root == null) {
            return;
        }

        /* Deep copying */
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        /* Connect */
        root.left = right;
        root.right = left;
        
        /* Recursion */
        invertBinaryTree(right);
        invertBinaryTree(left);
    }
}

//////////////////////////////////////////////
// Solution #1 recursive DFS Break the tree //
//////////////////////////////////////////////

public class Solution {
    /* 4 situations: */
    public void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        // 1
        if (root.right == null && root.left == null) {
            return;
        } 
        // 1         1
        //  \   ->  /
        //   2     2 
        else if (root.right != null && root.left == null) {
            root.left = root.right;
            root.right = null;
        } 
        //   1        1
        //  /    ->    \
        // 2            2 
        else if (root.right == null && root.left != null) {
            root.right = root.left;
            root.left = null;
        } 
        //      1            1
        //     / \   ->     / \
        //    2   3        3   2
        else if (root.right != null && root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        
        /* Recursive */
        invertBinaryTree(root.right);
        invertBinaryTree(root.left);
    }
}

///////////////////////////
// Solution #2 DFS Stack //
///////////////////////////

/*
    The solution #0 is correct, but it is also bound to the application 
    stack, which means that it's no so much scalable - (you can find the problem
    size that will overflow the stack and crash your application), so more 
    robust solution would be to use stack data structure.
 */
public class Solution {
    public void invertBinaryTree(TreeNode root) {
        
        if (root == null) {
            return;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {

            /* Solving the problem*/
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
    }
}

///////////////////////////
// Solution #3 DFS Queue //
///////////////////////////

/*
    Finally we can easily convert the above solution to BFS - or so called level 
    order traversal.
 */
public class Solution {
    public void invertBinaryTree(TreeNode root) {
        
        if (root == null) {
            return;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            /* Solving the problem*/            
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}