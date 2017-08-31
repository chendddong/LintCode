/**
 * Given a string S and a string T, count the number of distinct subsequences
 * of T in S.
 */

/*
    A subsequence of a string is a new string which is formed from the original
    string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. ("ACE" is a subsequence of "ABCDE" while "AEC" is not).

    Have you met this question in a real interview? Yes
    Example
    Given S = "rabbbit", T = "rabbit", return 3.

    Challenge 
    Do it in O(n^2) time and O(n) memory.

    O(n^2) memory is also acceptable if you do not know how to optimize memory.
 */

/////////////////
// DP template //
/////////////////

public class Solution {

    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();

        int[][] dp = new int[m + 1][n + 1];

        /* Select S's 0 to ith to match T's 0 to jth string */
        for (int i = 0; i <= m; i++) { 
            dp[i][0] = 1; /* Do not chose counts 1 way like choose subsets */
        }

        // for (int i = 0; i <= n; i++) {
        //     dp[0][i] = 0; /* Can't choose something from an empty string */
        // }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    //        match last char / does not match        
                    // 
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}