/*
    Given a positive integer n, find the least number of perfect square numbers 
    (for example, 1, 4, 9, 16, ...) which sum to n.

    Example
    Given n = 12, return 3 because 12 = 4 + 4 + 4
    Given n = 13, return 2 because 13 = 4 + 9
 */

//////////////
// Template //      Second loop starts from 1
//////////////

public class Solution {

    public int numSquares(int n) {
        /* State: dp[i] the least number of squares for that number i */
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        /* Init : Set the perfect square to 1 */
        for (int i = 0; i * i <= n; ++i) {
            dp[i * i] = 1;
        }

        /* Function */
        for (int i = 0; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        /* Answer */
        return dp[n];

        /* Walkthrough */
        //  n = 7
        // index    0, 1, 2, 3, 4, 5, 6, 7   
        // dp =    [1, 1, 2, 3, 1, 2, 3, 4]

    }
}

///////////////////
// Also Template //      Second loop starts from 0
///////////////////

public class Solution {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i)
            dp[i * i] = 1;

        for (int i = 0; i <= n; ++i)
            for (int j = 0; i + j * j <= n; ++j)
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);

        return dp[n];

        /* Walkthrough */
        //  n = 7
        // index    0, 1, 2, 3, 4, 5, 6, 7   
        // dp =    [1, 1, 2, 3, 1, 2, 3, 4]
        // This solution has the same dp as the first one
    }
}

///////////////////
// Math Solution //         Do not understand : )
///////////////////

public class Solution {
    /*
        Time : O(n)
        Space : in place 
     */
    public int numSquares(int n) {

        while (n % 4 == 0)
            n /= 4;

        if (n % 8 == 7)
            return 4;
        for (int i = 0; i * i <= n; ++i) {
            int j = (int) Math.sqrt(n * 1.0 - i * i);
            if (i * i + j * j == n) {
                int res = 0;
                if (i > 0)
                    res += 1;
                if (j > 0)
                    res += 1;
                return res;
            }
        }
        return 3;
    }
}


/*
    How to get the Function we need by observation.

    dp[n] indicates that the perfect squares count of the given n, and we have:

    dp[0] = 0 
    dp[1] = dp[0]+1 = 1
    dp[2] = dp[1]+1 = 2
    dp[3] = dp[2]+1 = 3
    dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
          = Min{ dp[3]+1, dp[0]+1 } 
          = 1               
    dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
          = Min{ dp[4]+1, dp[1]+1 } 
          = 2
                            .
                            .
                            .
    dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
           = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
           = 2
                            .
                            .
                            .
    dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1    
 */