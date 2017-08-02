/**
 * Given an array of integers, find how many pairs in the array such that their
 * sum is less than or equal to a specific target number. Please return the
 * number of pairs.
 */

/*
    Example
    Given nums = [2, 7, 11, 15], target = 24. 
    Return 5. 
    2 + 7 < 24
    2 + 11 < 24
    2 + 15 < 24
    7 + 11 < 24
    7 + 15 < 25
 */

//////////////////
// Two Pointers //
//////////////////

public class Solution {
    // [2, 7, 11, 15] sum = 24
    // i           j  +3
    //     i          +2
    //        i
    public int twoSum5(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int i = 0; /* Left p */
        int j = nums.length - 1; /* Right p */
        int numPairs = 0;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum <= target) {
                numPairs += j - i;
                i++;
            } else {
                j--;
            }
        }

        return numPairs;
    }
}