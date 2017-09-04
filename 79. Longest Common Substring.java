/**
 * Given two strings, find the longest common substring.
 * Return the length of it.
 */

/*
     Notice

    The characters in substring should occur continuously in original string. This is different with subsequence.

    Example
    Given A = "ABCD", B = "CBCE", return 2.

    Challenge 
    O(n x m) time and memory.
 */

public class Solution {

    public int longestCommonSubstring(String A, String B) {
        int m = A.length();
        int n = B.length();

        /* 
            State dp[i][j] means before index i of A and j of B, the length of 
            the longest common substring.
        */
        int[][] dp = new int[m + 1][n + 1]; /* +1!!!  Including the Init */

        /* Function */
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                /* Since the chars must appear continuous, the dependency only
                exists between the dp[i][j] = dp[i - 1][j - 1] */
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0; /* Set to the default value */
                }
            }
        }

        /* Answer */
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;

    }
}
