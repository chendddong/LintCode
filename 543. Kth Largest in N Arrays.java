/**
 * Find K-th largest element in N arrays.
 */

/*
    You can swap elements in the array

    Example
    In n=2 arrays [
                    [9,3,2,4,7],
                    [1,2,3,4,8]
                   ], the 3rd largest element is 7.

    In n=2 arrays [[9,3,2,4,8],[1,2,3,4,2]], the 1st largest element is 9, 2nd largest element is 8, 3rd largest element is 7 and etc.


    VERY VERY IMPORTANT
 */

///////////////////////////////////
// Use Heap + Construct DataType //
///////////////////////////////////
    
class Node {
    public int val;
    public int row;
    public int col;
    public Node(int v, int r, int c) {
        val = v;
        row = r;
        col = c;
    }
}

class MultiArrayComparator implements Comparator<Node> {
    public int compare(Node n1, Node n2) {
        if (n1.val > n2.val) {
            return -1;
        } else if (n1.val < n2.val) {
            return 1;
        } else {
            return 0;
        }
    }
}
public class Solution {

    public int KthInArrays(int[][] arrays, int k) {
        MultiArrayComparator comparator = new MultiArrayComparator();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(k, comparator);

        int n = arrays.length;
        int i;

        /* Add just the RIGHT MOST(largest) number of each row to the Heap */
        for (i = 0; i < n; ++i) {
            Arrays.sort(arrays[i]);

            if (arrays[i].length > 0) {
                int row = i;
                int col = arrays[i].length - 1;
                int val = arrays[row][col];
                pq.add(new Node(val, row, col));
            }
        }     

        for (i = 0; i < k; ++i) {
            Node temp = pq.poll();
            int row = temp.row;
            int col = temp.col;
            int val = temp.val;

            /* Exit and return the answer */
            if (i == k - 1) {
                return val;
            }

            /* Move the col to left in the same array */
            if (col > 0) {
                col--;
                val = arrays[row][col];
                pq.add(new Node(val, row, col));
            }
        }
        
        return - 1;
    }
}

// Example
// pq = | 9, 8 |
//        x  
// In n=2 arrays [
//                 [9,3,2,4,7],     --> [2,4,4,7,9]
//                                               <-col (moving left)
//                 [1,2,3,4,8]      --> [1,2,3,4,8]
//                                               <-col (moving left)
//                ], the 3rd largest element is 7.   