/*
    Given an integer array (index from 0 to n-1, where n is the size of this
    array), and an query list. Each query has two integers [start, end]. For each query, calculate the minimum number between index start and end in the given array, return the result list.

     Notice

    We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.

    Example
    For array [1,2,7,8,5], and queries [(1,2),(0,4),(2,4)], return [2,1,5]
 */

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

/* For min */
class SegmentTreeNode {
    public int start;
    public int end;
    public int min;
    SegmentTreeNode left;
    SegmentTreeNode right;
    public SegmentTreeNode(int start, int end, int min) {
        this.start = start;
        this.end = end;
        this.min = min;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        SegmentTreeNode root = build(0, A.length - 1, A);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Interval in : queries) {
            result.add(query(root, in.start, in.end));
        }
        return result;
    }

    private SegmentTreeNode build(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end,
            Integer.MAX_VALUE);

        if (start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid + 1, end, A);
            root.min = Math.min(root.left.min, root.right.min);
        } else {
            root.min = A[start];
        }

        return root;
    }

    private int query(SegmentTreeNode root, int start, int end) {
        if (start == root.start && root.end == end) {
            return root.min;
        }

        int mid = (root.start + root.end) / 2;
        int leftmin = Integer.MAX_VALUE;
        int rightmin = Integer.MAX_VALUE;

        if (start <= mid) {
            leftmin = query(root.left, start, Math.min(mid, end));
        }

        if (mid < end) {
            rightmin = query(root.right, Math.max(start, mid + 1), end);
        }

        return Math.min(leftmin, rightmin);
    }
}