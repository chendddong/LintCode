/*
    Given an integer array (index from 0 to n-1, where n is the size of this
    array), and an query list. Each query has two integers [start, end]. For 
    each query, calculate the sum number between index start and end in the 
    given array, return the result list.


    We suggest you finish problem Segment Tree Build, Segment Tree Query and 
    Segment Tree Modify first.

    Example
    For array [1,2,7,8,5], and queries [(0,4),(1,2),(2,4)], return [23,9,20]
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

public class Solution {
    /* Node */
    class SegmentTreeNode {
        public int start;
        public int end;
        public Long sum;
        public SegmentTreeNode left;
        public SegmentTreeNode right;
        public SegmentTreeNode(int s, int e, Long su) {
            this.start = s;
            this.end = e;
            this.sum = su;
            this.left = null;
            this.right = null;
        }
    }
    // [1,2,7,8,5], and queries [(0,4),(1,2),(2,4)], return [23,9,20]    
    public SegmentTreeNode build(int start, int end, int[] A) {
        if (start > end) { /* Base */
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0L);

        if (start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid + 1, end, A);

            root.sum = root.left.sum + root.right.sum;
        } else {
            root.sum = Long.valueOf(A[start]); /* Convert int value to Long */
        }
        return root;
    }
    // [1,2,7,8,5], and queries [(0,4),(1,2),(2,4)], return [23,9,20]        
    public Long query(SegmentTreeNode root, int start, int end) {
        if (start == root.start && root.end == end) {
            return root.sum;
        }
        
        int mid = (root.start + root.end) / 2;
        Long leftSum = 0L;
        Long rightSum = 0L;

        /* Left */
        if (start <= mid) {
            if (mid < end) {
                leftSum = query(root.left, start, mid);
            } else {
                leftSum = query(root.left, start, end);
            }
        }

        /* Right */
        if (mid < end) {
            if (start <= mid) {
                rightSum = query(root.right, mid + 1, end);
            } else {
                rightSum = query(root.right, start, end);
            }
        }
        return  leftSum + rightSum;
    }

    // [1,2,7,8,5], and queries [(0,4),(1,2),(2,4)], return [23,9,20]

    public List<Long> intervalSum(List<Integer> A, ArrayList<Interval> queries) {
        /* Convert list to Array: */
        int size = A.size();
        int[] result = new int[size];
        Integer[] temp = A.toArray(new Integer[size]);
        for (int i = 0; i < size; i++) {
            result[i] = temp[i];    
        }

        SegmentTreeNode root = build(0, A.size() - 1, result);
        List<Long> ans = new ArrayList<>();
        for (Interval in : queries) {
            ans.add(query(root, in.start, in.end));
        }
        return ans;
    }
    
}

/* 
    Convert list to Array:

    int size = listResult.size();
    int[] result = new int[size];
    Integer[] temp = listResult.toArray(new Integer[size]);
    for (int n = 0; n < size; ++n) {
        result[n] = temp[n];
    }        

 */

