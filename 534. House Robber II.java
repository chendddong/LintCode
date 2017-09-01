/*
    After robbing those houses on that street, the thief has found himself a new
    place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */

/*
    This is an extension of House Robber.

    Have you met this question in a real interview? Yes
    Example
    nums = [3,6,4], return 6
 */

public class Solution {
    /*
        How to solve the circular array
        1. divide(Use this method in this problem)
        2. repeat
        3. get negative
     */

    public int houseRobber2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0]; /* Since we are divide the arr */
                        // [3, 6]
        return Math.max(robber2(nums, 0, nums.length - 2),
                        robber2(nums, 1, nums.length - 1));
                        // [6, 4]
    }

    private int robber2(int[] nums, int start, int end) {
        int[] dp = new int[2];
        if (start == end) return nums[end]; // nums[start];
        if (start + 1 == end) return Math.max(nums[start], nums[end]); // two

        /* Init */
        dp[start % 2] = nums[start];
        dp[(start + 1) % 2] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i]);
        }

        return dp[end % 2];
    }
}