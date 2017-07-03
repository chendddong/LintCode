package Algorithms.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayDeque;


/**
 * MENU:
 *
 * 1. Get all the nodes number:
 *     1) getNodeNumRec(recursive)
 *     2) getNodeNum(iteration)
 *     
 * 2. Get the depth: 
 *     1) getDepthRec(recursive)，
 *     2) getDepth(iteration)
 *     3) getDepthTraverse(global variable)
 *     
 * 3. Binary tree traversal 
 *     1) preorderTraversalRec
 *     2) preorderTraversal
 *     3) inorderTraversalRec
 *     4) inorderTraversal
 *     5) postorderTraversalRec
 *     6) postorderTraversal
 *     
 * 4. Level order traversal
 *     1) levelTraversal
 *     2) levelTraversalRec
 *     3) Level order traversal BFS
 *     refer to LintCode 69 for more solutions
 *
 * 5. Convert BST to Doubly LinkedList
 *     1) convertBST2DLLRec (refer to LintCode 378)
 *     2) convertBST2DLL
 *
 * 6. Get the number of Nodes from Kth level
 *     1) getNodeNumKthLevel
 *     2) getNodeNumKthLevelRec
 *     
 * 7. Get the number of leaf nodes
 *     1) getNodeNumLeafRec
 *     2) getNodeNumLeaf
 * 
 * 8. Are those BT the same 
 *     1) isSameRec
 *     2) isSame
 *     
 * 9. Is balanced binary tree 
 *     1) isAVLRec
 *     2) isAVLResultType 
 *     
 * 10. BT mirror
 *     1) mirrorRec
 *     2) mirror
 *     3) mirrorCopyRec
 *     4) mirrorCopy
 *      
 * 10.1 Two trees are mirrors
 *     1) isMirrorRec
 *     2) isMirror
 *     
 * 11. Least common ancestor
 *     1) LCA
 *     2) LCABstRec  递归求解BST树.
 *     3) LCARec     递归算法
 *     
 * 12. 求二叉树中节点的最大距离：getMaxDistanceRec 
 * 13. 由前序遍历序列和中序遍历序列重建二叉树：rebuildBinaryTreeRec
 * 14. 判断二叉树是不是完全二叉树：isCompleteBinaryTree, isCompleteBinaryTreeRec
 * 15. 找出二叉树中最长连续子串(即全部往左的连续节点，或是全部往右的连续节点）findLongest
*/  

public class TreeDemo {
 
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        // TreeNode r7 = new TreeNode(0); 

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;
        // r4.left = r7; 
    /* 
        Tree: r

            1  
           / \  
          2   3  
         / \   \  
        4   5   6
       
    

    */         
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(14);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(16);
        TreeNode t7 = new TreeNode(0);
        TreeNode t8 = new TreeNode(0);
        TreeNode t9 = new TreeNode(0);
        TreeNode t10 = new TreeNode(0);
        TreeNode t11 = new TreeNode(0);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        //t4.right = t9;
        t5.right = t9;
    /*                    
           10  
           /  \  
          6    14  
         / \   / \  
        4   8 16  0
       /     \
      0       0 
    */ 
        
        
    // test distance
    //        t5.right = t8;
    //        t8.right = t9;
    //        t9.right = t10;
    //        t10.right = t11;
        
    /* 
            10  
            / \  
           6   14  
          / \   \  
         4   8   16
        /
       0  

     */ 
    //        System.out.println(LCABstRec(t1, t2, t4).val);
    //        System.out.println(LCABstRec(t1, t2, t6).val);
    //        System.out.println(LCABstRec(t1, t4, t6).val);
    //        System.out.println(LCABstRec(t1, t4, t7).val);
    //        System.out.println(LCABstRec(t1, t3, t6).val);
    //        
    //        System.out.println(LCA(t1, t2, t4).val);
    //        System.out.println(LCA(t1, t2, t6).val);
    //        System.out.println(LCA(t1, t4, t6).val);
    //        System.out.println(LCA(t1, t4, t7).val);
    //        System.out.println(LCA(t1, t3, t6).val);
    //        System.out.println(LCA(t1, t6, t6).val);
            
            //System.out.println(getMaxDistanceRec(t1));
            
            //System.out.println(isSame(r1, t1));
            
    //        System.out.println(isAVLRec(r1));
    //        
    //        preorderTraversalRec(r1);
    //        //mirrorRec(r1);
    //        //TreeNode r1Mirror = mirror(r1);
    //        
    //        TreeNode r1MirrorCopy = mirrorCopy(r1);
    //        System.out.println();
    //        //preorderTraversalRec(r1Mirror);
    //        preorderTraversalRec(r1MirrorCopy);
    //        
    //        System.out.println();
    //        
    //        System.out.println(isMirrorRec(r1, r1MirrorCopy));
    //        System.out.println(isMirror(r1, r1MirrorCopy));
            
            
            //System.out.println(getNodeNumKthLevelRec(r1, 5));
            
            //System.out.println(getNodeNumLeaf(r1));
            
