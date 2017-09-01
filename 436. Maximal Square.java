/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing all 1's and return its area.
 */

/*
    Example
    For example, given the following matrix:

    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0
    Return 4.
 */

/////////////////
// DP template //
/////////////////

public class Solution {
    /*
        Type 1 With axis.
    */
    public int maxSquare(int[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n;
        
        if (m > 0) 
            n = matrix[0].length;
        else
            return ans;
        /* 
            State : the length of the square using bottom right corner to
            extend the square / Init
         */
        // int dp[][] = new int[m][n];            
        int dp[][] = new int[2][n];
        for (int i = 0; i < m; i++) {
            dp[i%2][0] = matrix[i][0];
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }        

        /* Function */
        for (int i = 1; i < m; i++) {
            /* Prevent the corner case where there is only one col */            
            ans = Math.max(dp[i][0], ans); 
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1)
                    dp[i%2][j] = Math.min(dp[(i-1)%2][j-1], 
                               Math.min(dp[(i-1)%2][j], dp[i%2][j-1])) + 1;
                else 
                    dp[i%2][j] = 0;
                
                ans = Math.max(dp[i%2][j], ans); /* Update */    
            }
        }

        /* Answer */
        return ans * ans;
    }
}

/////////////
// Axis DP //
/////////////

class Solution {
    public int maxSquare(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        /* The length of the square length we can get from this point */
        int[][] dp = new int[rows][cols];
        int maxsqlen = 0;

        for (int i = 0 ; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == 1 ? 1 : 0; /* Init */
                    maxsqlen = Math.max(maxsqlen, dp[i][j]); /* Update */
                } else if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]); /* Update again */
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}

////////////////////////
// Axis + sequence DP //
////////////////////////

public class Solution {
    public int maxSquare(int[][] a) {
        /* 
            An extra row & col would make the initialization much more easier 

            matrix a:

            1 0 1 0 0
            1 0 1 1 1
            1 1 1 1 1
            1 0 0 1 0   

            dp matrix:
              0 0 0 0 0 0    
              0 1 0 1 0 0
              0 1 0 1 1 1
              0 1 1 1 1 1
              0 1 0 0 1 0                        
        */
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;

        int[][] b = new int[m+1][n+1];

        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == 1) { /* Where we need to take actions */
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j])
                    + 1; 
                    result = Math.max(b[i][j], result); /* update result */
                }
            }
        }

        return result * result;
    }
}

