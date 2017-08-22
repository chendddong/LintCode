/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 */

/*
     Notice

    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

    Have you met this question in a real interview? Yes
    Example
    Given the following triangle:

    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */

/////////////////////
// Memorize Search //
/////////////////////

public class Solution {
    private int n;
    private int[][] minSum;
    private int[][] triangle;

    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) return -1;
        if (triangle[0] == null || triangle[0].length == 0) return -1;

        this.n = triangle.length;
        this.triangle = triangle;
        this.minSum = new int[n][n];

        /* Set the initialized value to MAX */
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                minSum[i][j] = Integer.MAX_VALUE;

        return search(0, 0);
    }

    private int search(int x, int y) {
        if (x >= n) return 0;

        if (minSum[x][y] != Integer.MAX_VALUE)
            return minSum[x][y];

        minSum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1)) + triangle[x][y];

        return minSum[x][y];
    }
}

/////////////////
// Top-Down DP //
/////////////////

public class Solution {

    /* Remember the 4 things we need to do in the DP */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) return -1;
        if (triangle[0] == null || triangle[0].length == 0) return -1;

        /* State: dp[x][y] = minimum path value from 0,0 to x,y */
        int n = triangle.length;
        int[][] dp = new int[n][n];

        /* Initialize: All the first element and last element of each row */
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
            // Also set those points not show in the triangle with 0
        }

        /* Traversal Process -- the function */
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle
                [i][j];
            }
        }

        /* Answer */
        int best = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, dp[n - 1][i]); // Last Row
        }      

        return best;
    }
}

//////////////////
// Bottom-up DP //
//////////////////

public class Solution {
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle[0] == 0) return -1;
        if (triangle[0] == null || triangle[0] == 0) return -1;

        /* State: dp[x][y] is the minimumTotal from x, y to bottom */
        int n = triangle.length;
        int[x][y] dp = new int[n][n];

        /* Initialize: the last element of the row */
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }

        /* Bottom up: the function */
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) 
                    + triangle[i][j];
            }
        }

        /* Answer */
        return dp[0][0];

    }
}



