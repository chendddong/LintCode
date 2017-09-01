/*
    You are a professional robber planning to rob houses along a street. Each
    house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 */

/*
    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount f money you can rob tonight without alerting the police.

    Example
    Given [3, 8, 4], return 8.

    Challenge 
    O(n) time and O(1) memory.
 */

/////////////////
// DP template //
/////////////////

public class Solution {
    /*
        Series DP: from 0 to the nth, starting point from 0;
          0   1  2  3 ... index
        a =  [3, 8, 4]
       f:[0 | 1 |] 
       
       Use the % as the dynamic array.
       Finish the standard DP and then use the dynamic array.
     */

    public long houseRobber(int[] A) {
        if (A == null || A.length == 0) return 0;

        int n = A.length;
        /* State : dp[i] from index 0 to ith, the max money we can rub */
        // long[] dp = new long[n + 1]; /* Watch out the long */
        long[] dp = new long[2];

        /* Init */
        dp[0] = 0;
        dp[1] = A[0];

        /* Function */
        for (int i = 2; i <= n; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + A[i - 1]);
        }

        /* Answer */
        return dp[n % 2];
    }
}