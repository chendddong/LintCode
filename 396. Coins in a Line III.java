/*
    There are n coins in a line. Two players take turns to take a coin from one
    of the ends of the line until there are no more coins left. The player with the larger amount of money wins.

    Could you please decide the first player will win or lose?
 */

/*
    Example
    Given array A = [3,2,2], return true.

    Given array A = [1,2,4], return true.

    Given array A = [1,20,4], return false.

    Challenge 
    Follow Up Question:

    If n is even. Is there any hacky algorithm that can decide whether first player will win or lose in O(1) memory and O(n) time?
 */

////////////////////////////
// Memory search template //            Interval DP template
////////////////////////////

public class Solution {

    public boolean firstWillWin(int[] values) {
        int n = values.length;

        /* dp[i][j] means from ith to the jth coins the max number the one
        moving first can get */
        int[][] dp = new int[n + 1][n + 1];
        boolean[][] flag = new boolean[n + 1][n + 1];

        int sum = 0;
        for (int now : values) 
            sum += now;

        return sum < 2 * memorySearch(0, values.length - 1, dp, flag, values);
    }

    private int memorySearch(int left, int right, int[][] dp,
        boolean[][]flag,int[] values) {
        /* Check cache */
        if (flag[left][right])
            return dp[left][right];

        /* Set the interval to visited */
        flag[left][right] = true;

        /* Init step */
        if (left > right)
            dp[left][right] = 0;
        else if (left == right)
            dp[left][right] = values[left];
        else if (left + 1 == right)
            dp[left][right] = Math.max(values[left], values[right]);

        else {
            /* 
                Function : Search steps. The most effective way to approach
                this is to draw the search tree.

                    values[]
                    dp(i,j)

                            [3, 2, 6] (0,2)                       First
                             /      \
                        3  /         \   6
                         /            \
                    [2,6] (1,2)    [3,2] (0,1)                    Second
                       /  \          /   \
                   2 /     \ 6   3 /      \ 2
                   /        \    /         \
              [6](2,2) [2](1,1) [2](1,1) [3](0,0)                 First

             */
            int goLeft = Math.min(memorySearch(left+2,right,dp,flag,values),
                                  memorySearch(left+1,right-1,dp,flag,values)) + values[left];
            int goRight = Math.min(memorySearch(left,right-2,dp,flag,values),
                                   memorySearch(left+1,right-1,dp,flag,values))+ values[right];
            dp[left][right] = Math.max(goLeft, goRight);
        }
        return dp[left][right];
    }
}

//////////////
// DP Linpz //
//////////////

public class Solution {
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;

        for (int i = 1; i <= n; i++) /* Get the sum in ith index */
            sum[i] = sum[i - 1] + values[i - 1];

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) 
            dp[i][i] = values[i]; /* Treat these like the leaf nodes */

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = i + len - 1;
                if (j >= n) continue;
                int s = sum[j + 1] - sum[i];
                dp[i][j] = Math.max(s - dp[i + 1][j], s - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] > sum[n] / 2;
    }
}


