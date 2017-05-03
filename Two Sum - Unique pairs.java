// Given an array of integers, find how many unique pairs in the 
// array such that their sum is equal to a specific target number. 
// Please return the number of pairs.
public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
    	if (nums == null || nums.length < 2) {
    		return 0;
    	}
    	// use two pointers
    	Arrays.sort(nums);
    	int count = 0;
    	int left = 0, right = nums.length - 1;
    	while (left < right) {
    		int v = nums[left] + nums[right];
    		if (v == target) {
    			count++;
    			left++;
    			right--;
    			// make sure the value are different 
    			while (left < right && nums[right] == nums[right + 1]) {
    				right--;
    			}
    			while (left < right && nums[left] == nums[left - 1]) {
    				left++;
    			}
    		} else if (v > target) {
    			right--;
    		} else {
    			left++;
    		}
    	}

    	return count;

    }
}

/* 
Use two pointers the trick part is how to make sure the value are not 
different from the previous element, here we used the while loop to detect
since we have incremented before that and there is no point we should worry
about the index out of bound.
*/