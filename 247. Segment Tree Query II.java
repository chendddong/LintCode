/*
For an array, we can build a SegmentTree for it, each node stores an extra
attribute count to denote the number of elements in the the array which value is between interval start and end. (The array may not fully filled by elements)

Design a query method with three parameters root, start and end, find the number of elements in the in array's interval [start, end] by the given root of value SegmentTree.

 Notice

It is much easier to understand this problem if you finished Segment Tree Buildand Segment Tree Query first.

Example
For array [0, 2, 3], the corresponding value Segment Tree is:

                     [0, 3, count=3]
                     /             \
          [0,1,count=1]             [2,3,count=2]
          /         \               /            \
   [0,0,count=1] [1,1,count=0] [2,2,count=1], [3,3,count=1]
query(1, 1), return 0

query(1, 2), return 1

query(2, 3), return 2

query(0, 2), return 2

 */

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {

    public int query(SegmentTreeNode root, int start, int end) {
        if (start > end || root == null) retrun 0; 
        /* Equal */
        if (start <= root.start && root.end <= end) return root.count; 

        /* Treat the count similar to the sum */
        int mid = (root.start + root.end) / 2;
        int leftsum = 0, rightsum = 0;

        if (start <= mid) {
            leftsum = query(root.left, start, Math.min(mid, end));
        }
        if (mid < end) {
            rightsum = query(root.right, Math.max(mid + 1, start), end);
        }      
        
        return leftsum + rightsum;


    }
}