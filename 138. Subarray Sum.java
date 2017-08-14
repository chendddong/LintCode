// Given an integer array, find a subarray where the sum of numbers is zero. 
// Your code should return the index of the first number and the index of the 
// last number.

//  Notice

// There is at least one subarray that it's sum equals to zero.

// Have you met this question in a real interview? Yes
// Example
// Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
// the brute force verison

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
    	int len = nums.length;

    	ArrayList<Integer> result = new ArrayList<Integer>();
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.put(0, -1);

    	int sum = 0;
    	for (int i = 0; i < len; i++) {
    		sum += nums[i];

    		if (map.containsKey(sum)) {
    			result.add(map.get(sum) + 1);
    			result.add(i);
    			return result;
    		}

    		map.put(sum, i);
    	}

    	return result;
    	
    }
}