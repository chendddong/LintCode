import java.util.*;


/**
 * MENU:
 *
 * 1. Get all the nodes number:
 *     1) getNodeNumRec
 *     2) getNodeNum
 *
 * 2. Get the depth:
 *     1) getDepthRec
 *     2) getDepth
 *     3) getDepthTraverse (with global variable)
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
 *     3) levelOrderBFS
 *         -- LeetCode 102, 107
 *         -- LintCode 69, 70
 *
 * 5. Convert BST to Doubly LinkedList
 *     1) convertBST2DLLRec (refer to LintCode 378)
 *
 * 6. Get the number of Nodes from Kth level
 *     1) getNodeNumKthLevel
 *     2) getNodeNumKthLevelRec
 *
 * 7. Get the number of leaf nodes
 *     1) getNodeNumLeafRec
 *     2) getNodeNumLeafInorder
 *     3) getNodeNumLeafPreorder
 *     4) getNodeNumLeafPostorder
 *
 * 8. Are those BT the same
 *     1) isSameRec
 *     2) isSameInorder
 *     3) isSamePreorder
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
 *     1) LCA*
 *     2) LCARec
 *     3) LCABstRec
 *
 * 12. Max distance between nodes
 *     1) getMaxDistanceRec
 *
 * 13. Rebuild BT
 *     1) rebuildBinaryTreeRec
 *
 * 14. Is the BT Complete BT
 *     1) isCompleteBinaryTree*
 *     2) isCompleteBinaryTreeNoDummy*
 *     3) isCompleteBinaryTreeRec*
 *
 * 15. Longest Path (root to leaf)
 *     1) findLongest
 *
 * 16. Merge two BT
 *     1) mergeTreesRec (LeetCode 617)
 *
 * 17. Construct a string from BST
 *     1) tree2strRec
 *     2) tree2str
 *
 * 18. Minimum absolute difference between any nodes (LeetCode 530)
 *     1) getMinimumDifference
 *     2) getMinimumDifferenceArrayList
 *     3) getMinimumDifferenceTreeSet
 *
 * 19. The tilt of a tree (LeetCode 563)
 *     1) findTilt
 *
 * 20. Convert BST to Greater Tree (LeetCode 538, LintCode 661)
 *     1) convertBST
 *     2) convertBSTRec
 *
 * 21. Sum of all LEFT leaves (LeetCode 404)
 *     1) sumOfLeftLeavesRecVoid
 *     2) sumOfLeftLeavesRec
 *     3) sumOfLeftLeavesBFS
 *
 * 22. Convert Sorted Array to BST (LeetCode 108, LintCode 177)
 *     1) sortedArrayToBST
 *
 * 23. Tree 1 is subtree of Tree2 (LeetCode 572, LintCode 245)
 *     1) isSubtree
 *
 * 24. Path Sum
 *     1) hasPathSum (root to leaf LeetCode 112)
 *     2) binaryTreePathSumList (root to leaf)
 *         -- LeetCode 113
 *         -- LintCode 376
 */

public class TreeDemo {
    /* TreeNode */
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

    public static void main(String[] args) {
////////////////////////////////////////////////////////////////////////////////
        /*
            Tree 1: Basic Binary Tree
                      1
                    /   \
                   2     3
                 /  \     \
                4    5     6
              / \    /    / \
             9   10 11   7   8

             where r1 is the root
         */
////////////////////////////////////////////////////////////////////////////////

        /* Make Tree 1: */
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(8);
        TreeNode r9 = new TreeNode(9);
        TreeNode r10 = new TreeNode(10);
        TreeNode r11 = new TreeNode(11);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;
        r6.left = r7;
        r6.right = r8;
        r4.left = r9;
        r4.right = r10;
        r5.left = r11;
////////////////////////////////////////////////////////////////////////////////
        /*
            Tree 2: Binary Search Tree
                      100
                    /    \
                   40     180
                 /  \     /
                30   60  110

             where r100 is the root
         */
////////////////////////////////////////////////////////////////////////////////

        /* Making Tree 2: */
        TreeNode r100 = new TreeNode(100);
        TreeNode r40 = new TreeNode(40);
        TreeNode r180 = new TreeNode(180);
        TreeNode r30 = new TreeNode(30);
        TreeNode r60 = new TreeNode(60);
        TreeNode r110 = new TreeNode(110);

        r100.left = r40;
        r100.right = r180;
        r40.left =  r30;
        r40.right = r60;
        r180.left = r110;

////////////////////////////////////////////////////////////////////////////////

        /* Make lists for 13. rebuildBinaryTreeRec */
        List<Integer> preOrder = new ArrayList<>();
        preOrder.add(1);
        preOrder.add(2);
        preOrder.add(4);
        preOrder.add(9);
        preOrder.add(10);
        preOrder.add(5);
        preOrder.add(11);
        preOrder.add(3);
        preOrder.add(6);
        preOrder.add(7);
        preOrder.add(8);

        /* Make lists for 13. rebuildBinaryTreeRec */
        List<Integer> inOrder = new ArrayList<>();
        inOrder.add(9);
        inOrder.add(4);
        inOrder.add(10);
        inOrder.add(2);
        inOrder.add(11);
        inOrder.add(5);
        inOrder.add(1);
        inOrder.add(3);
        inOrder.add(7);
        inOrder.add(6);
        inOrder.add(8);

        /* Make lists for 22. sortedArrayToBST */
        int[] sortedArray = new int[11];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i + 1;
        }
//        /* Test for the inorderArray */
//        System.out.print(Arrays.toString(sortedArray));

////////////////////////////////////////////////////////////////////////////////

