// Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
// All elements < k are moved to the left
// All elements >= k are moved to the right
// Return the partitioning index, i.e the first index i nums[i] >= k.

// Inputs: int[] nums, int k;
// Outputs: index i nums[i] > k
// use two pointers

class Solution {
	public int partitionArray(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int i = 0, j = nums.length - 1;

		while (i <= j) {
			while (i <= j && nums[i] < k) {
				i++;
			}
            // i <= j always!!!
			while (i <= j && nums[j] >= k) {
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
        return i; 
	}
}

/* 
The importance of the partition and we should emulate what's happending during the process
so we will not miss anything important;

1. always i <= j for partition
2. nums[j] >= k is from the question itself
*/