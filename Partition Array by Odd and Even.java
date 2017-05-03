// Partition an integers array into odd number first and even number second.


// Inputs: int[] nums
// void method

// [5,2,4,3,1,7,8] [1,3,5,7,9]
// corner cases if nums == null or [] return;

// Solution #0 Mine
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return;
    	}
    	int left = 0, right = nums.length - 1;
    	int pivot = nums[nums.length / 2];
    	while (left <= right) {
    		while (left <= right && nums[left] % 2 == 1) {
    			left++;
    		}
    		while (left <= right && nums[right] % 2 == 0) {
    			right--;
    		}

    		if (left <= right) {
    			int tmp = nums[left];
    			nums[left] = nums[right];
    			nums[right] = tmp;
    			left++;
    			right--;
    		}
    	}
    }
}

/* 
Basic case
*/

// Solution #1 by jiuzhang
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 == 1) {
                start++;
            }
            while (start < end && nums[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                int temp = nums[start]; nums[start] = nums[end]; nums[end] = temp;
                start++;
                end--;
            } 
        }
    }
}