    //      System.out.println(getNodeNumRec(null));
    //      System.out.println(getNodeNum(r1));
            //System.out.println(getDepthRec(null));
    //        System.out.println(getDepth(r1));
    //        
    //        preorderTraversalRec(r1);
    //        System.out.println();
    //        preorderTraversal(r1);
    //        System.out.println();
    //        inorderTraversalRec(r1);
    //        
    //        System.out.println();
    //          inorderTraversal(r1);
    //        postorderTraversalRec(r1);
    //        System.out.println();
    //        postorderTraversal(r1);
    //        System.out.println();
    //        levelTraversal(r1);
    //        
    //        System.out.println();
    //        levelTraversalRec(r1);
            
    //        TreeNode ret = convertBST2DLLRec(r1);
    //        while (ret != null) {
    //            System.out.print(ret.val + " ");
    //            ret = ret.right;
    //        }
            
    //        TreeNode ret2 = convertBST2DLL(r1);
    //        while (ret2.right != null) {
    //            ret2 = ret2.right;
    //        }
    //        
    //        while (ret2 != null) {
    //            System.out.print(ret2.val + " ");
    //            ret2 = ret2.left;
    //        }
    //        
    //        TreeNode ret = convertBST2DLL(r1);
    //        while (ret != null) {
    //            System.out.print(ret.val + " ");
    //            ret = ret.right;
    //        }
            
    //        System.out.println();
    //        System.out.println(findLongest(r1));
    //        System.out.println();
    //        System.out.println(findLongest2(r1));
        
        // test the rebuildBinaryTreeRec.
        //test_rebuildBinaryTreeRec();
        
        System.out.println(isCompleteBinaryTreeRec(t1));
        System.out.println(isCompleteBinaryTree(t1));
    }
    
    public static void test_rebuildBinaryTreeRec() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(5);
        list1.add(3);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(4);
        list2.add(2);
        list2.add(5);
        list2.add(1);
        list2.add(3);
        list2.add(7);
        list2.add(6);
        list2.add(8);
        
        TreeNode root = rebuildBinaryTreeRec(list1, list2);
        preorderTraversalRec(root);
        System.out.println();
        postorderTraversalRec(root);
    }
    
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            left = null;
            right = null;                    
        }
    }

//////////////////////////////////
// 1. Get all the nodes number  //
//////////////////////////////////

    /////////////////////////////////
    // 1) getNodeNumRec(recursive) //
    /////////////////////////////////

    /* Null returns, then add all the number from left and right and plus 1 */
    public static int getNodeNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        }     
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    //////////////////////////////
    // 2) getNodeNum(iteration) //
    //////////////////////////////

    /*  
        The runtime would be O(n). 
        Use a ArrayDeque instead of the ArrayList.
        Similar to LevelOrderTraversal 
    */
    public static int getNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>(); 
        queue.offer(root);
        
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
    
            count++;
        }
        
        return count;
    }
    
//////////////////////
// 2. Get the depth //
//////////////////////



    /*
        Definition of Height and Depth

        The depth of a node is the number of edges from the node to the tree’s root
        node. A root node will have a depth of 0.
        
        The height of a node is the number of edges on the longest path from the
        node to a leaf. A leaf node will have a height of 0.
    */

    ///////////////////////////////
    // 1) getDepthRec(recursive) //
    ///////////////////////////////

    public static int getDepthRec(TreeNode root) {
        /* Base */
        if (root == null) {
            return -1; /* Refer to the definition */
        }

        /* Divide */ 
        int left = getDepthRec(root.left);
        int right = getDepthRec(root.right);

        return Math.max(left, right) + 1;
    }

    /////////////////////////////
    // 2) getDepth(Iteration)  //
    /////////////////////////////

    /*
        Use level order traversal to record the 'depths' along the way.
        Use a for loop instead of a dummy node to separate the levels. 
     */
    public int getDepth(TreeNode root) {
        /* Base */
        if (root == null) {
            return 0;
        }

        /* Refer to the definition */
        int depth = -1;

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        
        /* Use queue since it requires the number of 'levels' */
        /* preorder */
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return depth;
    }

    //////////////////////////////////////////
    // 3) getDepthTraverse(global variable) //
    //////////////////////////////////////////
    
    /* global var */
    private int depth;
    public int getDepthTraverse(TreeNode root) {
        depth = 0;
        /* Current root is root, current depth is 0 */
        helper(root, 0);

        return depth;
    }
    private void helper(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }

        if (curDepth > depth) {
            depth = curDepth;
        }

        helper(root.left, curDepth + 1);
        helper(root.right, curDepth + 1);
    }

