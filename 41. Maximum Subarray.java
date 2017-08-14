
// Given an array of integers, find a contiguous subarray which has the largest sum.

//  Notice

// The subarray should contain at least one number.

// Have you met this question in a real interview? Yes
// Example
// Given the array [−2,2,−3,4,−1,2,1,−5,3], 
// the contiguous subarray [4,−1,2,1] has the largest sum = 6.

// the greedy version

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}

// Solution 2

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     * another version using the minSum
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0, minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}