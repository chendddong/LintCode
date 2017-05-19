/*
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    Find the minimum element.

    You may assume no duplicate exists in the array.
 */


/*
    Example
    Given [4, 5, 6, 7, 0, 1, 2] return 0
 */

//////////////////////////////////
// Solution 1 Find the 'target' //
//////////////////////////////////
    

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }

        int start = 0;
        int end = nums.length - 1;
        int target = nums[end];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2 ;
            if (nums[mid] < target) {
                end = mid;
            } else {
                start = mid;
            } 
        }

        return Math.min(nums[start], nums[end]);
    }
}


