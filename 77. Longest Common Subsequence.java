/**
 * Given two strings, find the longest common subsequence (LCS).
 */

/*
    Your code should return the length of LCS.

    Clarification
    What's the definition of Longest Common Subsequence?

    https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
    http://baike.baidu.com/view/2020307.htm
    Example
    For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

    For "ABCD" and "EACB", the LCS is "AC", return 2.
 */

public class Solution {

    public int longestCommonSubsequence(Sting A, String B) {
        int m = A.length();
        int n = B.length();
        /* 
            dp[i][j] means the LCS of index 0 to ith in string A & index 0 to
            jth in string B.
         */
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                /* Should be i - 1 and j - 1*/                
                if (A.charAt(i - 1) == B.charAt(j - 1)) 
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else 
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        
        return dp[m][n];
    }
}