//////////////////////////////
// 3. Binary tree traversal //
//////////////////////////////

    /////////////////////////////
    // 1) preorderTraversalRec //
    /////////////////////////////

    /* 
        Use str output, void method, null return;
        Root->Left->Right
    */
    public static void preorderTraversalRec(TreeNode root) {
        /* Base */
        if (root == null) {
            return;
        }
        
        System.out.print(root.val + " ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }
    
    //////////////////////////
    // 2) preorderTraversal //
    //////////////////////////

    /* Store the root in the stack */
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        ArrayDeque<TreeNode> s = new ArrayDeque<TreeNode>();
        s.push(root);
        
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            System.out.print(node.val + " ");
            /* 
                Remember to go right first and then go left,
                so we can pop left first to satisfy the root left right order.
            */
            if (node.right != null) { 
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }                       
        }
    }
    
    /////////////////////////////
    // 3) inorderTraversalRec  //
    /////////////////////////////

    /* 
        Use str output, void method, null return;
        Left->Root->Right
    */
    public static void inorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorderTraversalRec(root.left);
        System.out.print(root.val + " ");
        inorderTraversalRec(root.right);
    }
    
    /////////////////////////
    // 4) inorderTraversal //
    /////////////////////////
  
    /* 
        We add all the left children of the roots to the stack, then we pop from
        the stack and we deal with the right children at last.
    */
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        ArrayDeque<TreeNode> s = new ArrayDeque<TreeNode>();
        /* Only one node variable throughout the process */
        TreeNode curt = root;
        /* curt != null || !stack.empty() double while */
        while(curt != null || !s.isEmpty()) {
            /* goes to the bottom left and add nodes along the way */
            while (curt != null) {
                s.push(curt);
                curt = curt.left;
            }    
            /* Now the curt has no children so just pop the node out */
            curt = s.pop();
            System.out.print(curt.val + " ");    
            /* Go for the right side */  
            curt = curt.right;            
        }
        
        /*  
            If we use ArrayList as the result: 
            Peek pop add go to right.
        */
    }

    //////////////////////////////
    // 5) postorderTraversalRec //
    //////////////////////////////

    /* 
        Use str output, void method, null return;
        Left->Right->Root
    */    
    public static void postorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }
    
    ///////////////////////////
    // 6) postorderTraversal //
    ///////////////////////////

    /* 
        The postorder is the same as the inverse of the preorder from the
        right-hand side. So we use two stacks
    */
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        ArrayDeque<TreeNode> s = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> out = new ArrayDeque<TreeNode>();
        s.push(root);

        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            out.push(cur);
            
            if (cur.left != null) {
                s.push(cur.left);
            }
            if (cur.right != null) {
                s.push(cur.right);
            }
        }
        
        while(!out.isEmpty()) {
            System.out.print(out.pop().val + " ");
        }
    }

//////////////////////////////
// 4. Level order traversal //
//////////////////////////////  

    ///////////////////////
    // 1) levelTraversal //
    ///////////////////////

    /*
        The essence of the Lever order traversal:

        1. BFS, use queue
        2. Initialize the queue, offer the root to the queue.
        3. While the queue is not empty
        4. Ask if the children are not empty, offer them to the queue  
    */
    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            /* Print it out */
            System.out.print(cur.val + " ");

            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
    }
    
    //////////////////////////
    // 2) levelTraversalRec //
    //////////////////////////

    /* Two level ArrayList Traversal */
    public static void levelTraversalRec(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        levelTraversalVisit(root, 0, ret);
        System.out.println(ret);
    }
    public static void levelTraversalVisit(TreeNode root, 
                                           int level,
                                           ArrayList<ArrayList<Integer>> ret) {
        
        if (root == null) {
            return;
        }
            /* 
                If the node is in the new level, add one more layer.
                Example: when size = 3, level: 0, 1, 2
            */
        if (level >= ret.size()) {
            ret.add(new ArrayList<Integer>());
        }
        
        /* Go to the current level and add that node's val */
        ret.get(level).add(root.val);
        
        /* Recursive part */
        levelTraversalVisit(root.left, level + 1, ret);
        levelTraversalVisit(root.right, level + 1, ret);
    }

    //////////////////////////////////
    // 3) Level order traversal BFS //
    //////////////////////////////////

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
            /* Using a for loop to separate the level thing */
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

/////////////////////////////////////////
// 5. Convert BST to Doubly LinkedList //
/////////////////////////////////////////

    /*
                10
              /    \
             6     15
            / \   /  \
           3   8 11   18
            
            8 <- 10 -> 15
            8 -> 10 <- 15
        Requirements: Convert the BST to DLL where you can't create new nodes,
        and only can adjust the pointers.

        First, we connect the root left pointer to the last node of the left
        children and then pointing the root with the right pointer of last node
        of the left children.
        
        Second, we point the root's right pointer to the first node of the
        right children, then we use the left pointer of the first node of the
        right children to point to the root
    */
   
    //////////////////////////
    // 1) convertBST2DLLRec //
    //////////////////////////

    public static TreeNode convertBST2DLLRec(TreeNode root) {
        return convertBST2DLLRecHelp(root)[0];
    }
    /* ret[0] left pointer; ret[1] right pointer */
    public static TreeNode[] convertBST2DLLRecHelp(TreeNode root) {
        TreeNode[] ret = new TreeNode[2];
        ret[0] = null;
        ret[1] = null;
                
        if (root == null) {
            return ret;
        }
        
        if (root.left != null) {
            /* Go to the far left */
            TreeNode left[] = convertBST2DLLRecHelp(root.left);
            /* connect the last node of the left children to the root */
            left[1].right = root;  
            root.left = left[1];
            
            ret[0] = left[0];
        } else {
            /* left node return back to root */
            ret[0] = root;   
        }
        
        if (root.right != null) {
            /* Deal with the right */
            TreeNode right[] = convertBST2DLLRecHelp(root.right);
            /* connect the first node of the right children to the root */
            right[0].left = root;
            root.right = right[0];
            
            ret[1] = right[1];
        } else {
            /* right node return back to root */
            ret[1] = root;
        }
        
        return ret;
    }

    ///////////////////////
    // 2) convertBST2DLL //
    ///////////////////////

    /* Similar to in-order traversal */ 
    public static TreeNode convertBST2DLL(TreeNode root) {
        while (root == null) {
            return null;
        }
        
        TreeNode pre = null;
        ArrayDeque<TreeNode> s = new ArrayDeque<TreeNode>();
        TreeNode cur = root;
        TreeNode head = null;       // Head of the DLL
        
        while (true) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            
            /* if stack is empty, just break; */
            if (s.isEmpty()) {
                break;
            }
            
            cur = s.pop(); 
            if (head == null) {
                head = cur;
            }

            /* link pre and cur. */
            cur.left = pre;
            if (pre != null) {
                pre.right = cur;
            }
            
            /* Handle the right children */
            cur = cur.right;
            pre = cur;
        }
        
        return root;
    }