        /* Test all the methods */

//        /* 1.1 */
//        System.out.println("********************** 1.1 **********************");
//        System.out.print("The total number of nodes of Tree 1 is: ");
//        System.out.println(getNodeNumRec(r1));
//        System.out.print("The total number of nodes of Tree 2 is: ");
//        System.out.println(getNodeNumRec(r100));
//        /* 1.2 */
//        System.out.println("********************** 1.2 **********************");
//        System.out.print("The total number of nodes of Tree 1 is: ");
//        System.out.println(getNodeNum(r1));
//        System.out.print("The total number of nodes of Tree 2 is: ");
//        System.out.println(getNodeNum(r100));
//        /* 2.1 */
//        System.out.println("********************** 2.1 **********************");
//        System.out.print("The Depth of Tree 1 is: ");
//        System.out.println(getDepthRec(r1));
//        System.out.print("The Depth of Tree 2 is: ");
//        System.out.println(getDepthRec(r100));
//        /* 2.2 */
//        System.out.println("********************** 2.2 **********************");
//        System.out.print("The Depth of Tree 1 is: ");
//        System.out.println(getDepth(r1));
//        System.out.print("The Depth of Tree 2 is: ");
//        System.out.println(getDepth(r100));
//        /* 2.3 */
//        System.out.println("********************** 2.3 **********************");
//        System.out.print("The Depth of Tree 1 is: ");
//        System.out.println(getDepthTraverse(r1));
//        System.out.print("The Depth of Tree 2 is: ");
//        System.out.println(getDepthTraverse(r100));
//        /* 3.1 */
//        System.out.println("********************** 3.1 **********************");
//        System.out.print("The Preorder Traversal of Tree 1 is: ");
//        System.out.println();
//        preorderTraversalRec(r1);
//        System.out.println();
//        System.out.print("The Preorder Traversal of Tree 2 is: ");
//        System.out.println();
//        preorderTraversalRec(r100);
//        System.out.println();
//        /* 3.2 */
//        System.out.println("********************** 3.2 **********************");
//        System.out.print("The Preorder Traversal of Tree 1 is: ");
//        System.out.println();
//        preorderTraversal(r1);
//        System.out.println();
//        System.out.print("The Preorder Traversal of Tree 2 is: ");
//        System.out.println();
//        preorderTraversal(r100);
//        System.out.println();
//        /* 3.3 */
//        System.out.println("********************** 3.3 **********************");
//        System.out.print("The Inorder Traversal of Tree 1 is: ");
//        System.out.println();
//        inorderTraversalRec(r1);
//        System.out.println();
//        System.out.print("The Inorder Traversal of Tree 2 is: ");
//        System.out.println();
//        inorderTraversalRec(r100);
//        System.out.println();
//        /* 3.4 */
//        System.out.println("********************** 3.4 **********************");
//        System.out.print("The Inorder Traversal of Tree 1 is: ");
//        System.out.println();
//        inorderTraversal(r1);
//        System.out.println();
//        System.out.print("The Inorder Traversal of Tree 2 is: ");
//        System.out.println();
//        inorderTraversal(r100);
//        System.out.println();
//        /* 3.5 */
//        System.out.println("********************** 3.5 **********************");
//        System.out.print("The Postorder Traversal of Tree 1 is: ");
//        System.out.println();
//        postorderTraversalRec(r1);
//        System.out.println();
//        System.out.print("The Postorder Traversal of Tree 2 is: ");
//        System.out.println();
//        postorderTraversalRec(r100);
//        System.out.println();
//        /* 3.6 */
//        System.out.println("********************** 3.5 **********************");
//        System.out.print("The Postorder Traversal of Tree 1 is: ");
//        System.out.println();
//        postorderTraversal(r1);
//        System.out.println();
//        System.out.print("The Postorder Traversal of Tree 2 is: ");
//        System.out.println();
//        postorderTraversal(r100);
//        System.out.println();
//        /* 4.1 */
//        System.out.println("********************** 4.1 **********************");
//        System.out.print("The Level Traversal of Tree 1 is: ");
//        System.out.println();
//        levelTraversal(r1);
//        System.out.println();
//        System.out.print("The Level Traversal of Tree 2 is: ");
//        System.out.println();
//        levelTraversal(r100);
//        System.out.println();
//        /* 4.2 */
//        System.out.println("********************** 4.2 **********************");
//        System.out.print("The Level Order Traversal of Tree 1 is: ");
//        System.out.println();
//        levelTraversalRec(r1);
//        System.out.print("The Level Order Traversal of Tree 2 is: ");
//        System.out.println();
//        levelTraversalRec(r100);
//        /* 4.3 */
//        System.out.println("********************** 4.3 **********************");
//        System.out.print("The Level Order Traversal of Tree 1 is: ");
//        System.out.println();
//        System.out.println(levelOrderBFS(r1));
//        System.out.print("The Level Order Traversal of Tree 2 is: ");
//        System.out.println();
//        System.out.println(levelOrderBFS(r100));
//        /* 5.1 */
//        System.out.println("********************** 5.1 **********************");
//        System.out.println("Converting Tree 1 to DDL: ");
//        TreeNode ret = convertBST2DLLRec(r1);
//        while (ret != null) {
//            System.out.print(ret.val + " <-> ");
//            ret = ret.right;
//        }
//        System.out.println();
//        System.out.println("Converting Tree 2 to DDL: ");
//        TreeNode ret100 = convertBST2DLLRec(r100);
//        while (ret100 != null) {
//            System.out.print(ret100.val + " <-> ");
//            ret100 = ret100.right;
//        }
//        System.out.println();
//        /* 6.1 */
//        System.out.println("********************** 6.1 **********************");
//        levelTraversalRec(r1);
//        System.out.println("The 1st level of Tree 1 to DDL: "
//                + getNodeNumKth(r1, 1));
//        System.out.println("The 2nd level of Tree 1 to DDL: "
//                + getNodeNumKth(r1, 2));
//        System.out.println("The 3rd level of Tree 1 to DDL: "
//                + getNodeNumKth(r1, 3));
//        System.out.println("The 4th level of Tree 1 to DDL: "
//                + getNodeNumKth(r1, 4));
//        levelTraversalRec(r100);
//        System.out.println("The 1st level of Tree 2 to DDL: "
//                + getNodeNumKth(r100, 1));
//        System.out.println("The 2nd level of Tree 2 to DDL: "
//                + getNodeNumKth(r100, 2));
//        System.out.println("The 3rd level of Tree 2 to DDL: "
//                + getNodeNumKth(r100, 3));
//        System.out.println("The 4th level of Tree 2 to DDL: "
//                + getNodeNumKth(r100, 4));
//        /* 6.2 */
//        System.out.println("********************** 6.2 **********************");
//        levelTraversalRec(r1);
//        System.out.println("The 1st level of Tree 1 to DDL: "
//                + getNodeNumKthLevelRec(r1, 1));
//        System.out.println("The 2nd level of Tree 1 to DDL: "
//                + getNodeNumKthLevelRec(r1, 2));
//        System.out.println("The 3rd level of Tree 1 to DDL: "
//                + getNodeNumKthLevelRec(r1, 3));
//        System.out.println("The 4th level of Tree 1 to DDL: "
//                + getNodeNumKthLevelRec(r1, 4));
//        levelTraversalRec(r100);
//        System.out.println("The 1st level of Tree 2 to DDL: "
//                + getNodeNumKthLevelRec(r100, 1));
//        System.out.println("The 2nd level of Tree 2 to DDL: "
//                + getNodeNumKthLevelRec(r100, 2));
//        System.out.println("The 3rd level of Tree 2 to DDL: "
//                + getNodeNumKthLevelRec(r100, 3));
//        System.out.println("The 4th level of Tree 2 to DDL: "
//                + getNodeNumKthLevelRec(r100, 4));
//
//        /* 7.1 */
//        System.out.println("********************** 7.1 **********************");
//        System.out.println("The total number of leaves of Tree 1 is : "
//                + getNodeNumLeafRec(r1));
//        System.out.println("The total number of leaves of Tree 2 is : "
//                + getNodeNumLeafRec(r100));
//        /* 7.2 */
//        System.out.println("********************** 7.2 **********************");
//        System.out.println("The total number of leaves of Tree 1 is : "
//                + getNodeNumLeafInorder(r1));
//        System.out.println("The total number of leaves of Tree 2 is : "
//                + getNodeNumLeafInorder(r100));
//        /* 7.3 */
//        System.out.println("********************** 7.3 **********************");
//        System.out.println("The total number of leaves of Tree 1 is : "
//                + getNodeNumLeafPreorder(r1));
//        System.out.println("The total number of leaves of Tree 2 is : "
//                + getNodeNumLeafPreorder(r100));
//        /* 7.4 */
//        System.out.println("********************** 7.4 **********************");
//        System.out.println("The total number of leaves of Tree 1 is : "
//                + getNodeNumLeafPostorder(r1));
//        System.out.println("The total number of leaves of Tree 2 is : "
//                + getNodeNumLeafPostorder(r100));

//        /* 8.1 */
//        System.out.println("********************** 8.1 **********************");
//        System.out.print("Are the two trees the same" + " (r1, r1): ");
//        System.out.println(isSameRec(r1, r1));
//        System.out.print("Are the two trees the same" + " (r2, r4): ");
//        System.out.println(isSameRec(r2, r4));
//        System.out.print("Are the two trees the same" + " (r8, r8): ");
//        System.out.println(isSameRec(r8, r8));
//        System.out.print("Are the two trees the same" + " (r100, r100): ");
//        System.out.println(isSameRec(r100, r100));
//        System.out.print("Are the two trees the same" + " (r60, r40): ");
//        System.out.println(isSameRec(r60, r40));
//        System.out.print("Are the two trees the same" + " (r30, r30): ");
//        System.out.println(isSameRec(r30, r30));
//        /* 8.2 */
//        System.out.println("********************** 8.2 **********************");
//        System.out.print("Are the two trees the same" + " (r1, r1): ");
//        System.out.println(isSameInorder(r1, r1));
//        System.out.print("Are the two trees the same" + " (r2, r4): ");
//        System.out.println(isSameInorder(r2, r4));
//        System.out.print("Are the two trees the same" + " (r8, r8): ");
//        System.out.println(isSameInorder(r8, r8));
//        System.out.print("Are the two trees the same" + " (r100, r100): ");
//        System.out.println(isSameInorder(r100, r100));
//        System.out.print("Are the two trees the same" + " (r60, r40): ");
//        System.out.println(isSameInorder(r60, r40));
//        System.out.print("Are the two trees the same" + " (r30, r30): ");
//        System.out.println(isSameInorder(r30, r30));
//        /* 8.3 */
//        System.out.println("********************** 8.3 **********************");
//        System.out.print("Are the two trees the same" + " (r1, r1): ");
//        System.out.println(isSamePreorder(r1, r1));
//        System.out.print("Are the two trees the same" + " (r2, r4): ");
//        System.out.println(isSamePreorder(r2, r4));
//        System.out.print("Are the two trees the same" + " (r8, r8): ");
//        System.out.println(isSamePreorder(r8, r8));
//        System.out.print("Are the two trees the same" + " (r100, r100): ");
//        System.out.println(isSamePreorder(r100, r100));
//        System.out.print("Are the two trees the same" + " (r60, r40): ");
//        System.out.println(isSamePreorder(r60, r40));
//        System.out.print("Are the two trees the same" + " (r30, r30): ");
//        System.out.println(isSamePreorder(r30, r30));
//        /* 9.1 */
//        System.out.println("********************** 9.1 **********************");
//        System.out.print("The tree is an balanced binary tree: " + "(r1): " );
//        System.out.println(isAVLRec(r1));
//        System.out.print("The tree is an balanced binary tree: " + "(r2): " );
//        System.out.println(isAVLRec(r2));
//        System.out.print("The tree is an balanced binary tree: " + "(r3): " );
//        System.out.println(isAVLRec(r3));
//        System.out.print("The tree is an balanced binary tree: " + "(r4): " );
//        System.out.println(isAVLRec(r4));
//        System.out.print("The tree is an balanced binary tree: " + "(r5): " );
//        System.out.println(isAVLRec(r5));
//        System.out.print("The tree is an balanced binary tree: " + "(r6): " );
//        System.out.println(isAVLRec(r6));
//        System.out.print("The tree is an balanced binary tree: " + "(r100): " );
//        System.out.println(isAVLRec(r100));
//        /* 9.2 */
//        System.out.println("********************** 9.2 **********************");
//        System.out.print("The tree is an balanced binary tree: " + "(r1): " );
//        System.out.println(isAVLResultType(r1));
//        System.out.print("The tree is an balanced binary tree: " + "(r2): " );
//        System.out.println(isAVLResultType(r2));
//        System.out.print("The tree is an balanced binary tree: " + "(r3): " );
//        System.out.println(isAVLResultType(r3));
//        System.out.print("The tree is an balanced binary tree: " + "(r4): " );
//        System.out.println(isAVLResultType(r4));
//        System.out.print("The tree is an balanced binary tree: " + "(r5): " );
//        System.out.println(isAVLResultType(r5));
//        System.out.print("The tree is an balanced binary tree: " + "(r6): " );
//        System.out.println(isAVLResultType(r6));
//        System.out.print("The tree is an balanced binary tree: " + "(r100): " );
//        System.out.println(isAVLResultType(r100));
//        /* 10.1 */
//        System.out.println("********************* 10.1 *********************");
//        System.out.println("The original tree1 is : ");
//        System.out.println(levelOrderBFS(r1));
//        System.out.println("The mirror tree1 is : ");
//        System.out.println(levelOrderBFS(mirrorRec(r1)));
//        System.out.println("The original tree2 is : ");
//        System.out.println(levelOrderBFS(r100));
//        System.out.println("The mirror tree2 is : ");
//        System.out.println(levelOrderBFS(mirrorRec(r100)));
//        /* 10.2 */
//        System.out.println("********************* 10.2 *********************");
//        System.out.println("The original tree1 is : ");
//        System.out.println(levelOrderBFS(r1));
//        System.out.println("The mirror tree1 is : ");
//        System.out.println(levelOrderBFS(mirror(r1)));
//        System.out.println("The original tree2 is : ");
//        System.out.println(levelOrderBFS(r100));
//        System.out.println("The mirror tree2 is : ");
//        System.out.println(levelOrderBFS(mirror(r100)));
//        /* 10.3 */
//        System.out.println("********************* 10.3 *********************");
//        System.out.println("The original tree1 is : ");
//        System.out.println(levelOrderBFS(r1));
//        System.out.println("The mirror tree1 is : ");
//        System.out.println(levelOrderBFS(mirrorCopyRec(r1)));
//        System.out.println("The original tree2 is : ");
//        System.out.println(levelOrderBFS(r100));
//        System.out.println("The mirror tree2 is : ");
//        System.out.println(levelOrderBFS(mirrorCopyRec(r100)));
//        /* 10.4 */
//        System.out.println("********************* 10.4 *********************");
//        System.out.println("The original tree1 is : ");
//        System.out.println(levelOrderBFS(r1));
//        System.out.println("The mirror tree1 is : ");
//        System.out.println(levelOrderBFS(mirrorCopy(r1)));
//        System.out.println("The original tree2 is : ");
//        System.out.println(levelOrderBFS(r100));
//        System.out.println("The mirror tree2 is : ");
//        System.out.println(levelOrderBFS(mirrorCopy(r100)));
//        /* 10.1.1 */
//        System.out.println("******************* 10.1.1 *******************");
//        System.out.println("Comparing the tree 1 and its mirror copy : ");
//        System.out.println(isMirror(r1,mirrorCopy(r1)));
//        System.out.println("Comparing the tree 1 and tree 1 : ");
//        System.out.println(isMirror(r1, r1));
//        System.out.println("Comparing the tree 2 and its mirror copy : ");
//        System.out.println(isMirror(r100,mirrorCopy(r100)));
//        System.out.println("Comparing the tree 2 and tree 2 : ");
//        System.out.println(isMirror(r100, r100));
//        /* 10.1.2 */
//        System.out.println("******************* 10.1.2 *******************");
//        System.out.println("Comparing the tree 1 and its mirror copy : ");
//        System.out.println(isMirrorRec(r1,mirrorCopyRec(r1)));
//        System.out.println("Comparing the tree 1 and tree 1 : ");
//        System.out.println(isMirrorRec(r1, r1));
//        System.out.println("Comparing the tree 2 and its mirror copy : ");
//        System.out.println(isMirrorRec(r100,mirrorCopyRec(r100)));
//        System.out.println("Comparing the tree 2 and tree 2 : ");
//        System.out.println(isMirrorRec(r100, r100));
//        /* 11.1 */
//        System.out.println("********************* 11.1 *********************");
//        System.out.print("The Least Common Ancestor of r5 and r10: r");
//        System.out.println(LCA(r1, r10, r5).val);
//        System.out.print("The Least Common Ancestor of r30 and r60: r");
//        System.out.println(LCA(r100, r30, r60).val);
//        /* 11.2 */
//        System.out.println("********************* 11.2 *********************");
//        System.out.print("The Least Common Ancestor of r2 and r8: r");
//        System.out.println(LCARec(r1, r2, r8).val);
//        System.out.print("The Least Common Ancestor of r110 and r180: r");
//        System.out.println(LCARec(r100, r110, r180).val);
//        /* 11.3 */
//        System.out.println("********************* 11.3 *********************");
//        System.out.print("The Least Common Ancestor of r110 and r180: r");
//        System.out.println(LCABstRec(r100, r110, r180).val);
//        System.out.print("The Least Common Ancestor of r60 and r30: r");
//        System.out.println(LCABstRec(r100, r60, r30).val);
//        /* 12.1 */
//        System.out.println("********************* 12.1 *********************");
//        System.out.print("The max distance of Tree 1 is: ");
//        System.out.println(getMaxDistanceRec(r1));
//        System.out.print("The max distance of Tree 2 is: ");
//        System.out.println(getMaxDistanceRec(r100));
//        /* 13.1 */
//        System.out.println("********************* 13.1 *********************");
//        System.out.println("The newly built tree's preorder traversal is: ");
//        preorderTraversalRec(rebuildBinaryTreeRec(preOrder, inOrder));
//        System.out.println();
//        System.out.println("The Tree1's preorder traversal is: ");
//        preorderTraversalRec(r1);
//        System.out.println();
//        System.out.println();
//        System.out.println("The newly built tree's inorder traversal is: ");
//        inorderTraversalRec(rebuildBinaryTreeRec(preOrder, inOrder));
//        System.out.println();
//        System.out.println("The Tree1's inorder traversal is: ");
//        inorderTraversalRec(r1);
//        /* 14.1 14.2 14.3 */
//        System.out.println("********************* 14 *********************");
//        System.out.print("Tree 2 a complete BT : ");
//        System.out.println(isCompleteBinaryTree(r100));
//        System.out.print("Tree 1 a complete BT : ");
//        System.out.println(isCompleteBinaryTree(r1));
//        System.out.println();
//        System.out.print("Tree 2 a complete BT : ");
//        System.out.println(isCompleteBinaryTreeNoDummy(r100));
//        System.out.print("Tree 1 a complete BT : ");
//        System.out.println(isCompleteBinaryTreeNoDummy(r1));
//        System.out.println();
//        System.out.print("Tree 2 a complete BT : ");
//        System.out.println(isCompleteBinaryTreeRec(r100));
//        System.out.print("Tree 1 a complete BT : ");
//        System.out.println(isCompleteBinaryTreeRec(r1));
//        /* 15.1 */
//        System.out.println("********************* 15.1 *********************");
//        System.out.print("The longest path from root to leaf for Tree1 is: ");
//        System.out.println(findLongest(r1));
//        System.out.print("The longest path from root to leaf for Tree2 is: ");
//        System.out.println(findLongest(r100));
//        /* 16.1 */
//        System.out.println("********************* 16.1 *********************");
//        System.out.println("The original Tree 1: ");
//        System.out.println(levelOrderBFS(r1));
//        System.out.println("Merging Tree 1 and Tree 1: ");
//        System.out.println(levelOrderBFS(mergeTrees(r1, r1)));
//        /* 17.1 */
//        System.out.println("********************* 17.1 *********************");
//        System.out.println("The original Tree 1: ");
//        preorderTraversal(r1);
//        System.out.println();
//        System.out.println("The string which is constructed by Tree 1: ");
//        System.out.println(tree2strRec(r1));
//        System.out.println();
//        System.out.println("The original Tree 2: ");
//        preorderTraversal(r100);
//        System.out.println();
//        System.out.println("The string which is constructed by Tree 2: ");
//        System.out.println(tree2strRec(r100));
//        /* 17.2 */
//        System.out.println("********************* 17.2 *********************");
//        System.out.println("The original Tree 1: ");
//        preorderTraversal(r1);
//        System.out.println();
//        System.out.println("The string which is constructed by Tree 1: ");
//        System.out.println(tree2str(r1));
//        System.out.println();
//        System.out.println("The original Tree 2: ");
//        preorderTraversal(r100);
//        System.out.println();
//        System.out.println("The string which is constructed by Tree 2: ");
//        System.out.println(tree2str(r100));
//        /* 18.1 Tree2 We can't test Tree1 since it's not a BST */
//        System.out.println("********************* 18.1 *********************");
//        System.out.print("The min abs distance between any nodes in Tree2: ");
//        System.out.println(getMinimumDifference(r100));
//        /* 18.2 */
//        System.out.println("********************* 18.2 *********************");
//        System.out.print("The min abs distance between any nodes in Tree1: ");
//        System.out.println(getMinimumDifferenceArrayList(r1));
//        System.out.print("The min abs distance between any nodes in Tree2: ");
//        System.out.println(getMinimumDifferenceArrayList(r100));
//        /* 18.3 Tree1 */
//        System.out.println("********************* 18.3 *********************");
//        System.out.print("The min abs distance between any nodes in Tree1: ");
//        System.out.println(getMinimumDifferenceTreeSet(r1));
//        /* 18.3 Tree2 */
//        System.out.print("The min abs distance between any nodes in Tree2: ");
//        System.out.println(getMinimumDifferenceTreeSet(r100));
//        /* 19.1 Tree 1 */
//        System.out.println("********************* 19.1 *********************");
//        System.out.print("The tilt of Tree 1 is: ");
//        System.out.println(findTilt(r1));
//        System.out.println("Expected Number is: " + (1 + 11 + 1 + 7 + 21 + 17));
//        /* 19.1 Tree 2 */
//        System.out.print("The tilt of Tree 2 is: ");
//        System.out.println(findTilt(r100));
//        System.out.println("Expected Number is: " + (30 + 110 + 290 - 130));
//        /* 20.1, 20.2 */
//        System.out.println("********************* 20.1 *********************");
//        System.out.println("The original Tree 2 is: ");
//        inorderTraversal(r100);
//        System.out.println();
//        System.out.println("The Greater Tree of Tree 2 is: ");
//        inorderTraversal(convertBST(r100));
//        System.out.println("********************* 20.2 *********************");
//        System.out.println("The Greater tree of Tree 2 is: ");
//        inorderTraversal(r100);
//        System.out.println();
//        System.out.println("The Greater Greater Tree of Tree 2 is: ");
//        inorderTraversal(convertBSTRec(r100));
//        /* 21.1 */
//        System.out.println("********************* 21.1 *********************");
//        /* 21.1 Tree 1 */
//        System.out.print("All the sum of Tree1's LEFT leaves is: ");
//        System.out.println(sumOfLeftLeavesRecVoid(r1));
//        /* 21.1 Tree 2 */
//        System.out.print("All the sum of Tree2's LEFT leaves is: ");
//        System.out.println(sumOfLeftLeavesRecVoid(r100));
//        /* 21.2 */
//        System.out.println("********************* 21.2 *********************");
//        System.out.print("All the sum of Tree1's LEFT leaves is: ");
//        System.out.println(sumOfLeftLeavesRec(r1));
//        System.out.print("All the sum of Tree2's LEFT leaves is: ");
//        System.out.println(sumOfLeftLeavesRec(r100));
//        /* 21.3 */
//        System.out.println("********************* 21.3 *********************");
//        System.out.print("All the sum of Tree1's LEFT leaves is: ");
//        System.out.println(sumOfLeftLeavesBFS(r1));
//        System.out.print("All the sum of Tree2's LEFT leaves is: ");
//        System.out.println(sumOfLeftLeavesBFS(r100));
//        /* 22.1 */
//        System.out.println("********************* 22.1 *********************");
//        System.out.println("The converted BST by 'sortedArray' is : ");
//        System.out.println(levelOrderBFS(sortedArrayToBST(sortedArray)));
//        System.out.println("Test the inorder traversal for the new BST:  ");
//        inorderTraversal(sortedArrayToBST(sortedArray));
//        /* 23.1 */
//        System.out.println("********************* 23.1 *********************");
//        System.out.print("r1 is the subtree of r1 : ");
//        System.out.println(isSubtree(r1, r1));
//        System.out.print("r5 is the subtree of r1 : ");
//        System.out.println(isSubtree(r1, r5));
//        System.out.print("r1 is the subtree of r5 : ");
//        System.out.println(isSubtree(r5, r1));
//        System.out.print("r1 is the subtree of r100 : ");
//        System.out.println(isSubtree(r1, r100));
//        System.out.print("r110 is the subtree of r100 : ");
//        System.out.println(isSubtree(r100, r110));
//        /* 24.1 */
//        System.out.println("********************* 24.1 *********************");
//        System.out.print("Tree 1 has a path sum of 17 : ");
//        System.out.println(hasPathSum(r1, 17));
//        System.out.print("Tree 1 has a path sum of 55 : ");
//        System.out.println(hasPathSum(r1, 55));
//        System.out.print("Tree 2 has a path sum of 200 : ");
//        System.out.println(hasPathSum(r100, 200));
//        System.out.print("Tree 2 has a path sum of  300 : ");
//        System.out.println(hasPathSum(r100, 300));
//        /* 24.2 */
//        System.out.println("********************* 24.2 *********************");
//        System.out.println("The Path Sum of Tree 1 equals 17 is : ");
//        List<List<Integer>> result = binaryTreePathSumList(r1, 17);
//        for (List list : result) {
//            for (Object element : list) {
//                System.out.print(element + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("The Path Sum of Tree 2 equals 200 is : ");
//        List<List<Integer>> result2 = binaryTreePathSumList(r100, 200);
//        for (List list : result2) {
//            for (Object element : list) {
//                System.out.print(element + " ");
//            }
//            System.out.println();
//        }








}


