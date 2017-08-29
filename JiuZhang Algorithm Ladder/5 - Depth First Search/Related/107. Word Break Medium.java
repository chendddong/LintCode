/**
 * Given a string s and a dictionary of words dict, determine if s can be break
 * into a space-separated sequence of one or more dictionary words.
 */

/*
    Example
    Given s = "lintcode", dict = ["lint", "code"].

    Return true because "lintcode" can be break as "lint code".
 */

////////////////////
// DP Brute Force //                MLE
////////////////////

public class Solution {
    /*
        MLE because the length of the word could just be around 6. So here we
        have done some redundant work of finding a word which is not quite
        possible.
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        /* State: */
        boolean[] dp = new boolean[n + 1];

        /* Init */
        dp[0] = true; 

        /*  
            Function: 
            s = "abcde"
            from a, ab, ... , abcde
        */
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                String sub = s.substring(j, i);
                if (dict.contains(sub)) {
                    dp[i] = true; /* OR{f[i]} */
                    break;
                }
            }
        }

        return dp[n];
    }
}

/////////////////////
// DP Optimization //       Restrain the max word length
/////////////////////

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return true;

        int maxLength = getMaxLength(dict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            dp[i] = false;
            for (int lastWordLength = 1;
                     lastWordLength <= maxLength && lastWordLength <= i;
                     lastWordLength++) {
                if (!dp[i - lastWordLength]) continue;
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}



