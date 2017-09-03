/*
    Given a string S, find the longest palindromic substring in S. You may
    assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

/*
    Example
    Given the string = "abcdzdcab", return "cdzdc".

    Challenge 
    O(n^2) time is acceptable. Can you do it in O(n) time.
 */

//////////////////////////////////
// Two Pointers same directions //
//////////////////////////////////

public class Solution {
    /*
        Time complexity : O(n ^ 2) two loops are there.
        Space complexity : O(n) because of the string builder.
     */
    public String longestPalindrome(String s) {
        if (s == null) return null;
        if (s.length() == 0) return "";
        
        int best = 0;
        String result  = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    /* 
                        Get the palindrome substring: 
                            1. Empty string if it is not a palindrome.
                            2. Just return the palindrome.
                     */  
                    String sub = helper(i, j, s); 

                    if (sub.length() >= best) { /* Update the result */
                        best = sub.length();
                        result = sub;
                    }
                }
                
            }
        }
        
        return result;
    }
    
    public String helper(int start, int end, String s) {
        String sub = s.substring(start, end + 1);
        /* we have to split the string first and use the regex just in case */
        String[] words = sub.toLowerCase().split("[ \n\t\r.,;:!?(){]");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }
        String cleanS = sb.toString();

        int i = 0;
        int j = cleanS.length() - 1;

        while (i <= j) {
            if (cleanS.charAt(i) != cleanS.charAt(j)) {
                return "";
            }
            i++;
            j--;
        }

        return sub;
    }
}

//////////////////////
// Expand the thing //
//////////////////////

public class Solution {
    private int lo, maxLen;
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i); /* Odd length */
            extendPalindrome(s, i, i + 1); /* Even length */
        }

        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        /* 
            1. Must be inbound
            2. Expanding two chars must be the same till the pair of char is not.
         */        
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (k - j - 1 > maxLen) { /* Update the lo and high! Mind the index */
            lo = j + 1; 
            maxLen = k - j - 1;
        }
    }
}

////////
// DP //
////////

/*
    dp(i, j) represents whether s(i ... j) can form a palindromic substring, dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring. When we found a palindrome, check if it's the longest one. Time complexity O(n^2).
 */

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && 
                           (j - i < 3 || dp[i + 1][j - 1]);
                              // corner 
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) 
                    res = s.substring(i, j + 1); /* Update result */
            }
        }

        return res;
    }
}



