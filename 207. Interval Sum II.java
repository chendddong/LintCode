/*
    Given an integer array in the construct method, implement two methods query
    (start, end) and modify(index, value):

    For query(start, end), return the sum from index start to index end in the given array.
    For modify(index, value), modify the number in the given index to value
     Notice

    We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.

    Have you met this question in a real interview? Yes
    Example
    Given array A = [1,2,7,8,5].

    query(0, 2), return 10.
    modify(0, 4), change A[0] from 1 to 4.
    query(0, 1), return 6.
    modify(2, 1), change A[2] from 7 to 1.
    query(2, 4), return 14.
 */

public class Solution {

    class SegmentTreeNode {
        public int start, end;
        public int sum;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }
    }    
    SegmentTreeNode root; /* Root for everybody */
    public SegmentTreeNode build(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);

        if (start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid + 1, end, A);

            root.sum = root.left.sum + root.right.sum;
        } else {
            root.sum = A[start];
        }

        return root;
    }
    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        if (start == root.start && root.end == end) {
            return root.sum;
        }

        int mid = (root.start + root.end) / 2;
        int leftsum = 0, rightsum = 0;

        if (start <= mid) {
            leftsum = querySegmentTree(root.left, start, Math.min(mid, end));
        }
        if (mid < end) {
            rightsum = querySegmentTree(root.right, Math.max(start, mid + 1),
                end);
        }
        return leftsum + rightsum;
    }
    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.sum = value;
            return;
        }

        int mid = (root.start + root.end) / 2;

        if (root.start <= index && index <= mid) {
            modifySegmentTree(root.left, index, value);
        }
        if (mid < index && index <= root.end) {
            modifySegmentTree(root.right, index, value);
        }

        root.sum = root.left.sum + root.right.sum;
    }
    public Solution(int[] A) {
        root = build(0, A.length - 1, A);
    }
    public long query(int start, int end) {
        return querySegmentTree(root, start, end);
    }

    public void modify(int index, int value) {
        modifySegmentTree(root, index, value);
    }
}