///////////////////////////////////////////////
// 6. Get the number of Nodes from Kth level //
///////////////////////////////////////////////

    //////////////////////////////
    // 1) getNodeNumKthLevelRec //
    //////////////////////////////

    /* Count the level and if it is the right level, return the size of the Q */
    public static int getNodeNumKth(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }

        int level = 0;
        int count = 0;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            level++;
            /* Size of the array */
            int size = q.size();
            if (level == k) {
                return size;
            }
            /* For loop every element in the queue */
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return count;
    }


    //////////////////////////////
    // 2) getNodeNumKthLevelRec //
    //////////////////////////////

    /* Two base case: zero node and one node */
    public static int getNodeNumKthLevelRec(TreeNode root, int k) {
        /* Zero node */
        if (root == null || k <= 0) {
            return 0;
        }
        
        /* One node */
        if (k == 1) {
            return 1;
        }
        
        /* Get the sum of the nodes on the kth level from left and right */
        return getNodeNumKthLevelRec(root.left, k - 1) 
               + getNodeNumKthLevelRec(root.right, k - 1);
    }

/////////////////////////////////////
// 7. Get the number of leaf nodes //
/////////////////////////////////////

    //////////////////////////
    // 1) getNodeNumLeafRec //
    //////////////////////////

    /* Just add all the leaf from the left and the right, and null return 0 */
    public static int getNodeNumLeafRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        /* Only this situation can be called the leaf node */
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
    }
    
    ///////////////////////
    // 2) getNodeNumLeaf //
    ///////////////////////

    /* We can use any one of those traversal method, for example in-order */
    public static int getNodeNumLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int cnt = 0;
        
        ArrayDeque<TreeNode> s = new ArrayDeque<TreeNode>();
        TreeNode cur = root;
        
        while (cur != null || !s.isEmpty()) {
            /* Go to far left and add the cur node along the way */

            // Left children
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }

            // The 'root'
            cur = s.peek();
            s.pop();

            // solve problem
            if (cur.left == null && cur.right == null) {
                cnt++;
            }

            // Go right
            cur = cur.right;
        }
        
        return cnt;
    }

//////////////////////////////
// 8. Are those BT the same //
//////////////////////////////

    //////////////////
    // 1) isSameRec //
    //////////////////

    /*
        (1) if two tree are all empty return true.
        (2) if one of those is empty and the other is not, return false
        (3) if two trees are both not empty if their val and their children are
        all the same return true, else return false;
    */
    public static boolean isSameRec(TreeNode r1, TreeNode r2) {
        /* (1) */
        if (r1 == null && r2 == null) {
            return true;
        }
        
        /* (2) */
        if (r1 == null || r2 == null) {
            return false;
        }

        /* (3) */
        return r1.val == r2.val && 
                isSameRec(r1.left, r2.left) && isSameRec(r1.right, r2.right);
    }

    ///////////////
    // 2) isSame //
    ///////////////

    /* We can use in-order traversal to compare with the two nodes */
    public static boolean isSame(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        
        if (r1 == null || r2 == null) {
            return false;
        }
        
        ArrayDeque<TreeNode> s1 = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> s2 = new ArrayDeque<TreeNode>();
        
        TreeNode cur1 = r1;
        TreeNode cur2 = r2;
        
        while ((cur1 != null && cur2 != null) || 
              (!s1.isEmpty() && !s2.isEmpty())) {

            /* Left side */
            while (cur1 != null && cur2 != null) {
                s1.push(cur1);
                s2.push(cur2);
                cur1 = cur1.left;
                cur2 = cur2.left;
            }
            
            /* Solve problem */
            if (cur1 != null || cur2 != null) {
                return false;
            }

            /* Current node */
            cur1 = s1.peek();
            s1.pop();
            cur2 = s2.peek();
            s2.pop();

            /* Solve problem */            
            if (cur1.val != cur2.val) {
                return false;
            }
            
            /* Right side */
            cur1 = cur1.right;
            cur2 = cur2.right;
        }
        
        return true;
    }
    /* This is the Preorder traversal */
    public boolean isSame(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }

        if (r1 == null || r2 == null) {
            return false;
        }

        ArrayDeque<TreeNode> s1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> s2 = new ArrayDeque<>();
        s1.push(r1);
        s2.push(r2);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode node1 = s1.pop();
            TreeNode node2 = s2.pop();

            if (node1.val != node2.val) {
                return false;
            }

            if (node1.right != null) {
                s1.push(node1.right);
            }
            if (node2.right != null) {
                s2.push(node2.right);
            }
            if (s1.size() != s2.size()) {
                return false ;
            }

            if (node1.left != null) {
                s1.push(node1.left);
            }

            if (node2.left != null) {
                s2.push(node2.left);
            }

            if (s1.size() != s2.size()) {
                return false ;
            }
        }

        return s1.size() == s2.size();
    }

