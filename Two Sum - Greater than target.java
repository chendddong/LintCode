// Given an array of integers, find how many pairs in the array
// such that their sum is bigger than a specific target number. 
// Please return the number of pairs.

// inputs int[] nums int targets
// outputs int count

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
    	if (nums == null || nums.length < 2) {
    		return 0;
    	}

    	int left = 0, right = nums.length - 1;
    	int count = 0;
    	Arrays.sort(nums);
    	while (left < right) {
    		int v = nums[left] + nums[right];
    		if (v > target) {
    			count += right - left;
    			right--;
    		} else {
                left++;
    		}
    	}
    	return count;
    }
}

/*
The same I guess
*/