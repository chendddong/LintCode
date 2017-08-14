// Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.
// Return the difference between the sum of the two integers and the target.

// the run time should be O(n) if we use the two pointers

public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
    	if (nums == null || nums.length < 2) {
    		return -1;
    	}

    	int left = 0;
    	int right = nums.length - 1;
    	int diff = 
    	Integer.MAX_VALUE;
        
        Arrays.sort(nums);
    	while (left < right) {
    		int v = nums[left] + nums[right];
    		if (v == target) {
    			return 0;
    		}
    		if (v > target) {
    			diff = Math.min(diff, Math.abs(v - target));
    			right--;
    		}
    		if (v < target) {
    			diff = Math.min(diff, Math.abs(v - target));
    			left++;
    		}
    	}

    	return diff;
    }
}

/*
Don't forget to sort the array, and point that out during the interview and mark it on the scratch paper whenever possilbe.
Just be carful about the index variable. They are either left, right or i or j. 

Integer.MAX_VALUE this is how to write the Integer.MAX_VALUE
*/