////////////////////////////////
// 9. Is balanced binary tree //
////////////////////////////////

    /////////////////
    // 1) isAVLRec //
    /////////////////

    /* 
        (1) The height difference between left and right children should be < 1.
        (2) The left children and right children have to be all AVL.
     */
    public static boolean isAVLRec(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        /* (2) */
        if (!isAVLRec(root.left) || !isAVLRec(root.right)) {
            return false;
        }
        
        /* (1) and refer to the method in 2. 1) */

        int dif = Math.abs(getDepthRec(root.left) - getDepthRec(root.right));
        if (dif > 1) {
            return false;
        }
        
        return true;
    }
    
    ////////////////////////
    // 2) isAVLResultType //
    ////////////////////////

    /* When we need to return more than just one element, use ResultType */
    class ResultType {
        public boolean isBalanced;
        public int maxDepth;
        public ResultType(boolean isBalanced, int maxDepth) {
            this.isBalanced = isBalanced;
            this.maxDepth = maxDepth;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        /* subtree not balance */
        /* see if the left and the right are balanced */
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }
        
        /* root not balance */
        /* we can use 0 for the maxDepth */
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }
        
        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
    
///////////////////
// 10. BT mirror //
///////////////////
  
    //////////////////
    // 1) mirrorRec //
    //////////////////

     // *      1               1
     // *     /                 \
     // *    2     ----->        2
     // *     \                 /
     // *      3               3
    /* Break the original tree swap the left and right children recursively */
    public static TreeNode mirrorRec(TreeNode root) {  
        if (root == null) {
            return null;
        }
        /* Classic 3-way swap */
        TreeNode tmp = root.right;
        root.right = mirrorRec(root.left);
        root.left = mirrorRec(tmp);
        
        return root;
    }  
    
    /* Use the easiest preorder traversal */ 
    public static TreeNode mirror(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        ArrayDeque<TreeNode> s = new ArrayDeque<TreeNode>();
        s.push(root);
        
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            
            /* Swap between 3 nodes */
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            
            /* Go deeper if possible */
            if (cur.right != null) {
                s.push(cur.right);
            }
            
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
        
        return root;
    }  
    
    /* Copy the root, copy the children and connect them at the same time. */
    public static TreeNode mirrorCopyRec(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        /* Deep copy */
        TreeNode rootCopy = new TreeNode(root.val);
        rootCopy.left = mirrorCopyRec(root.right);
        rootCopy.right = mirrorCopyRec(root.left);
        
        return rootCopy;
    }  

    /* Preorder Traversal; Pop the node and create and connect the nodes. */
    public static TreeNode mirrorCopy(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        ArrayDeque<TreeNode> s = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> sCopy = new ArrayDeque<TreeNode>();
        s.push(root);
        
        TreeNode rootCopy = new TreeNode(root.val);
        sCopy.push(rootCopy);
        
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            TreeNode curCopy = sCopy.pop();
            
            /* Copy original tree's right to new tree's left */
            if (cur.right != null) {
                /* Easier to find the father for the children while copying. */
                TreeNode leftCopy = new TreeNode(cur.right.val);
                /* Thinking about the mirror */
                curCopy.left = leftCopy;
                s.push(cur.right);
                sCopy.push(curCopy.left);
            }
            
            if (cur.left != null) {
                /* Easier to find the father for the children while copying. */
                TreeNode rightCopy = new TreeNode(cur.left.val);
                /* Thinking about the mirror */
                curCopy.right = rightCopy;
                s.push(cur.left);
                sCopy.push(curCopy.right);
            }
        }
        
        return rootCopy;
    }  

