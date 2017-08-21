

// 递推
public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if (s1.length() != s2.length())
            return false;
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n+1];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            
        for (int len = 2; len <= n; ++len)
            for (int x = 0; x < n && x + len <= n; ++x)
                for (int y = 0; y < n && y + len <=n; ++y)
                    for (int k= 1; k < len; ++k)
                    dp[x][y][len] |= dp[x][y][k] && dp[x + k][y + k][len - k]
                    || dp[x][y + len - k][k] && dp[x + k][y][len - k];
    
        return dp[0][0][n];
    }
}