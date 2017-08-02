/**
 * Find the kth smallest numbers in an unsorted integer array.
 */

/*
    Example
    Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are [1, 2, 3].
 */

///////////////////////////////
// StraightForward QuickSort //
///////////////////////////////
    
class Solution {

    public int kthSmallest(int k, int[] nums) {
        if (nums == null || nums.length < k) {
            return Integer.MAX_VALUE;
        }        
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }
    
    private void quickSort(int[] nums, int start, int end) {

        int i = start;
        int j = end;
        int pivot = nums[(i + j) / 2];
        
        while (i <= j) {
            while (nums[i] < pivot && i <= j) {
                i++;
            }
            while (nums[j] > pivot && i <= j) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        /* !These babies should be outside the while loop! */
        if (start < j) {
            quickSort(nums, start, j);    
        }
        if (i < end) {
            quickSort(nums, i, end);    
        }        
    }
};

/* 
    Go through the whole process, you can find it fascinating to know that what you wrote is right.

    The use of the variables like i, j, left, right, start, end. must be aware of this.
*/

//////////////////
// Quick Select //
//////////////////

class Solution {

    public int kthSmallest(int k, int[] nums) {
        /* Add one more parameter to stop the code earlier */
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSelect(int[] A, int start, int end , int k) {

        if (start == end)
            return A[start];
        
        int left = start, right = end;
        int pivot = A[(start + end) / 2];

        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }

            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left++;
                right--;
            }
        }

        if (right >= k && start <= right)
            return quickSelect(A, start, right, k);
        else if (left <= k && left <= end)
            return quickSelect(A, left, end, k);
        else
            return A[k];
    }
}

/* 
    Actually, this could be better since the average of find the k is less than sort all of the array.
    This is useful!!
*/