////////////////////////////////////////////////////////////////////////////////

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
    public static int getDepth(TreeNode root) {
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
    private static int depth;
    public static int getDepthTraverse(TreeNode root) {
        depth = 0;
        /* Current root is root, current depth is 0 */
        helper(root, 0);

        return depth;
    }
    private static void helper(TreeNode root, int curDepth) {
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

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
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
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        levelTraversalVisit(root, 0, ret);
        System.out.println(ret);
    }
    private static void levelTraversalVisit(TreeNode root,
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
            ret.add(new ArrayList<>());
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

    public static ArrayList<ArrayList<Integer>> levelOrderBFS(TreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
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

    //////////////////////////////
    // 2) getNodeNumLeafInorder //
    //////////////////////////////

    /* We can use any one of those traversal method, for example in-order */
    public static int getNodeNumLeafInorder(TreeNode root) {
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

    ///////////////////////////////
    // 3) getNodeNumLeafPreorder //
    ///////////////////////////////

    /* We can use any one of those traversal method, for example pre-order */
    public static int getNodeNumLeafPreorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode node = s.pop();

            if (node.left == null && node.right == null) {
                count++;
            }

            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }

        return count;

    }

    ////////////////////////////////
    // 4) getNodeNumLeafPostorder //
    ////////////////////////////////

    /* We can use any one of those traversal method, for example post-order */
    public static int getNodeNumLeafPostorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        ArrayDeque<TreeNode> out = new ArrayDeque<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node.left == null && node.right == null) {
                count++;
            }
            if (node.left != null) {
                s.push(node.left);
            }
            if (node.right != null) {
                s.push(node.right);
            }
        }

        return count;
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

    //////////////////////
    // 2) isSameInorder //
    //////////////////////

    /* We can use in-order traversal to compare with the two nodes */
    public static boolean isSameInorder(TreeNode r1, TreeNode r2) {
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

    ///////////////////////
    // 3) isSamePreorder //
    ///////////////////////

    /* This is the Preorder traversal */
    public static boolean isSamePreorder(TreeNode r1, TreeNode r2) {
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
private static class ResultType9 {
    boolean isBalanced;
    int maxDepth;
    public ResultType9(boolean isBalanced, int maxDepth) {
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}
    public static boolean isAVLResultType(TreeNode root) {
        return helper(root).isBalanced;
    }
    private static ResultType9 helper(TreeNode root) {
        if (root == null) {
            return new ResultType9(true, 0);
        }

        ResultType9 left = helper(root.left);
        ResultType9 right = helper(root.right);

        /* subtree not balance */
        /* see if the left and the right are balanced */
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType9(false, -1);
        }

        /* root not balance */
        /* we can use 0 for the maxDepth */
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType9(false, -1);
        }

        return new ResultType9(true,
                Math.max(left.maxDepth, right.maxDepth) + 1);
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

    ///////////////
    // 2) mirror //
    ///////////////

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

    //////////////////////
    // 3) mirrorCopyRec //
    //////////////////////

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

    ///////////////////
    // 4) mirrorCopy //
    ///////////////////

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
    // 1) LCA //
    ////////////

    /* Record the path along the way and compare them */
    public static TreeNode LCA(TreeNode root, TreeNode r1, TreeNode r2) {
        /* Edge case */
        if (root == null || r1 == null || r2 == null) {
            return null;
        }

        /* Initialize two dynamic arrays */
        ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();

        /* See if we can find the path */
        boolean find1 = LCAPath(root, r1, list1);
        boolean find2 = LCAPath(root, r2, list2);

        /* If didn't find any of the node, just return a null. */
        if (!find1 || !find2) {
            return null;
        }

        /* Note that it would boot the performance if we use Iterator. */
        Iterator<TreeNode> iter1 = list1.iterator();
        Iterator<TreeNode> iter2 = list2.iterator();

        /* Iterate and compare the node */
        TreeNode last = null;
        while (iter1.hasNext() && iter2.hasNext()) {
            TreeNode tmp1 = iter1.next();
            TreeNode tmp2 = iter2.next();

            if (tmp1 != tmp2) {
                return last;
            }

            last = tmp1;
        }

        /*
            If we cannot find any node which is different, which means Node 1
            and Node 2 are the same node. So just return the last one.
         */

        return last;
    }
    public static boolean LCAPath(TreeNode root,
                                  TreeNode node,
                                  ArrayList<TreeNode> path) {
        /* if can't find the node in the tree, we should return a empty path. */
        if (root == null || node == null) {
            return false;
        }

        /* Add the root node */
        path.add(root);

        if (root != node
                && !LCAPath(root.left, node, path)
                && !LCAPath(root.right, node, path)
                ) {
            /*
                Didn't find the node. We should remove the node added before.
                AKA backtracking
            */
            path.remove(root);
            return false;
        }

        /* Found the node */
        return true;
    }

    ///////////////
    // 2) LCARec //
    ///////////////

    /*
        (1) null situation
        (2) root situation
        (3) left null and right null situation
     */
    public static TreeNode LCARec(TreeNode root, TreeNode node1, TreeNode node2)
    {
        /* (1) */
        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        /* (2) */
        if (root == node1 || root == node2) {
            return root;
        }

        /* (3) */
        TreeNode left = LCARec(root.left, node1, node2);
        TreeNode right = LCARec(root.right, node1, node2);

        /* If didn't find LCA the left tree, then just return it from right. */
        if (left == null) {
            return right;
        /* If didn't find LCA the right tree, then just return it from left. */
        } else if (right == null) {
            return left;
        }

        /* If we found LCA from both sides, just return the root */
        return root;
    }

    //////////////////
    // 3) LCABstRec //
    //////////////////

    /*
        We could also use 2) LCARec to solve this since BST's also BT. And this
        algorithm could be log(n) if it is an AVL. The runtime of LCARec is O(n).
     */
    public static TreeNode LCABstRec(TreeNode root, TreeNode node1, TreeNode node2) {
        /* Null work */
        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        /* Root work */
        if (root == node1 || root == node2) {
            return root;
        }

        /* Got the min and max and compare */
        int min = Math.min(node1.val, node2.val);
        int max = Math.max(node1.val, node2.val);

        /* If root val is larger than max, Go left */
        if (root.val > max) {
            return LCABstRec(root.left, node1, node2);
        } else if (root.val < min) {
        /* If root val is smaller than min, Go right */
            return LCABstRec(root.right, node1, node2);
        }

        /* if root is in the middle, just return the root */
        return root;
    }

////////////////////////////////////
// 12. Max distance between nodes //
////////////////////////////////////

//////////////////////////
// 1) getMaxDistanceRec //
//////////////////////////

/*
    What is the distance between two nodes: the edges between two nodes.
    Example:
              1
             / \
            2   3
           / \   \
          5  6    4
    So the distance between 2 and 4 is 3 and the max distance for the tree
    is the distance(the distance between far left node and far right node)
    between 5 and 4 which is 4.

    We will use ResultType to keep track of:
    1 -- the Depth of the node.
    2 -- the maxDistance of the current branch.

    Algorithm:
    1 -- calculate the Depth of left and right side, respectively;
         calculate the Distance of left and right side, respectively;
    2 -- Max distance is the max between the three:
        a. If it goes through the root, depth + 2
        b. Left side distance
        c. Right side distance
    3 -- Base case of the recursion:
        root == null, depth = -1, maxDistance = -1;
 */
private static class ResultType12 {
    int depth;
    int maxDistance;
    public ResultType12(int depth, int maxDistance) {
        this.depth = depth;
        this.maxDistance = maxDistance;
    }
}
    public static int getMaxDistanceRec(TreeNode root) {
        return getMaxDistanceRecHelp(root).maxDistance;
    }
    private static ResultType12 getMaxDistanceRecHelp(TreeNode root) {
        /* Base */
        ResultType12 ret = new ResultType12(-1, -1);
        if (root == null) {
            return ret;
        }

        ResultType12 left = getMaxDistanceRecHelp(root.left);
        ResultType12 right = getMaxDistanceRecHelp(root.right);


        /* The depth from the subtree to the root. */
        ret.depth = Math.max(left.depth, right.depth) + 1;

        /* If the path go through the root, it should add 2 */
        int crossLen = left.depth + right.depth + 2;

        /* Calculate the largest between the 3 things */
        ret.maxDistance = Math.max(left.maxDistance, right.maxDistance);
        ret.maxDistance = Math.max(ret.maxDistance, crossLen);

        return ret;
    }

////////////////////
// 13. Rebuild BT //
////////////////////

    /////////////////////////////
    // 1) rebuildBinaryTreeRec //
    /////////////////////////////

    /*
       We assume that there is no duplicate in the trees.
       For example:
               1
              / \
             2   3
            / \   \
           4   5   6
                   /\
                  7  8

       PreOrder should be: 1        2 4 5   3 6 7 8
                           root     Left    right
       InOrder should be:  4 2 5    1       3 7 6 8
                           Left     root    right
     */
    public static TreeNode rebuildBinaryTreeRec(List<Integer> preOrder,
                                                List<Integer> inOrder)
    {
        /* Null yeah */
        if (preOrder == null || inOrder == null) {
            return null;
        }

        /* Size matters */
        if (preOrder.size() == 0 || inOrder.size() == 0) {
            return null;
        }

        /* Create the root from the preorder list (first of the list) */
        TreeNode root = new TreeNode(preOrder.get(0));

        List<Integer> preOrderLeft;
        List<Integer> preOrderRight;
        List<Integer> inOrderLeft;
        List<Integer> inOrderRight;

        /* Get the root index in the inorder list */
        int rootInIndex = inOrder.indexOf(preOrder.get(0));

        /* LIST.sublist(a,b) behaves like String.substring(a,b) */
        preOrderLeft = preOrder.subList(1, rootInIndex + 1);
        preOrderRight = preOrder.subList(rootInIndex + 1, preOrder.size());

        /* Get the 'left' and 'right' side of the tree */
        inOrderLeft = inOrder.subList(0, rootInIndex);
        inOrderRight = inOrder.subList(rootInIndex + 1, inOrder.size());

        /* Recursively build the tree by connecting to the right children */
        root.left = rebuildBinaryTreeRec(preOrderLeft, inOrderLeft);
        root.right = rebuildBinaryTreeRec(preOrderRight, inOrderRight);

        return root;
    }

///////////////////////////////
// 14. Is the BT Complete BT //
///////////////////////////////

    /////////////////////////////
    // 1) isCompleteBinaryTree //
    /////////////////////////////

    /*
        We will perform level traversal using a Queue.

        Complete binary tree:
        1.  Once we find that the one of the node's left child is null, the next
        coming children should be all null
        2.  There is no next level which means that all the nodes in the queue
        should not have children.
     */
    public static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        TreeNode dummyNode = new TreeNode(0);
        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();

        q.offer(root);
        /* For separating the level; We can also use a loop to separate nodes */
        q.offer(dummyNode);

        /* If this flag is true, no node should have any children. */
        boolean noChild = false;

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == dummyNode) {
                if (!q.isEmpty()) {
                    q.offer(dummyNode);
                }
                /* We do not need to process the dummy node. */
                continue;
            }

            if (cur.left != null) {
                /*
                    Flag the node child again and there should be no children
                    for those nodes in the queue
                */
                if (noChild) {
                    return false;
                }
                q.offer(cur.left);
            } else {
                /*
                    If the one of the nodes does not have the left or right
                    children, the rest of the nodes after that node should not
                    have any children. And this node can't have the right child
                */
                noChild = true;
            }

            /* Same for the right side */
            if (cur.right != null) {
                if (noChild) {
                    return false;
                }
                q.offer(cur.right);
            } else {
                noChild = true;
            }
        }

        return true;
    }

    ////////////////////////////////////
    // 2) isCompleteBinaryTreeNoDummy //
    ////////////////////////////////////

    /* We can also use a for loop to separate nodes */
    public static boolean isCompleteBinaryTreeNoDummy(TreeNode root) {
        if (root == null) {
            return false;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean noChild = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    if (noChild) {
                        return false;
                    }
                    q.offer(node.left);
                } else {
                    noChild = true;
                }

                if (node.right != null) {
                    if (noChild) {
                        return false;
                    }
                    q.offer(node.right);
                } else {
                    noChild = true;
                }
            }
        }

        return true;
    }

