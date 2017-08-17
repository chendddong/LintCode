/*
    Given an array nums containing n + 1 integers where each integer is between
    1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 */

/*
    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n^2).
    There is only one duplicate number in the array, but it could be repeated more than once.

    Example
    Given nums = [5,5,4,3,2,1] return 5
    Given nums = [5,4,4,3,2,1] return 4

    How to come up with the binary search!!
 */

public class Solution {

    public int findDuplicate(int[] nums) {  
        int start = 1;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2; /* Treat this like median */
            if (checkSmallerNum(mid, nums) <= mid) {
                /* If the number of numbers that is smaller than or equal to the
                the median, that means there must be a larger duplicate */
                start = mid;
            } else {
                end = mid;
            }
        }

        if (checkSmallerNum(start, nums) <= start) { /* Slightly larger one */
            return end;
        }

        return start; /* Narrow the answer down */
    }

    private int checkSmallerNum(int mid, int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                count++;
            }
        }
        return count;
    }
} 
