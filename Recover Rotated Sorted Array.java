// Given a rotated sorted array, recover it to sorted array in-place.

// Clarification
// What is rotated array?

// For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
// Example
// [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

// Solution #0 straightforward?
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	if (nums == null || nums.size() == 0) {
    		return;
    	}

    	Collections.sort(nums);
    }
}

/* 
There is definitely a way to sort the ArrayList which is to use Collections.sort something like Arrays.sort();
*/

// Solution #1 we can know the size of the of the ArrayList and we can use binary search to get the smallest number
// and the index i then try to add the first i numbers to the ArrayList at same time delete that number
// So the time complexity acutally is O(n)

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	if (nums == null || nums.size() == 0) {
    		return;
    	}
    	// time complexity can be O(n)
    	int min = Collections.min(nums);
		int minIndex = nums.indexOf(min);
		
		while (nums.get(0) != min) {
			nums.add(nums.get(0));
			nums.remove(0);
		}	
    }
}

/*
This is a O(n) algorithm. There are some nice features in the Java Class, feel free to explore that in the future.

Try to remember how to find the min in the ArrayList Collections.min(nums)
Try to remember how to find the minIndex in nums.indexOf(Collections.min(nums))
*/


// Solution #2 by jiuzhang

import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    private void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
        	int temp = nums.get(i);
        	nums.set(i, nums.get(j));
        	nums.set(j, temp);
        }
    }


    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	for (int index = 0; index < nums.size() - 1; index++) {
    		if (nums.get(index) > nums.get(index + 1)) {
    			reverse(nums, 0, index);
    			reverse(nums, index + 1, nums.size() - 1);
    			reverse(nums, 0, nums.size() - 1);
    			return;
    		}
    	}
    }
    
}

/*
This is weird. How can somebody come up with something like this?
Actually it is pretty good. all the moves are O(n) without additional space being used;
Reverse Reverse and Reverse!
*/