////////////////////////////////
// 3) isCompleteBinaryTreeRec //
////////////////////////////////

/*
    There are 3 conditions:
    • Left branch and right branch are all Perfect with the same Height.
    • Left branch is Complete; Right branch is Perfect; Height differs 1.
    • Left branch is Perfect; Right branch is Complete; Same height.

    Base case:
    root = null, both Perfect and Complete, Height = -1;
 */
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
    public static boolean isCompleteBinaryTreeRec(TreeNode root) {
        return isCompleteBinaryTreeRecHelp(root).isCompleteBT;
    }
    public static ReturnBinaryTree isCompleteBinaryTreeRecHelp(TreeNode root) {
        ReturnBinaryTree result = new ReturnBinaryTree(true, true, -1);
        /* Base */
        if (root == null) {
            return result;
        }
        /* Divide */
        ReturnBinaryTree left = isCompleteBinaryTreeRecHelp(root.left);
        ReturnBinaryTree right = isCompleteBinaryTreeRecHelp(root.right);

        /* Height */
        result.height = 1 + Math.max(left.height, right.height);

        /* set the result isPerfectBT */
        result.isPerfectBT = false;

        /* Perfect */
        if (left.isPerfectBT &&
                right.isPerfectBT &&
                left.height == right.height) {

            result.isPerfectBT = true;
        }

        /* Complete -- the 3 conditions */
        result.isCompleteBT = result.isPerfectBT
                || (left.isCompleteBT && right.isPerfectBT && left.height == right.height + 1)
                || (left.isPerfectBT && right.isCompleteBT && left.height == right.height);

        return result;
    }

