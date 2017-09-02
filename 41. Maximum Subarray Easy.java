/**
 * Given an array of integers, find a contiguous subarray which has the largest
 * sum.
 */

/*
     Notice

    The subarray should contain at least one number.

    Example
    Given the array [−2,2,−3,4,−1,2,1,−5,3], 
    the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */

////////////////////////
// sum + ans + minSum //        
////////////////////////

public class Solution {
    /* Prefix sum */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int sum = 0, minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; /* The sum of all */
            max = Math.max(max, sum - minSum); /* Get the real max */
            minSum = Math.min(minSum, sum); /* Min between sum and minSum */
        }
        return max;
    }
}

/////////////
// Greedy  //
/////////////

public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i]; /* The sum of all */
            max = Math.max(max, sum); /* Update max */
            sum = Math.max(sum, 0); /* Sum must be positive!! */
        }
        return max;
    }
}

/////////////////
// DP Template //
/////////////////

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;

        // int[] global = new int[n]; /* The max sum of the global */
        // int[] local  = new int[n]; /* The sum w / o the current num */
        int[] global = new int[2]; 
        int[] local  = new int[2]; 

        global[0] = nums[0];
        local[0]  = nums[0];

        for (int i = 1; i < n; i++) {
            //                  without         with
            local[i%2] = Math.max(nums[i], local[(i - 1)%2] + nums[i]);
            global[i%2] = Math.max(local[i%2], global[(i - 1)%2]); /* Update */
        }

        return global[(n - 1)%2];
    }
}





