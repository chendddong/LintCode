/*
    Give you an integer matrix (with row size n, column size m)，find the
    longest increasing continuous subsequence in this matrix. (The definition
    of the longest increasing continuous subsequence here can start at any row
    or column and go up/down/right/left any direction).

    Example
    Given a matrix:

    [
      [1 ,2 ,3 ,4 ,5],
      [16,17,24,23,6],
      [15,18,25,22,7],
      [14,19,20,21,8],
      [13,12,11,10,9]
    ]
    return 25

    Challenge 
    O(n * m) time and memory.
 */

///////////////////
// Memory Search //
///////////////////

/*
    When to use Memory Search instead of the direct for loop dp:
    1. It is hard to find the function and usually it's not sequential
    2. The initialization is hard to achieve.
 */
public class Solution {
    /* Just for recursive reuse */
    int[][] dp;
    int[][] flag;
    int m, n;

    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if (A.length == 0) return 0;
        m = A.length;
        n = A[0].length;

        int ans = 0;
        /* State dp[i][j] means what the LCS that we can get from this point */
        dp = new int[m][n];
        flag = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = search(i, j, A);
                ans = Math.max(ans, dp[i][j]); /* Update the answer */
            }
        }
        return ans;
    }

    /* For directions */
    int[] dx = {1, -1, 0, 0}; 
    int[] dy = {0, 0, 1, -1};

    private int search(int x, int y, int[][] A) {
        if (flag[x][y] != 0)
            return dp[x][y];

        int ans = 1; /* The least number that we can get */
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (0 <= nx && nx < m && 0 <= ny && ny < n) /* In bound*/
                if (A[x][y] > A[nx][ny]) /* Going down */
                    ans = Math.max(ans, search(nx, ny, A) + 1); /* Update */
        }

        flag[x][y] = 1; /* Visited */
        dp[x][y] = ans; /* Return value */
        return ans;
    }
}