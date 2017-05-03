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