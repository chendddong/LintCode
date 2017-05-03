// Just finished listening the lecuture on jiuzhang about this quick select thing
// it was very helpful and it is the core knowledge that everyone should master
// Find K-th largest element in an array.

//  Notice

// You can swap elements in the array

// Have you met this question in a real interview? Yes
// Example
// In array [9,3,2,4,8], the 3rd largest element is 4.

// In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

// Solution #0 all by myslef

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
    	if (nums == null) {
    		return -1;
    	}
    	return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
    	if (start == end) {
    		return nums[start];
    	}

    	int i = start;
    	int j = end;
    	int pivot = nums[(i + j) / 2];

    	// partition
    	while (i <= j) {
    		while (i <= j && nums[i] > pivot) {
    			i++;
    		}

    		while (i <= j && nums[j] < pivot) {
    			j--;
    		}
    		// swap
    		if (i <= j) {
    			int tmp = nums[i];
    			nums[i] = nums[j];
    			nums[j] = tmp;
    			i++;
    			j--;
    		}
    	}

    	// decide k and then recursively solve the problem
    	if (start + k - 1 <= j) {
    		return quickSelect(nums, start, j, k);
    	}

    	if (start + k - 1 >= i) {
    		return quickSelect(nums, i, end, k - (i - start));
    	}

    	return nums[j + 1];

    }
}

// Solution #1 by jiuzhang
class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);
        
    }
    public int helper(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int position = partition(nums, l, r);
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {
            return helper(nums, position + 1, r, k);
        }  else {
            return helper(nums, l, position - 1, k);
        }
    }
    public int partition(int[] nums, int l, int r) {
        // 初始化左右指针和pivot
        int left = l, right = r;
        int pivot = nums[left];
        
        // 进行partition
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        
        // 返还pivot点到数组里面
        nums[left] = pivot;
        return left;         
    }
};

/* 
This is not as clear as the first solution.
*/