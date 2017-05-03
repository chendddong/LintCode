// Given an array of integers, remove the duplicate numbers in it.

// You should:
// 1. Do it in place in the array.
// 2. Move the unique numbers to the front of the array.
// 3. Return the total number of the unique numbers.

// You don't need to keep the original order of the integers.


// Given nums = [1,3,1,4,4,2], you should:

// Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
// Return the number of unique integers in nums => 4.
// Actually we don't care about what you place in ?, we only care about the part which has no duplicate integers.


// Solution #0 on my own
// 1. Do it in place in the array means that you should not create additional structures for this question
// 2. Move to the front means there must be two pointers
// 3. There must be a count for the total number
// 4. I know we can sort this array, but have no clue what's going to do next

// Solution #1 by jiuzhang
public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
    	if (nums.length == 0) {
    		return 0;
    	}

    	Arrays.sort(nums);
    	int len = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] != nums[len]) {
    			nums[++len] = nums[i];
    		}
    	}
    	// since the len is the index, index + 1 is the number of elements;
    	return len + 1;	
    }
}

/*
This is the classic two pointers, where you must set both pointers at the 0 first, and if are not equal to each other
the are gonna move the postion.

Pretty important algorithm. O(nlogn) for time and O(1) for place coz of the sorting and in-place moving.
We can also use hashMap to solve this problem but that requires the O(n) and O(n)
*/