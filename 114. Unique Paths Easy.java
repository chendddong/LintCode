/**
 * A robot is located at the top-left corner of a m x n grid.
 */

/*
    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.

    How many possible unique paths are there?
    
    m and n will be at most 100.

    Example
    Given m = 3 and n = 3, return 6.
    Given m = 4 and n = 5, return 35.    

    x x x
    x x x
    x x x

    1 1 1
    1 2 3 
    1 3 6
 */

//////////////////////////
// 4 Steps Space(m * n) //
//////////////////////////
    
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) return 0;
        if (m == 0) return n;
        if (n == 0) return m;

        /* State: dp[x][y] is the unique paths for that certain position */
        int[][] dp = new int[m][n];
        /* Init */
        int i = 0, j = 0;
        for (i = 0; i < m; i++) /* First col */
            dp[i][0] = 1;
        for (i = 0; i < n; i++) /* First row */
            dp[0][i] = 1;
        /* Function */
        for (i = 1; i < m; i++) 
            for (j = 1; j < n; j++) 
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        /* Answer */
        return dp[m - 1][n - 1];

    }
}

////////////////////
// One Traversal  //
////////////////////

public class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        int i, j;
        for (i = 0; i < m; ++i) 
            for (j = 0; j < n; ++j) {
                if (i == 0 || j == 0) 
                    dp[i][j] = 1; /* Init */
                else 
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        return dp[m - 1][n - 1];
    }
}

///////////////////////////////////
// Math - combinatorial problem  //
///////////////////////////////////

public class Solution {

    /*
        This is a combinatorial problem and can be solved without DP. For mxn grid, robot has to move exactly m-1 steps down and n-1 steps right and these can be done in any order.

        For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any order. That is nothing but a permutation problem. Denote down as 'D' and right as 'R', following is one of the path :-

        D R R R D R R R

        We have to tell the total number of permutations of the above given word. So, decrease both m & n by 1 and apply following formula:-

        Total permutations = (m+n)! / (m! * n!)
     */

    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;

        m--;
        n--;

        if(m < n) { /* Swap, so that m is the bigger number */
            m = m + n;
            n = m - n;
            m = m - n;
        }

        long res = 1;
        int j = 1;

        for (int i = m + 1; i <= m + n; i++, j++) { // multiply & divide
            res *= i;
            res /= j;
        }
        // res = (m + 1) * (m + 2) *...* (m + n) / 1 * 2 * ... n;
            
        return (int) res; /* Convert */
    }
}