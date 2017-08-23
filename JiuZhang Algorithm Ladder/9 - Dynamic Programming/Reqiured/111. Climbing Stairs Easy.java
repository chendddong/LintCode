/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 */

/*
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Example
    Given an example n=3 , 1+1+1=2+1=1+2=3

    return 3
 */

///////////////
// Recursion //         TLE
///////////////
    
public class Solution {

    /*
        Time complexity : O(2^n). Size of recursion tree will be 2^n
        Recursion tree for n=5 would be like this: 
                                      (0, 5)
                            /                              \    
                        (1, 5)                           (2, 5)
                   /           \                     /               \
              (2, 5)           (3, 5)             (3, 5)           (4, 5)   
          /        \          /       \        /       \          /    \
       (3, 5)   (4, 5)    (4, 5)    (5, 5)  (4, 5)  (5, 5)  (5, 5)  (6, 5) 
      /   \     /    \    /    \   /   \ 
    (4,5)(5,5)(5,5)(6,5)(5,5)(6,5)(5,5)(6,5)   

                    Number of nodes = O(2 ^ n) 

        Space complexity : O(n). The depth of the recursion tree can go up to n
        (worst case) .
     */
    public int climbStairs(int n) {
        climbStairsHelper(0, n);
    }

    public int climbStairsHelper(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairsHelper(i + 1, n) + climbStairsHelper(i + 2, n);
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

    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climbStairsHelper(0, n, memo);
    }

    public int climbStairsHelper(int i, int n, int[] memo) {
        if (i > n) return 0;
        if (i == n) return 1;

        if (memo[i] > 0) return memo[i];

        memo[i] = climbStairsHelper(i + 1, n, memo) 
                + climbStairsHelper(i + 2, n, memo);

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
    public int climbStairs(int n) {
        
        /* Edge */
        if (n <= 1) return 1;
        /* state : dp[i] is the how many ways we can use to get position i */ 
        int[] dp = new int[n + 1];
        /* Init */
        dp[0] = dp[1] = 1;
        /* function dp[i] = dp[i - 2] + dp[i - 1] */
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
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
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        /* Must use tree variables to represent the basic conditions */
        int last = 1, lastlast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }
}

////////////////////////
// Fibonacci Formula  //
////////////////////////

public class Solution {
    /*
        Time complexity : O(log(n)). pow method takes log(n) time.
        Space complexity : O(1). Constant space is used.    
     */    
    public int climbStairs(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }
}


