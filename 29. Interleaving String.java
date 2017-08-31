/**
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the
 * interleaving of s1 and s2.
 */

/*
    Example
    For s1 = "aabcc", s2 = "dbbca"

    When s3 = "aadbbcbcac", return true.
    When s3 = "aadbbbaccc", return false.
    Challenge 
    O(n2) time or better
 */

/*
    Time complexity : O(m*n). dp array of size m*nm∗n is filled.

    Space complexity : O(m*n). 2-d DP of size (m+1)*(n+1) is required. m and n
    are the lengths of strings s1 and s2 respectively.
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int m = s1.length();
        int n = s2.length();

        /* 
            State : can index 0 to ith from s1 plussing the index 0 to jth from
            s2 forms the 0 to (i + j)th of s3 
        */
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        /* Init */
        for (int i = 1; i <= m; i++) { /* match s1 with s3 */
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1][0]) {
                dp[i][0] = true;
            }
        }
        for (int i = 1; i <= n; i++) { /* match s2 with s3 */
            if (s3.charAt(i - 1) == s2.charAt(i - 1) && dp[0][i - 1]) {
                dp[0][i] = true;
            }
        }

        /* Function */
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ((s3.charAt(i+j-1) == s1.charAt(i-1) && dp[i-1][j]) || 
                    (s3.charAt(i+j-1) == s2.charAt(j-1) && dp[i][j-1]))
                    dp[i][j] = true;
            }
        }

        /* Answer */
        return dp[m][n];
    }
}


////////////////
//DP 1D Array //
////////////////

/*
    we can maintain a 1-d array only and update the array's element dp[i]dp[i] when needed using dp[i-1]dp[i−1] and the previous value of dp[i]dp[i].

    Time complexity : O(m*n). dp array of size n is filled mm times.
    Space complexity : O(n). n is the length of the string s1.    
 */

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                /* Init here */
                if (i == 0 && j == 0) { 
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);

                /* Function */    
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }
}