////////////////////////////////
// 10.1 Two trees are mirrors //
////////////////////////////////

    ////////////////////
    // 1) isMirrorRec //
    ////////////////////

    /*
        (1) if two tree are all empty return true.
        (2) if one of those is empty and the other is not, return false
        (3) if two trees are both not empty if their val and their children are
        all the same to the opposite branch return true, else return false;
    */
   
    /* Similar to isSameRec except altering the left and right children */
    public static boolean isMirrorRec(TreeNode r1, TreeNode r2){  
        /* (1) */
        if (r1 == null && r2 == null) {
            return true;
        }
        /* (2) */    
        if (r1 == null || r2 == null) {
            return false;
        }
        /* (3) */        
        return r1.val == r2.val 
                && isMirrorRec(r1.left, r2.right)
                && isMirrorRec(r1.right, r2.left);
    }
    
    /////////////////
    // 2) isMirror //
    /////////////////

    /*
        (1) if two tree are all empty return true.
        (2) if one of those is empty and the other is not, return false
        (3) compare tree_1's left children with tree_2's right children and vise
        versa, they can be: 
            i.      both null (return true at the end)
            ii.     both be not null (go deeper)
            iii.    one of the children is null and the other is not
     */
    public static boolean isMirror(TreeNode r1, TreeNode r2){  
        /* (1) */
        if (r1 == null && r2 == null) {
            return true;
        }
        
        /* (2) */    
        if (r1 == null || r2 == null) {
            return false;
        }
        
        /* Use two stacks */
        ArrayDeque<TreeNode> s1 = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> s2 = new ArrayDeque<TreeNode>();
        
        s1.push(r1);
        s2.push(r2);
        
        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode cur1 = s1.pop();
            TreeNode cur2 = s2.pop();
            
            /* Root */
            if (cur1.val != cur2.val) {
                return false;
            }
            
            /* Compare tree_1's left children with tree_2's right children */
            TreeNode left1 = cur1.left;
            TreeNode right1 = cur1.right;
            TreeNode left2 = cur2.left;
            TreeNode right2 = cur2.right;
            
            if (left1 != null && right2 != null) {
                s1.push(left1);
                s2.push(right2);
            } else if (!(left1 == null && right2 == null)) {
                return false;
            }
            
            /* Compare tree_2's left children with tree_1's right children */
            if (right1 != null && left2 != null) {
                s1.push(right1);
                s2.push(left2);
            } else if (!(right1 == null && left2 == null)) {
                return false;
            }
        }
        
        return true;
    }  

