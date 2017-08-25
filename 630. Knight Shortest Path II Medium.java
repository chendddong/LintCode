/*
    Given a knight in a chessboard n * m (a binary matrix with 0 as empty and 1
    as barrier). the knight initialize position is (0, 0) and he wants to reach position (n - 1, m - 1), Knight can only be from left to right. Find the shortest path to the destination position, return the length of the route. Return -1 if knight can not reached.
 */

/*
    Clarification
    If the knight is at (x, y), he can get to the following positions in one step:

    (x + 1, y + 2)
    (x - 1, y + 2)
    (x + 2, y + 1)
    (x - 2, y + 1)

    Example
    [[0,0,0,0],
     [0,0,0,0],
     [0,0,0,0]]

    Return 3

    Example
    [[0,0,0,0],
     [0,0,0,0],
     [0,1,0,0]]

    Return -1
 */
public class Solution {

    public int shortestPath2(boolean[][] grid) {
        int m = grid.length;
        if (m == 0) return -1;
        int n = grid[0].length;
        if (n == 0) return -1;

        /* State : dp[x][y] is the shortest path from start point */
        int[][] dp = new int[m][n];

        /* Init */
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++)
                dp[i][j] = Integer.MAX_VALUE;
        dp[0][0] = 0;

        /* Function */
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (!grid[i][j]) {
                    /* From top left |-|-| */
                    if (i >= 1 && j >= 2 && dp[i - 1][j - 2] !=
                       Integer.MAX_VALUE) 
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 2] + 1);
                    /* From bottom left |-|-| */
                    if (i + 1 < m && j >= 2 && dp[i + 1][j - 2] !=
                       Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 2] + 1);
                    /* From top left 日 */
                    if (i >= 2 && j >= 1 && dp[i - 2][j - 1] !=
                       Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j], dp[i - 2][j - 1] + 1);
                    /* From bottom left 日 */
                    if (i + 2 < m && j >= 1 && dp[i + 2][j - 1] !=
                       Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j], dp[i + 2][j - 1] + 1);
                }
            }
        }

        // [[0,0,0,0],              
        //  [0,0,0,0],                  
        //  [0,0,0,0]]
        //  
        // [[0, +, 2, +]
        //  [+, +, +, +]
        //  [+, 1, +, 3]]        
        
        /* Answer */
        if (dp[m - 1][n - 1] == Integer.MAX_VALUE) return -1;

        return dp[m - 1][n - 1];
    }
}