/////////////////////////////////////
// 15. Longest Path (root to leaf) //
/////////////////////////////////////

    ////////////////////
    // 1) findLongest //
    ////////////////////

    /*
        Count to the far left and count to the far right;
        Count the left child's Longest and right child's Longest;
        Find the max of them
     */
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

//////////////////////
// 16. Merge two BT //
//////////////////////

    //////////////////////
    // 1) mergeTreesRec //
    //////////////////////

    /*
        The merge rule is that if two nodes overlap, then sum node values up as
        the new value of the merged node.
     */

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);

        TreeNode newRoot = new TreeNode(t1.val + t2.val);
        newRoot.left  = left;
        newRoot.right = right;
        return newRoot;
    }

/////////////////////////////////////
// 17. Construct a string from BST //
/////////////////////////////////////

    ////////////////////
    // 1) tree2strRec //
    ////////////////////

    public static String tree2strRec(TreeNode t) {
        if(t == null)
            return "";
        // 1
        if(t.left == null && t.right == null)
            return t.val + "";
        //    1
        //   /
        //  2
        if(t.right == null)
            return t.val + "(" + tree2strRec(t.left) + ")";
        //  1          1
        //   \   or   / \
        //    2      2   3
        return t.val + "(" + tree2strRec(t.left) + ")(" + tree2strRec(t.right) + ")";
    }

    /////////////////
    // 2) tree2str //
    /////////////////

    public static String tree2str(TreeNode t) {
        if (t == null)
            return "";

        /* For traversal */
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(t);
        /* Mark the visited node */
        Set<TreeNode> visited = new HashSet<>();
        String s = "";
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s += ")";
            } else {
                /* Solve the problem */
                visited.add(t);
                s += "(" + t.val;
                if (t.left == null && t.right != null)
                    s += "()";

                /* Preorder traversal part */
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        /* Cut the unnecessary part */
        return s.substring(1, s.length() - 1);
    }


