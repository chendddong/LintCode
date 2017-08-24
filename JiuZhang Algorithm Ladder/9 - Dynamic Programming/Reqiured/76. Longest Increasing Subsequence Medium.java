/**
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * You code should return the length of the LIS.
 */

/*
    Clarification
    What's the definition of longest increasing subsequence?

    The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.

    Example
    For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
    For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4

    Challenge 
    Time complexity O(n^2) or O(nlogn)
 */

//////////////////
// DP template  //          Not easy to think
//////////////////

public class Solution {
    /*
        Time complexity O(n^2) 
        Space complexity O(n)
     */
    public int lengthOfLIS(int[] nums) {
        /* State */
        int[] dp = new int[nums.length];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1; /* Init We can take it outside */
            /* Function */
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = dp[i] > dp[j] ? dp[i] : dp[j] + 1;
                }
            }
            if (dp[i] > max) { /* Record max instead of compare at the end */
                max = dp[i];
            }
        }

        return max;
    }

    /* Algorithm walkthrough */
    // max = 3;
    // arr = [5, 4, 1, 2, 3]
    // dp  = [1, 1, 1, 2, 3]
}

///////////////////
// Binary Search //
///////////////////

public class Solution {

    /*
        Time complexity : O(nlogn)
        Space complexity : O(n)
     */
    public int lengthOfLIS(int[] nums) {
        int[] minLast = new int[nums.length + 1];
        minLast[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }

        // nums    =    [5, 4, 1, 2, 3]
        // minLast = [-, 1, 2, 3, +, +]
        
        /* Traverse once and then binary search for n times O(nlogn) */
        for (int i = 0; i < nums.length; i++) {
            /* Find the first number in minLast >= nums[i] */
            int index = binarySearch(minLast, nums[i]);
            minLast[index] = nums[i];
        }

        for (int i = nums.length; i >= 1; i--) {
            
            if (minLast[i] != Integer.MAX_VALUE) { 
                return i; /* Return the last possible value */
            }
        }

        return 0;
    }
 
    // minLast = [-, 1, 2, +, +, +]    3
    private int binarySearch(int[] minLast, int num) {
        int start = 0, end = minLast.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (minLast[mid] < num)
                start = mid;
            else 
                end = mid;
        }

        return end;
    }
}






