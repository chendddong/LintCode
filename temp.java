/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 */

/*
    Each element in the array represents your maximum jump length at that position.

    Your goal is to reach the last index in the minimum number of jumps.

    Example
    Given array A = [2,3,1,1,4]
                dp
    The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */

/////////////////
// DP template //
/////////////////

public class Solution {

    /*
        Time : O(n ^ 2)
        Space : O(n)
     */
    public int jump(int[] A) {
        /* State : dp[i] is the number of min steps we need to reach the end */
        int[] dp = new int[A.length];

        /* Init */
        dp[0] = 0;
        for (int i = 1; i < A.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        /* FUCNTION */
        for (int i = 1; i < A.length; i++) 
            for (int j = 0; j < i; j++)
                if (dp[j] != Integer.MAX_VALUE && A[j] >= i - j)
                    dp[i] = Math.min(dp[i], dp[j] + 1); /* Ensure the smallest
                    */
        
        /* Answer */
        return dp[A.length - 1];
        
    }
}

////////////
// Greedy //
////////////

public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i > farthest) {
                    farthest = A[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;
    }
}

