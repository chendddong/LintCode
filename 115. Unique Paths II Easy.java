/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 */

/*
    m and n will be at most 100.

    Example
    For example,
    There is one obstacle in the middle of a 3 x 3 grid as illustrated below.

    [
     [0,0,0],
     [0,1,0],
     [0,0,0]
    ]

    The total number of unique paths is 2.
 */

////////////////////
// My AC solution //
////////////////////

public class Solution {
    /* 
        Some special condition is tricky though.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        
        if (obstacleGrid == null || 
            obstacleGrid.length == 0 || 
            obstacleGrid[0].length == 0) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        /* State : dp[x][y] unique paths in point x, y */
        int[][] dp = new int[m][n];

        /* Init */
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (obstacleGrid[i][j] == 1) 
                    dp[i][j] = Integer.MIN_VALUE;
                    
        for (int i = 0; i < m; i++) {
            if (dp[i][0] == Integer.MIN_VALUE) {
                makeAllColMin(dp, i);
                break;
            } 
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            if (dp[0][j] == Integer.MIN_VALUE) {
                makeAllRowMin(dp, j);
                break;
            }
            dp[0][j] = 1;
        }        
        /* Function */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == Integer.MIN_VALUE) continue;
                dp[i][j] = Math.max(dp[i - 1][j], 0) + Math.max(dp[i][j - 1], 0);
            }
        }
        /* Answer */
        return dp[m - 1][n - 1] == Integer.MIN_VALUE ? 0 : dp[m - 1][n - 1];
        /* Obstacles in the 0th row or 0th col */
    }
    
    /* Make rest of the row / col 's state a block "-" */
    private void makeAllColMin(int[][] dp, int i) {
        for (int index = i; index < dp.length; index++) 
            dp[index][0] = Integer.MIN_VALUE; 
    }
    private void makeAllRowMin(int[][] dp, int j) {
        for (int index = j; index < dp[0].length; index++) 
            dp[0][index] = Integer.MIN_VALUE;        
    }
}

///////////////////////
// Template Cleaner  //
///////////////////////

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        /* State */
        int[][] dp = new int[n][m];
        
        /* Init: Set the obstacles to 0 and open paths to 1 */
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1; 
            } else {
                break;
            }
        }
        
        /* Traverse by using the function */
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0; /* The obstacles */
                }
            }
        }
        /* Answer */
        return dp[n - 1][m - 1];
    }
}

///////////
// DP 1D //
///////////

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    // Walkthrough 
    // obstacleGrid                     DP
    // [                        [
    //  [0,0,0],                    [1,1,1],
    //  [0,1,0],    ==>             [1,0,1],
    //  [0,0,0]                     [1,1,2]
    // ]                         ]

    int width = obstacleGrid[0].length;
    int[] dp = new int[width];
    dp[0] = 1;
    for (int[] row : obstacleGrid) {
        for (int j = 0; j < width; j++) {
            if (row[j] == 1) /* Obstacle */
                dp[j] = 0;
            else if (j > 0)
                dp[j] += dp[j - 1];
        }
    }
    return dp[width - 1];
}

/////////////
// DP O(1) //
/////////////

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /* Edge */
        if(obstacleGrid.length == 0) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        /* 
            The smart move is to * 1 with the value. If it is 0 then the result
            is 0; While it's larger than 0 if the values are all not 0.
         */
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else if(i==0 && j == 0) obstacleGrid[i][j] = 1;
                else if(i==0) obstacleGrid[i][j] = obstacleGrid[i][j - 1] * 1;
                else if(j==0)obstacleGrid[i][j] = obstacleGrid[i - 1][j] * 1;
                else obstacleGrid[i][j] = obstacleGrid[i - 1][j] 
                                        + obstacleGrid[i][j - 1];
            }
        }
        
        return obstacleGrid[m - 1][n - 1];
        
    }
}


