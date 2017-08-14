// Given an array nums, write a function to move all 0's to the end of it 
// while maintaining the relative order of the non-zero elements.

// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

// Example
// Given nums = [0, 1, 0, 3, 12], after calling your function, 
// nums should be [1, 3, 12, 0, 0].

// I'm getting this a bit wrong at the first coz I did not notice that I should keep the element
// in the exact order that it should remian. So basically, it is wrong.

// public class Solution {
//     /**
//      * @param nums an integer array
//      * @return nothing, do this in-place
//      */
//     public void moveZeroes(int[] nums) {
//     	if (nums == null || nums.length == 0) {
//     		return;
//     	}

//     	int head = 0;
//     	int tail = nums.length - 1;
//     	while (head < tail) {
//     		if (nums[tail] == 0) {
//     			tail--;
//     			continue;
//     		}
//     		if (nums[head] == 0 && nums[tail] != 0) {
//     			int tmp = nums[head];
//     			nums[head] = nums[tail];
//     			nums[tail] = tmp;
//     			head++;
//     			tail--;
//     		}
//     		head++;
//     	}
//     }
// }

// Solution #0

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return;
    	}

    	int first = 0;
    	int second = 1;
    	while (second < nums.length) {
    		if (nums[first] == 0 && nums[second] != 0) {
    			int temp = nums[first];
    			nums[first] = nums[second];
    			nums[second] = temp;
    			first++;
    			second++;
    			continue;
    		}
    		if (nums[first] == 0 && nums[second] == 0) {
    			second++;
    			continue;
    		}

			first++;
    		second++;
    	}	
    }
}
/* 
This is how I see it, though there are bugs inside and I should take good 
care of those situations
*/

// Solution #1 from geeksforgeeks

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        int count = 0;  // Count of non-zero elements
 
        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[count++] = nums[i]; // here count is
                                       // incremented
        }
 
        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < nums.length) {
            nums[count++] = 0;
        }
    }
}

/* .
This shows me you could do one thing at a time.
move the non-zero element to right place and then
write all the zeros to the should-be place;
*/


    

    