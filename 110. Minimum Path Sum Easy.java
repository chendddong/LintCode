/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 */

/*
    Note: You can only move either down or right at any point in time.
 */

///////////////////////
// Axis DP template  //         Easy to understand
///////////////////////

public class Solution {
    /*
        Time : O(m * n)
        Space : O(m * n)
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) 
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        /* State: the minSum of of the position x, y from the start point */
        int[][] dp = new int[m][n];
        /* Initialization */
        dp[0][0] = grid[0][0];        
        /* Function */
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        /* Answer */
        return dp[m - 1][n - 1];
    }
}


/////////////////
// Brute Force //               MLE(LintCode) TLE(LeetCode)
/////////////////

public class Solution {

    /*
        The Brute Force approach involves recursion. For each element, we consider two paths, rightwards and downwards and find the minimum sum out of those two. It specifies whether we need to take a right step or downward step to minimize the sum.
     */
    
    public int calculate(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
    }
    public int minPathSum(int[][] grid) {
        /* 
            Travel all the way from the top left to the bottom right 
            return the sum of that position
         */
        return calculate(grid, 0, 0);
    }
}


///////////
// DP 2D //
///////////

public class Solution {
    /*
        We use an extra matrix of the same size as the original matrix. In this matrix, dp(i,j) represents the minimum sum of the path from the index (i,j) to the bottom rightmost element. We start by initializing the bottom rightmost element of as the last element of the given matrix. Then for each element starting from the bottom right, we traverse backwards and fill in the matrix with the required minimum sums. Now, we need to note that at every element, we can move either rightwards or downwards.

        Function:
        dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))

        Time : O(m * n)
        Space : O(m * n)        
     */
    
        // x x x x
        // x x x x 
        // x x x x     ^
        // x x x x     |
        //         <-    
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        /* Travel from the bottom right corner to the top left corner */
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                /* Last row except the last point */
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                /* Far right col except the last point */
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                /* Points in except the last row and last col */
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                /* Bottom right corner*/
                else
                    dp[i][j] = grid[i][j];
            }
        }
        /* Answer */
        return dp[0][0];
    }
}

///////////
// DP 1D //
///////////

public class Solution {
    /*
       In the previous case, instead of using a 2D matrix for dp, we can do the same work using a dp array of the row size, since for making the current entry all we need is the dp entry for the bottom and the right element. Thus, we start by initializing only the last element of the array as the last element of the given matrix. The last entry is the bottom rightmost element of the given matrix. Then, we start moving towards the left and update the entry dp(j) as:

        Function:
        dp(j) = grid(i,j) + min(dp(j),dp(j+1)) 
        [After the comparison between dp(j) and dp(j + 1) we just update dp(j)]

        Time : O(m * n)
        Space : O(n)         
     */    
                   
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                /* Last row except the last point */
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[j] = grid[i][j] +  dp[j + 1];
                /* Far right col except the last point */
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + dp[j];
                /* Points in except the last row and last col */
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                /* Bottom right corner */
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }
}

///////////////////////
// DP No extra space //
///////////////////////

public class Solution {

    /*
       This approach is same as Approach 2, with a slight difference. Instead of using another dp matrix. We can store the minimum sums in the original matrix itself, since we need not retain the original matrix here. Thus, the governing equation now becomes:

        Function:
        grid(i,j)=grid(i,j)+min(grid(i+1,j),grid(i,j+1)) (Cool thought)
        
        Time : O(m * n)
        Space : O(1)         
     */      
    
    public int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    grid[i][j] = grid[i][j] +  grid[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j],grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }
}



