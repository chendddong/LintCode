/**
 * Given a string s, cut s into some substrings such that every substring is a
 * palindrome.
 */

/*
    Return the minimum cuts needed for a palindrome partitioning of s.

    Example
    Given s = "aab",

    Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.

    Come back for a walkthrough!!
 */


/////////
// DP1 //
/////////

public class Solution {
    /*
        2. dp[i] means from 0 to ith position. how many palindromes can we get.
        And the answer is f[n] - 1.
            "aab"
            dp[3] = dp["aab"] = 2;
            dp[2] = dp["aa"] = 1;
            dp[1] = dp["a"] = 1;
            dp[0] = dp[""] = 0;     
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0; /* Edge */

        /* Pre-process : reduce the time to O(n ^ 2) not O(n ^ 3) */
        boolean[][] isPalindrome = getIsPalindrome(s);

        /* State / Init */
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;

        /* Function: from 1 */
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[s.length()] - 1;
    }

    /* Treat this function as another type of the dp problem : Interval */
    private boolean[][] getIsPalindrome(String s) {
        /* 
            State: isPalindrome[i][j] means if the string is palindrome from i
            to j or not.
         */
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        /* Init */
        for (int i = 0; i < s.length(); i++) { /* Diagonal: self */
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) { /* Adjacent ones */
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length] = 
                    isPalindrome[start + 1][start + length - 1] &&
                    s.charAt(start) == s.charAt(start + length);
            }
        }

        return isPalindrome;
    }
}

/////////
// DP2 //
/////////    

public class Solution {
    /*
        1. dp[i]  means the fewest cuts for 0 to ith position to be all
        palindrome in the string.
        And the answer is f[n].  
            Use simple example to test.
            "aab"
            dp[3] = dp["aab"] = 1;
            dp[2] = dp["aa"] = 0;
            dp[1] = dp["a"] = 0;
            dp[0] = dp[""] = -1; (since  "" | aa  <==> dp[""] + 1 = 0;)

     */   

    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }

        return isPalindrome;
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        boolean[][] isPalindrome = getIsPalindrome(s);
        
        int[] f = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            f[i] = i - 1;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }

        return f[s.length()];
    }

/* Basic two pointers : isPalindrome */
// private boolean isPalindrome(String s, int start, int end) {
//     for (int i = start, j = end; i < j; i++, j--) {
//         if (s.charAt(i) != s.charAt(j)) {
//             return false;
//         }
//     }
//     return true;
// }    
}




