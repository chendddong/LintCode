/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * which diagonal is all 1 and others is 0.
 */

/*
     Notice

    Only consider the main diagonal situation.

    Example
    For example, given the following matrix:

    1 0 1 0 0
    1 0 0 1 0
    1 1 0 0 1
    1 0 0 1 0
    Return 9
 */
 
 /////////////////
 // DP template //
 /////////////////
    
 public class Solution {

    public int maxSquare2(int[][] matrix) {
        /* Edge cases */
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;

        /* 
            State :
                one[i][j] means the max length of the 1 that we can get in that
                position;

                zeroR[i][j] means the max length of the 0 in a row that we can
                get in that certain position;

                zeroC[i][j] means the max length of the 0 in a col that we can
                get in that certain position;         
         */
        int[][] one = new int[m][n]; 
        int[][] zeroR = new int[m][n]; 
        int[][] zeroC = new int[m][n];

        int length = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    /* Init */
                    one[i][j] = 0;
                    zeroR[i][j] = zeroC[i][j] = 1;

                    if (i > 0)
                        zeroR[i][j] = zeroR[i - 1][j] + 1;
                    if (j > 0)
                        zeroC[i][j] = zeroC[i][j - 1] + 1;
                } else { /* "1" */
                    zeroR[i][j] = zeroC[i][j] = 0; /* Init */

                    if (i > 0 && j > 0) /* Base on the smallest side */
                        one[i][j] = Math.min(one[i - 1][j - 1], 
                                    Math.min(zeroR[i-1][j],zeroC[i][j-1])) + 1;
                    else
                        one[i][j] = 1; /* Init : first col and first row */
                }
                length = Math.max(length, one[i][j]); /* Update answer */
            }
        }
        return length * length;
    }
}