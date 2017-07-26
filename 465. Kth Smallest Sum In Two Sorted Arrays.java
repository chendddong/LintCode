/*
    Given two integer arrays sorted in ascending order and an integer k. Define
    sum = a + b, where a is an element from the first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.
    -- Similar to LintCode 401
 */

/*
    Example
    Given A: [1, 7, 11] and 
          B: [2, 4, 6].
    
      1   7   11
   2  3   9   13
   4  5   11  15
   6  7   13  17
    For k = 3, return 7.

    For k = 4, return 9.

    For k = 8, return 15.
 */

///////////////////////////
// MinHeap like a matrix //
///////////////////////////

class Pair {
    public int x, y, val;
    public Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.val - b.val; /* Ascending */
    }
}

public class Solution {

    public int kthSmallestSum(int[] A, int[] B, int k) {

        /* Setting up */
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        int n = A.length;
        int m = B.length;
        boolean[][] hash = new boolean[n][m];

        /* 
            This comparator:
            1. The size of the PQ;
            2. The comparator that we are gonna use.
        */
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, new
            PairComparator());

        /* Just alter a little bit form the 401 */
        minHeap.add(new Pair(0, 0, A[0] + B[0]));

        /* Work through */
         // Given A: [1, 7, 11] and 
         //       B: [2, 4, 6].

        /* Add k num to the min heap and peek the right position */
        for (int i = 0; i < k - 1; i++) {
            Pair cur = minHeap.poll();
            for (int j = 0; j < 2; j++) {
                int next_x = cur.x + dx[j];
                int next_y = cur.y + dy[j];
                Pair nextPair = new Pair(next_x, next_y, 0);
                if (next_x < n && next_y < m && !hash[next_x][next_y]) {
                    hash[next_x][next_y] = true;

                    nextPair.val = A[next_x] + B[next_y];
                    minHeap.add(nextPair);
                }
            }
        }

        return minHeap.peek().val;

    }    
}


/* 
    Declare array in Java:
    int[] myIntArray = new int[3];
    int[] myIntArray = {1,2,3};
    int[] myIntArray = new int[]{1,2,3};    
 */

