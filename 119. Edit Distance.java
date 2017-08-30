/**
 * Given two words word1 and word2, find the minimum number of steps required
 * to convert word1 to word2. (each operation is counted as 1 step.)
 */

/*
    You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

    Example
    Given word1 = "mart" and word2 = "karma", return 3.
 */

/////////////////
// DP template //
/////////////////

public class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        /* 
            State : dp[i][j] the minimum steps we need to convert ith char in
            word1 to jth char in word2
         */
        int[][] dp = new int[m + 1][n + 1];


        /* Just omit the replace procedure, since it won't affect anything */
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; /* delete: length form i to 0 */
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i; /* insert: length from 0 to i */
        }

        /* Function */
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1]; /* Does not need to do things */
                else 
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // replace
                                   Math.min(dp[i][j - 1], dp[i - 1][j]));
                                // insert                   delete 
            }
        }

        /* Answer */
        return dp[m][n];
    }
}

////////////////
// DP concise //
////////////////

public class Solution {

    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();   
        char[] s2 = word2.toCharArray();
        int i, j;
        int m = s1.length;
        int n = s2.length;
        int[][] f = new int[m + 1][n + 1];
        for (i = 0; i <= m; ++i) {
            for (j = 0; j <= n; ++j) {
                /* Init */
                if (i == 0) {
                    f[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    f[i][j] = i;
                    continue;
                }
                //                           delete        insert      replace
                f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                /* Same char */
                if (s1[i - 1] == s2[j - 1]) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                }
            }
        }

        return f[m][n];
    }
}