///////////////////////////////////////////////////////
// 18. Minimum absolute difference between any nodes //
///////////////////////////////////////////////////////



    /////////////////////////////
    // 1) getMinimumDifference //
    /////////////////////////////

    /*
        The most common idea is to first inOrder traverse the tree and compare
        the delta between each of the adjacent values. It's guaranteed to have
        the correct answer because it is a BST thus inOrder traversal values are
        sorted.
     */

    /* In-Order traverse, time O(N), space complexity O(1). */
    public static int min1 = Integer.MAX_VALUE;
    public static Integer prev = null;
    public static int getMinimumDifference(TreeNode root) {
    /* Base */
        if (root == null) {
            return min1;
        }

    /* Go far left */
        getMinimumDifference(root.left);

    /* Not leaf */
        if (prev != null) {
            min1 = Math.min(min1, root.val - prev);
        }
    /* Record the lastNode*/
        prev = root.val;

    /* After dealing with left, go right */
        getMinimumDifference(root.right);

        return min1;
    }

    //////////////////////////////////////
    // 2) getMinimumDifferenceArrayList //
    //////////////////////////////////////

    /*
        1. Get the list of the nodes value and sort it.
        2. Get the abs by pairs and update the min.
        3. Run time is n • log(n) since we used a sorting method.
     */
    public static int getMinimumDifferenceArrayList(TreeNode root) {
        ArrayList<Integer> nodeList = getTheList(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nodeList.size(); i++) {
            int temp = Math.abs(nodeList.get(i - 1) - nodeList.get(i));
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }
    /* There arr at least two nodes so skip the checking */
    private static ArrayList<Integer> getTheList(TreeNode root) {
        ArrayList<Integer> nodeList = new ArrayList<>();
    /* Preorder traversal */
        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            nodeList.add(node.val);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
        Collections.sort(nodeList);
        return nodeList;
    }


    ////////////////////////////////////
    // 3) getMinimumDifferenceTreeSet //
    ////////////////////////////////////

    /*
        The idea is to put values in a TreeSet and then every time we can use O(lgN)
        time to lookup for the nearest values.
     */

    /* Preorder traverse, time O(NlgN), space O(N).*/
    private static TreeSet<Integer> set = new TreeSet<>();
    private static int min3 = Integer.MAX_VALUE;
    public static int getMinimumDifferenceTreeSet(TreeNode root) {
        if (root == null) {
            return min3;
        }
    /*
        The floor(E e) method is used to return the greatest element in this
        set less than or equal to the given e, or null if there is no such
        element.
     */

    /*
        The ceiling(E e) method is used to return the least element in this
        set greater than or equal to the given element, or null if there is
        no such element.
     */
        if (!set.isEmpty()) {
        /* The value is the closest among all the number that is <= root */
            if (set.floor(root.val) != null) {
                min3 = Math.min(min3, root.val - set.floor(root.val));
            }
        /* The value is the closest among all the number that is >= root */
            if (set.ceiling(root.val) != null) {
                min3 = Math.min(min3, set.ceiling(root.val) - root.val);
            }
        }

        set.add(root.val);

        getMinimumDifferenceTreeSet(root.left);
        getMinimumDifferenceTreeSet(root.right);

        return min3;
    }

////////////////////////////
// 19. The tilt of a tree //
////////////////////////////

    /////////////////
    // 1) findTilt //
    /////////////////

    private static int tiltSum = 0;
    public static int findTilt(TreeNode root) {
        findTilthelper(root);
        return tiltSum;
    }
    //    1
    //  /   \
    // 2     3
    //  \     \
    //   4     5
    private static int findTilthelper(TreeNode root) {
        if (root == null) return 0;

        int left = findTilthelper(root.left);
        int right = findTilthelper(root.right);

        /* Update the tilt for that certain root */
        tiltSum += Math.abs(left - right);

        return left + right + root.val;
    }

/////////////////////////////////////
// 20. Convert BST to Greater Tree //
/////////////////////////////////////

    ////////////////////
    // 1). convertBST //
    ////////////////////

    /* Funky order traversal */
    private static int sum20_1 = 0;
    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.right;
            }

            cur = s.peek();
            s.pop();

            /* Solve the problem */

            if (sum20_1 == 0) {
                sum20_1 = cur.val;
            } else {
                cur.val += sum20_1;
                sum20_1 = cur.val;
            }
            cur = cur.left;
        }

        return root;
    }

    ///////////////////////
    // 2). convertBSTRec //
    ///////////////////////

    /* Recursive Helper */
    private static int sum20_2 = 0;
    public static TreeNode convertBSTRec(TreeNode root) {
        convertBSTHelper(root);
        return root;
    }
    private static void convertBSTHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        /* Right */
        if (root.right != null) {
            convertBSTHelper(root.right);
        }
        /* Root */
        root.val = (sum20_2 += root.val);

        /* Left */
        if (root.left != null) {
            convertBSTHelper(root.left);
        }

    }