///////////////////////////////
// 11. Least common ancestor //
///////////////////////////////

    ////////////
    // 1) LAC //
    ////////////

    /* Record the path along the way and compare them */
    public static TreeNode LCA(TreeNode root, TreeNode r1, TreeNode r2) {
        // If the nodes have one in the root, just return the root.
        if (root == null || r1 == null || r2 == null) {
            return null;
        }
        
        ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();
        
        boolean find1 = LCAPath(root, r1, list1);
        boolean find2 = LCAPath(root, r2, list2);
        
        // If didn't find any of the node, just return a null.
        if (!find1 || !find2) {
            return null;
        }
        
        // 注意: 使用Iterator 对于linkedlist可以提高性能。
        // 所以 统一使用Iterator 来进行操作。
        Iterator<TreeNode> iter1 = list1.iterator();
        Iterator<TreeNode> iter2 = list2.iterator();
        
        TreeNode last = null;
        while (iter1.hasNext() && iter2.hasNext()) {
            TreeNode tmp1 = iter1.next();
            TreeNode tmp2 = iter2.next();
            
            if (tmp1 != tmp2) {
                return last;
            }
            
            last = tmp1;
        }
        
        // If never find any node which is different, means Node 1 and Node 2 are the same one.
        // so just return the last one.
        return last;
    }
    
    public static boolean LCAPath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        // if didn't find, we should return a empty path.
        if (root == null || node == null) {
            return false;
        }
        
        // First add the root node.
        path.add(root);
        
        // if the node is in the left side.
        if (root != node 
                && !LCAPath(root.left, node, path)
                && !LCAPath(root.right, node, path)
                ) {
            // Didn't find the node. should remove the node added before.
            path.remove(root);
            return false;
        }
        
        // found
        return true;
    }
    /*
     * 11. 求二叉树中两个节点的最低公共祖先节点：
     * Recursion Version:
     * LACRec 
     * 1. If found in the left tree, return the Ancestor.
     * 2. If found in the right tree, return the Ancestor.
     * 3. If Didn't find any of the node, return null.
     * 4. If found both in the left and the right tree, return the root.
     * */
    public static TreeNode LACRec(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        
        // If any of the node is the root, just return the root.
        if (root == node1 || root == node2) {
            return root;
        }
        
        // if no node is in the node, just recursively find it in LEFT and RIGHT tree.
        TreeNode left = LACRec(root.left, node1, node2);
        TreeNode right = LACRec(root.right, node1, node2);
        
        if (left == null) {  // If didn't found in the left tree, then just return it from right.
            return right;
        } else if (right == null) { // Or if didn't found in the right tree, then just return it from the left side.
            return left;
        } 
        
        // if both right and right found a node, just return the root as the Common Ancestor.
        return root;
    }
    
    /*
     * 11. 求BST中两个节点的最低公共祖先节点：
     * Recursive version:
     * LCABst 
     * 
     * 1. If found in the left tree, return the Ancestor.
     * 2. If found in the right tree, return the Ancestor.
     * 3. If Didn't find any of the node, return null.
     * 4. If found both in the left and the right tree, return the root.
     * */
    public static TreeNode LCABstRec(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        
        // If any of the node is the root, just return the root.
        if (root == node1 || root == node2) {
            return root;
        }
        
        int min = Math.min(node1.val, node2.val);
        int max = Math.max(node1.val, node2.val);
        
        // if the values are smaller than the root value, just search them in the left tree.
        if (root.val > max) {
            return LCABstRec(root.left, node1, node2);
        } else if (root.val < min) {
        // if the values are larger than the root value, just search them in the right tree.    
            return LCABstRec(root.right, node1, node2);
        }
        
        // if root is in the middle, just return the root.
        return root;
    }
    

    
    /*
     *  * 12. 求二叉树中节点的最大距离：getMaxDistanceRec
     *  
     *  首先我们来定义这个距离：
     *  距离定义为：两个节点间边的数目.
     *  如：
     *     1
     *    / \
     *   2   3
     *        \
     *         4
     *   这里最大距离定义为2，4的距离，为3.      
     * 求二叉树中节点的最大距离 即二叉树中相距最远的两个节点之间的距离。 (distance / diameter) 
     * 递归解法：
     * 返回值设计：
     * 返回1. 深度， 2. 当前树的最长距离  
     * (1) 计算左子树的深度，右子树深度，左子树独立的链条长度，右子树独立的链条长度
     * (2) 最大长度为三者之最：
     *    a. 通过根节点的链，为左右深度+2
     *    b. 左子树独立链
     *    c. 右子树独立链。
     * 
     * (3)递归初始条件：
     *   当root == null, depth = -1.maxDistance = -1;
     *   
     */  
    public static int getMaxDistanceRec(TreeNode root) {
        return getMaxDistanceRecHelp(root).maxDistance;
    }
    
    public static Result getMaxDistanceRecHelp(TreeNode root) {
        Result ret = new Result(-1, -1);
        
        if (root == null) {
            return ret;
        }
        
        Result left = getMaxDistanceRecHelp(root.left);
        Result right = getMaxDistanceRecHelp(root.right);
        
        // 深度应加1， the depth from the subtree to the root.
        ret.depth = Math.max(left.depth, right.depth) + 1;
        
        // 左子树，右子树与根的距离都要加1，所以通过根节点的路径为两边深度+2
        int crossLen = left.depth + right.depth + 2;
        
        // 求出cross根的路径，及左右子树的独立路径，这三者路径的最大值。
        ret.maxDistance = Math.max(left.maxDistance, right.maxDistance);
        ret.maxDistance = Math.max(ret.maxDistance, crossLen);
        
        return ret;
    }

    
    private static class Result {
        int depth;
        int maxDistance;
        public Result(int depth, int maxDistance) {
            this.depth = depth;
            this.maxDistance = maxDistance;
        }
    }
    
    /*
     *  13. 由前序遍历序列和中序遍历序列重建二叉树：rebuildBinaryTreeRec 
     *  We assume that there is no duplicate in the trees.
     *  For example:
     *          1
     *         / \
     *        2   3
     *       /\    \
     *      4  5    6
     *              /\
     *             7  8  
     *             
     *  PreOrder should be: 1   2 4 5   3 6 7 8
     *                      根   左子树    右子树  
     *  InOrder should be:  4 2 5   1   3 7 6 8
     *                       左子树  根  右子树
     * */                   
    public static TreeNode rebuildBinaryTreeRec(List<Integer> preOrder, List<Integer> inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        
        // If the traversal is empty, just return a NULL.
        if (preOrder.size() == 0 || inOrder.size() == 0) {
            return null;
        }
        
        // we can get the root from the preOrder. 
        // Because the first one is the root.
        // So we just create the root node here.
        TreeNode root = new TreeNode(preOrder.get(0));
        
        List<Integer> preOrderLeft;
        List<Integer> preOrderRight;
        List<Integer> inOrderLeft;
        List<Integer> inOrderRight;
        
        // 获得在 inOrder中，根的位置
        int rootInIndex = inOrder.indexOf(preOrder.get(0));
        preOrderLeft = preOrder.subList(1, rootInIndex + 1);
        preOrderRight = preOrder.subList(rootInIndex + 1, preOrder.size());
        
        // 得到inOrder左边的左子树
        inOrderLeft = inOrder.subList(0, rootInIndex);
        inOrderRight = inOrder.subList(rootInIndex + 1, inOrder.size());

        // 通过 Rec 来调用生成左右子树。
        root.left = rebuildBinaryTreeRec(preOrderLeft, inOrderLeft);
        root.right = rebuildBinaryTreeRec(preOrderRight, inOrderRight);
        
        return root;        
    }
    
    /*
     * 14. 判断二叉树是不是完全二叉树：isCompleteBinaryTree, isCompleteBinaryTreeRec
     * 进行level traversal, 一旦遇到一个节点的左节点为空，后面的节点的子节点都必须为空。而且不应该有下一行，其实就是队列中所有的
     * 元素都不应该再有子元素。
     * */
    
    public static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        
        TreeNode dummyNode = new TreeNode(0);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        q.offer(dummyNode);
        
        // if this is true, no node should have any child.
        boolean noChild = false;
        
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == dummyNode) {
                if (!q.isEmpty()) {
                    q.offer(dummyNode);
                }
                // Dummy node不需要处理。 
                continue;
            }
            
            if (cur.left != null) {
                // 如果标记被设置，则Queue中任何元素不应再有子元素。
                if (noChild) {
                    return false;
                }
                q.offer(cur.left);
            } else {
                // 一旦某元素没有左节点或是右节点，则之后所有的元素都不应有子元素。
                // 并且该元素不可以有右节点.
                noChild = true;
            }
            
            if (cur.right != null) {
                // 如果标记被设置，则Queue中任何元素不应再有子元素。
                if (noChild) {
                    return false;
                }
                q.offer(cur.right);
            } else {
                // 一旦某元素没有左节点或是右节点，则之后所有的元素都不应有子元素。
                noChild = true;
            }
        }
        
        return true;
    }
    
    /*
     * 14. 判断二叉树是不是完全二叉树：isCompleteBinaryTreeRec
     * 
     * 
     *    我们可以分解为：
     *    CompleteBinary Tree 的条件是：
     *    1. 左右子树均为Perfect binary tree, 并且两者Height相同
     *    2. 左子树为CompleteBinaryTree, 右子树为Perfect binary tree，并且两者Height差1
     *    3. 左子树为Perfect Binary Tree,右子树为CompleteBinaryTree, 并且Height 相同
     *    
     *    Base 条件：
     *    (1) root = null: 为perfect & complete BinaryTree, Height -1;
     *    
     *    而 Perfect Binary Tree的条件：
     *    左右子树均为Perfect Binary Tree,并且Height 相同。
     * */
    
    public static boolean isCompleteBinaryTreeRec(TreeNode root) {
        return isCompleteBinaryTreeRecHelp(root).isCompleteBT;
    }
    
    private static class ReturnBinaryTree {
        boolean isCompleteBT;
        boolean isPerfectBT;
        int height;
        
        ReturnBinaryTree(boolean isCompleteBT, boolean isPerfectBT, int height) {
            this.isCompleteBT = isCompleteBT;
            this.isPerfectBT = isPerfectBT;
            this.height = height;
        }
    }
    
    /*
     * 我们可以分解为：
     *    CompleteBinary Tree 的条件是：
     *    1. 左右子树均为Perfect binary tree, 并且两者Height相同
     *    2. 左子树为CompleteBinaryTree, 右子树为Perfect binary tree，并且两者Height差1
     *    3. 左子树为Perfect Binary Tree,右子树为CompleteBinaryTree, 并且Height 相同
     *    
     *    Base 条件：
     *    (1) root = null: 为perfect & complete BinaryTree, Height -1;
     *    
     *    而 Perfect Binary Tree的条件：
     *    左右子树均为Perfect Binary Tree,并且Height 相同。
     * */
    public static ReturnBinaryTree isCompleteBinaryTreeRecHelp(TreeNode root) {
        ReturnBinaryTree ret = new ReturnBinaryTree(true, true, -1);
        
        if (root == null) {
            return ret;
        }
        
        ReturnBinaryTree left = isCompleteBinaryTreeRecHelp(root.left);
        ReturnBinaryTree right = isCompleteBinaryTreeRecHelp(root.right);
        
        // 树的高度为左树高度，右树高度的最大值+1
        ret.height = 1 + Math.max(left.height, right.height);
        
        // set the isPerfectBT
        ret.isPerfectBT = false;
        if (left.isPerfectBT && right.isPerfectBT && left.height == right.height) {
            ret.isPerfectBT = true;
        }
        
        // set the isCompleteBT.
        /*
         * CompleteBinary Tree 的条件是：
         *    1. 左右子树均为Perfect binary tree, 并且两者Height相同(其实就是本树是perfect tree)
         *    2. 左子树为CompleteBinaryTree, 右子树为Perfect binary tree，并且两者Height差1
         *    3. 左子树为Perfect Binary Tree,右子树为CompleteBinaryTree, 并且Height 相同
         * */
        ret.isCompleteBT = ret.isPerfectBT 
                || (left.isCompleteBT && right.isPerfectBT && left.height == right.height + 1)
                || (left.isPerfectBT && right.isCompleteBT && left.height == right.height);
        
        return ret;
    }

    /*
     * 15. findLongest
     * 第一种解法：
     * 返回左边最长，右边最长，及左子树最长，右子树最长。
     * */
    public static int findLongest(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        TreeNode l = root;
        int cntL = 0;
        while (l.left != null) {
            cntL++;
            l = l.left;
        }
        
        TreeNode r = root;
        int cntR = 0;
        while (r.right != null) {
            cntR++;
            r = r.right;
        }
        
        int lmax = findLongest(root.left);
        int rmax = findLongest(root.right);
        
        int max = Math.max(lmax, rmax);
        max = Math.max(max, cntR);
        max = Math.max(max, cntL);
        
        return max;
    }
    
    /*      1
     *    2   3
     *  3       4
     *         6  1
     *        7
     *       9
     *     11
     *    2
     *  14      
     * */
    public static int findLongest2(TreeNode root) {
        int [] maxVal = new int[1];
        maxVal[0] = -1;
        findLongest2Help(root, maxVal);
        return maxVal[0];
    }
    
    // ret:
    // 0: the left side longest,
    // 1: the right side longest.
    static int maxLen = -1;
    static int[] findLongest2Help(TreeNode root, int[] maxVal) {
        int[] ret = new int[2];
        if (root == null) {
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
        
        ret[0] = findLongest2Help(root.left, maxVal)[0] + 1;
        ret[1] = findLongest2Help(root.right, maxVal)[1] + 1;
        //maxLen = Math.max(maxLen, ret[0]);
        //maxLen = Math.max(maxLen, ret[1]);
        maxVal[0] = Math.max(maxVal[0], ret[0]);
        maxVal[0] = Math.max(maxVal[0], ret[1]);

        return ret;
    }
} 