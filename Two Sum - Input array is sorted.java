// Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
// Please note that your returned answers (both index1 and index2) are not zero-based.
// Given nums = [2, 7, 11, 15], target = 9
// return [1, 2]

// Solution #0 classic twoSums. Since the array is sorted, we can just use two pointers to narrow down the indices and then return the index + 1;
// The time O(n) No extra space is been used so this is better than the hashMap method
public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
    	if (nums == null || nums.length == 0) {
    		return new int[0];
    	}
    	int i = 0, j = nums.length - 1;
    	while (i < j) {
    		if (nums[i] + nums[j] > target) {
    			j--;
    			continue;
    		}
    		if (nums[i] + nums[j] < target) {
    			i++;
    			continue;
    		}
    		if (nums[i] + nums[j] == target) {
    			int[] result = {i + 1, j + 1};
    			return result;
    		}

    	}

    	int[] result = {};
    	return result;

    }
}

/* 
Yep the same
*/

// Solution #1 by jiuzhang

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                int[] pair = new int[2];
                pair[0] = start + 1;
                pair[1] = end + 1;
                return pair;
            }
            if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        
        return null;
    }
}

/* 
Should ask the interviewers about what to return and which value like empty array or null.
*/