////////////////////////////////
// 21. Sum of all LEFT leaves //
////////////////////////////////

    ///////////////////////////////
    // 1) sumOfLeftLeavesRecVoid //
    ///////////////////////////////

    /* Using a variable to control if it's leaf */
    private static int leftSum1 = 0;
    private static int level1 = 0;  /* Make sure it's leaf */
    public static int sumOfLeftLeavesRecVoid(TreeNode root) {
        sumOfLeftLeavesRecVoidHelper(root);
        return leftSum1;
    }
    public static void sumOfLeftLeavesRecVoidHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && level1 != 0) {
            leftSum1 += root.val;
            return;
        }

        if (root.left != null) {
            level1++;
            sumOfLeftLeavesRecVoidHelper(root.left);
        }

        level1 = 0;
        if (root.right != null) {
            sumOfLeftLeavesRecVoidHelper(root.right);
        }

    }

    ///////////////////////////
    // 2) sumOfLeftLeavesRec //
    ///////////////////////////

    /*
        For given node we check whether its left child is a leaf. If it is the
        case, we add its value to answer, otherwise recursively call method on
        left child. For right child we call method only if it has at least one
        non-null child.
     */
    public static int sumOfLeftLeavesRec(TreeNode root) {
        if(root == null) return 0;

        int leftSum = 0;

        /* Core part */
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                leftSum += root.left.val;
            } else {
                leftSum += sumOfLeftLeavesRec(root.left);
            }
        }

        leftSum += sumOfLeftLeavesRec(root.right);
        return leftSum;
    }

    ///////////////////////////
    // 3) sumOfLeftLeavesBFS //
    ///////////////////////////

    /* Core part is the same as the second solution */
    public static int sumOfLeftLeavesBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //   3
        //  / \
        // 9  20
        //   /  \
        //  15   7
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        TreeNode cur = root;
        q.offer(cur);
        int sumLeft = 0;

        while (!q.isEmpty()) {
            cur = q.poll();

            /* Solve the problem */
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null) {
                    sumLeft += cur.left.val;
                }
            }

            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }

        return sumLeft;
    }


