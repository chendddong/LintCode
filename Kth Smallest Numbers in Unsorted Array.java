// Find the kth smallest numbers in an unsorted integer array.

// [4,3,6,1,8,10] 5th
// corner cases 1. nums == null 2. k > length 

// inputs: int[] nums, int number
// outputs: int;

// use quick sort to partition the thgint and then just recurisively solve the problem.
// Solution #0 Mine

class Solution {
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
    	if (nums == null || nums.length < k) {
    		return Integer.MAX_VALUE;
    	}
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];

    }

    private void quickSort(int[] nums,
    					int start,
    					int end) {
    	int left = start;
    	int right = end;

    	int pivot = nums[(left + right) / 2];
    	while (left <= right) {
    		while (left <= right && nums[left] < pivot) {
    			left++;
    		}

    		while (left <= right && nums[right] > pivot) {
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

    	if (start < right) {
    		quickSort(nums, start, right);
    	}

    	if (left < end) {
    		quickSort(nums, left, end);
    	}
    }
}

/* 
Go through the whole process, you can find it fasinating to konw that what you wrote is right.

The use of the variables like i, j, left, right, start, end. must be aware of this.
*/

// Solution #1 by jiuzhang

class Solution {
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
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