/**
 * Given a mountain sequence of n integers which increase firstly and then
 * decrease, find the mountain top.
 */

/*
    Example
    Given nums = [1, 2, 4, 8, 6, 3] return 8
    Given nums = [10, 9, 8, 7], return 10
 */ 


////////////////////////////////////////////////////////
// Solution 1 Compare nums[mid - 1] and nums[mid + 1] //
////////////////////////////////////////////////////////


public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        /* 
            nums[mid - 1] < nums[mid + 1] Go right
            nums[mid - 1] > nums[mid + 1] Go left
        */
        
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;            
            if (nums[mid - 1] < nums[mid + 1]) {
                start = mid;
            } else if (nums[mid - 1] > nums[mid + 1]) {
                end = mid;
            } else {
                return nums[mid];
            }
        }
        
        return Math.max(nums[start], nums[end]);
    }
}

//////////////////////////
// Solution 2 Cut twice //
//////////////////////////


public class Solution {
    public int mountainSequence(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid1 = start + (end - start) / 2;
            int mid2 = end - (end - mid1) / 2;
            if (nums[mid1] < nums[mid2]) {
                start = mid1 + 1;
            } else if (nums[mid1] > nums[mid2]) {
                end = mid2 - 1;
            } else {
                start = mid1;
                end = mid2;
            }
        }

        return nums[start] > nums[end] ? nums[start] : nums[end];
    }
}