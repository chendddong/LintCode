/*
    Give you an integer array (index from 0 to n-1, where n is the size of this
    array, value from 0 to 10000) and an query list. For each query, give you an integer, return the number of element in the array that are smaller than the given integer.
 */

/*
    We suggest you finish problem Segment Tree Build and Segment Tree Query II first.

    Example
               0 1 2 3 4 
              [1,2,5,7,8]
    For array [1,2,7,8,5], and queries [1,8,5], return [0,4,2]


    VERY VERY IMPORTANT CONCEPT THOUGH. CLEVER MOVE.
 */

public class Solution {

    class SegmentTreeNode {
        public int start, end;
        public int count;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
              this.start = start;
              this.end = end;
              this.count = count;
              this.left = this.right = null;
        }
    }
    SegmentTreeNode root;
    public SegmentTreeNode build(int start, int end) {
        if(start > end) {  
            return null;
        }
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        
        if(start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid+1, end);
        } else {
            root.count =  0;
        }
        return root;
    }
    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        if(start == root.start && root.end == end) { 
            return root.count;
        }
        
        
        int mid = (root.start + root.end)/2;
        int leftcount = 0, rightcount = 0;
        if(start <= mid) {
            if( mid < end) { 
                leftcount =  querySegmentTree(root.left, start, mid);
            } else { 
                leftcount = querySegmentTree(root.left, start, end);
            }
        }
        
        if(mid < end) { 
            if(start <= mid) {
                rightcount = querySegmentTree(root.right, mid+1, end);
            } else { 
                rightcount = querySegmentTree(root.right, start, end);
            } 
        }  
        return leftcount + rightcount;
    }
    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        if(root.start == index && root.end == index) { 
            root.count += value;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <=mid) {
            modifySegmentTree(root.left, index, value);
        }
        
        if(mid < index && index <= root.end) {
            modifySegmentTree(root.right, index, value);
        }
        root.count = root.left.count + root.right.count;
    }
    public ArrayList<Integer> countOfSmallerNumber(List<Integer> A, List<Integer> queries) {
        /* Create a segment tree with 10000 leaves and no count */
        root = build(0, 10000);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int res;
        /* Only modify the query numbers */
        for(int i : A) {
            modifySegmentTree(root, i, 1);
        }
        for(int query : queries) {
            res = 0;
            if(query > 0) /* Prevent negative numbers */
                /* 
                    Smart query: return the count before than query (the total
                    number that is less than the query number); Be aware that
                    it is query - 1; 
                 */
                res = querySegmentTree(root, 0, query - 1);
            ans.add(res);
        }
        return ans;
    }
}
