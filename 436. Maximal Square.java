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
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }        

        /* Function */
        for (int i = 1; i < m; i++) {
            /* Prevent the corner case where there is only one col */            
            ans = Math.max(dp[i][0], ans); 
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1)
                    dp[i][j] = Math.min(dp[i-1][j-1], 
                               Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                else 
                    dp[i][j] = 0;
                
                ans = Math.max(dp[i][j], ans); /* Update */    
            }
        }

        /* Answer */
        return ans * ans;
    }
}