/////////////////////////////////////
// 22. Convert Sorted Array to BST //
/////////////////////////////////////

    /////////////////////////
    // 1) sortedArrayToBST //
    /////////////////////////

    /* We can use 'binary divide' which I just gave a name to */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = sortedArrayToBSTHelper(nums, 0, nums.length - 1);
        return root;
    }
    private static TreeNode sortedArrayToBSTHelper(int[] nums, int start, int
            end) {
        if (start > end) {
            return null;
        }

        /* start, end are not necessary but would be useful in other problem */
        int left = start;
        int right = end;

        /* Create the node */
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        /* Divide (Remember to use mid - 1 and mid + 1 since no duplicates) */
        node.left = sortedArrayToBSTHelper(nums, start, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, end);

        return node;
    }


////////////////////////////////////
// 23. Tree 1 is subtree of Tree2 //
////////////////////////////////////

    //////////////////
    // 1) isSubtree //
    //////////////////

    /* Use Recursion */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        /* Edge cases */
        if (s == null) {
            return false;
        }
        if (t == null) {
            return true;
        }

        return helper(s, t);
    }
    /* Recursively traverse node s */
    private static boolean helper(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        /* TreeDemo 10*/
        return isSameRec(s, t) || helper(s.left, t) || helper(s.right, t);

    }



///////////////////
//  24. Path Sum //
///////////////////

    //////////////////////////////////
    // 1) hasPathSum (root to leaf) //
    //////////////////////////////////

    /*
        The basic idea is to subtract the value of current node from sum until it reaches a leaf node and the subtraction equals 0, then we know that we got a hit. Otherwise the subtraction at the end could not be 0.
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        /* Edge Case */
        if (root == null) {
            return false;
        }

        /* Only true situation */
        int newSum = sum - root.val;
        if (newSum == 0 && root.left == null && root.right == null) {
            return true;
        }

        /* Go deeper */
        boolean left  = hasPathSum(root.left, newSum);
        boolean right = hasPathSum(root.right, newSum);

        /* See if one of the two sides is true */
        return left || right;

    }

    /////////////////////////////////////////////
    // 2) binaryTreePathSumList (root to leaf) //
    /////////////////////////////////////////////

    /*
     Since we need the total sum from root to leaf, it's could not be more
     obvious that it's DFS
    */
    public static List<List<Integer>> binaryTreePathSumList(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        path.add(root.val);

        /* We need both single path the final result */
        binaryTreePathSumListHelper(root, root.val, sum, path, result);
        return result;
    }
    private static void binaryTreePathSumListHelper (TreeNode root,
                                                     int sum,
                                                     int target,
                                                     List<Integer> path,
                                                     List<List<Integer>> result) {

        /* Base case; Down to the leaf node and solve the problem */
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path)); /* Deep copy */
            }
            return;
        }

        /* Go left */
        if (root.left != null) {
            path.add(root.left.val);
            binaryTreePathSumListHelper(root.left, sum + root.left.val, target, path, result);
            path.remove(path.size() - 1); /* Backtracking */
        }

        /* Go right (identical to the left side )*/
        if (root.right != null) {
            path.add(root.right.val);
            binaryTreePathSumListHelper(root.right, sum + root.right.val, target, path, result);
            path.remove(path.size() - 1); /* Backtracking */
        }

    }




}

