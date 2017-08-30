/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 */

/*
    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given an encoded message containing digits, determine the total number of ways to decode it.

    Example
    Given encoded message 12, it could be decoded as AB (1 2) or L (12).
    The number of ways decoding 12 is 2.
 */

public class Solution {

    public int numDecodings(String s) {
        // 231241
        if (s == null || s.length() == 0) return 0;

        char[] arr = s.toCharArray();
        int n = arr.length;

        /* State / Init: dp[i] how many possible ways before this index */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = arr[0] != '0' ? 1 : 0; /* Tricky part */

        /* Function */
        for (int i = 2; i <= n; i++) {
            if (arr[i - 1] != '0') { /* One edge case */
                dp[i] = dp[i - 1];
            }

            /* Go by two digits coz we are initialized two */ 
            int twoDigits = (arr[i - 2] - '0') * 10 + arr[i - 1] - '0'; 
            if (twoDigits >= 10 && twoDigits <= 26) { /* In the range of
            'duplicate' */
                dp[i] += dp[i - 2]; 
            }
        }

        return dp[n];
    }
}