/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 */

/*
    Tree 2: Binary Search Tree
              100
            /    \
           40     180
         /  \     /
        30   60  110

     where r100 is the root

    nums = [30, 40, 60, 100, 110, 180] 

 */
        
public class Solution {

    /* We can use 'binary divide' which I just gave a name to */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }            
        TreeNode root = sortedArrayToBSTHelper(nums, 0, nums.length - 1);
        return root;
    }
    
    private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
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
}