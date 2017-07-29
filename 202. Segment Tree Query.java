/*
    For an integer array (index from 0 to n-1, where n is the size of this array),
    in the corresponding SegmentTree, each node stores an extra attribute max to denote the maximum number in the interval of the array (index from start to end).

    Design a query method with three parameters root, start and end, find the maximum number in the interval [start, end] by the given root of segment tree.

     Notice

    It is much easier to understand this problem if you finished Segment Tree Build first.

    Example
    For array [1, 4, 2, 3], the corresponding Segment Tree is:

                      [0, 3, max=4]
                     /             \
              [0,1,max=4]        [2,3,max=3]
              /         \        /         \
       [0,0,max=1] [1,1,max=4] [2,2,max=2], [3,3,max=3]
    query(root, 1, 1), return 4

    query(root, 1, 2), return 4

    query(root, 2, 3), return 3

    query(root, 0, 2), return 4
 */

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
        For an array, if we would like to query the max of its subArray, say
        int[] arr = [1,4,2,3], get max of subArray[0, 2], we can use for loop
        and update the max of each for loop.

        However, the segment tree is better designed for query.
        There are 4 conditions:
            1. The interval includes the query interval. Go deeper recursively.
            2. No inter-section between interval and query interval. Stop.
            3. The two intervals are partially intertwined. Divide the query
            interval into two halves, one is included, the other lies outside
            the interval.
            4. The intervals equals the query interval. Return the max / min

        The query time is O(log n); Draw the segment afterwards.
     */
    public int query(SegmentTreeNode root, int start, int end) {

        /* Equal intervals exactly */
        if (start == root.start && end == root.end) {
            return root.max;
        }

        int mid = (root.start + root.end) / 2;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        /* Left */
        if (start <= mid) {
            if (mid < end) { /* Divide */
                leftMax = query(root.left, start, mid);
            } else { /* Includes */
                leftMax = query(root.left, start, end);
            }
            // leftMax = Math.max(root.left, start, Math.min(mid, end));
        }

        /* Right */
        if (mid < end) {
            if (start <= mid) {
                rightMax = query(root.right, mid + 1, end);
            } else {
                rightMax = query(root.right, start, end);
            }
            // rightMax = Math.max(root.right, Math.max(start, mid + 1), end);

        }

        /* Rest is that there are no intervals; We just ignore that. */
        return Math.max(leftMax, rightMax);
    }
}