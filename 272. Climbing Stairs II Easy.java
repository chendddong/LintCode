/*
    A child is running up a staircase with n steps, and can hop either 1 step,
    2 steps, or 3 steps at a time. Implement a method to count how many
    possible ways the child can run up the stairs.

    Example
    n=3
    1+1+1=2+1=1+2=3=3

    return 4
 */

///////////////
// Recursion //         TLE
///////////////
    
public class Solution {

    /*
        Time complexity : O(2^n). Size of recursion tree will be 2^n

        Space complexity : O(n). The depth of the recursion tree can go up to n
        (worst case) .
     */
    public int climbStairs2(int n) {
        return climbStairsHelper(0, n);
    }

    public int climbStairsHelper(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairsHelper(i + 1, n) + climbStairsHelper(i + 2, n) +
               climbStairsHelper(i + 3, n);
    }
}

/////////////////////
// Memorize Search //         
/////////////////////

public class Solution {

    /*
        Algorithm

        In the previous approach we are redundantly calculating the result for every step. Instead, we can store the result at each step in memo array and directly returning the result from the memo array whenever that function is called again.

        In this way we are pruning recursion tree with the help of memo array
        and reducing the size of recursion tree up to n.    
    
        Time complexity : O(n) Size of recursion tree can go up to n.

        Space complexity : O(n) The depth of recursion tree can go up to n.    
     */

    public int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climbStairsHelper(0, n, memo);
    }

    public int climbStairsHelper(int i, int n, int[] memo) {
        if (i > n) return 0;
        if (i == n) return 1;

        if (memo[i] > 0) return memo[i];

        memo[i] = climbStairsHelper(i + 1, n, memo) 
                + climbStairsHelper(i + 2, n, memo)
                + climbStairsHelper(i + 3, n, memo);

        return memo[i];
    }
}

///////////////////
// DP Space O(n) //         Template
///////////////////

public class Solution {

    /*
        Time complexity : O(n). Single loop upto n.
        Space complexity : O(n). dp array of size n is used.        
     */
    public int climbStairs2(int n) {
        
        /* Edge */
        if (n <= 1) return 1;
        /* state : dp[i] is the how many ways we can use to get position i */ 
        int[] dp = new int[n + 1];
        /* Init */
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        /* function dp[i] = dp[i - 2] + dp[i - 1]  + dp[i - 3][=-*/
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        /* Answer */
        return dp[n];
    }
}

///////////////////////////
// Iterative  Space O(1) //
///////////////////////////

public class Solution {
    /*
        Just like Fibonacci number.
        We can just solve it by iterative method

        Time complexity: O(n) Just traverse once

        Space complexity: O(1) 
     */
    public int climbStairs2(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;
        /* Must use tree variables to represent the basic conditions */

        int l = 2, ll = 1, lll = 1;
        int now = 0;
        for (int i = 3; i <= n; i++) {
            now = l + ll + lll;
            lll = ll;
            ll = l;
            l = now;
        }
        return now;
    }
}