public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        /* Set pointers */
        int start = 0;
        int end = nums.length - 1;

        /* Narrow down the possible answer to 2 */
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            /* Merge after we can */
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        /* Handle the answer */
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        
        return -1;
    }
}