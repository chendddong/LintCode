// Given a unsorted array with integers, find the median of it.

// A median is the middle number of the array after it is sorted.

// If there are even numbers in the array, return the N/2-th number after sorted.

// Have you met this question in a real interview? Yes
// Example
// Given [4, 5, 1, 2, 3], return 3.

// Given [7, 9, 4, 5], return 5.

// Solution #0
// The easies way is to just sort the array and then if it has odd number of elements, then
// we are gonna return the N / 2 th number. [1,2,3] we are gonna return nums[3 / 2] which is 2
// the O(nlogn) because of the sorting algorithm. [1,2,3,4] return nums[4 / 2 -
// 1]
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Arrays.sort(nums);
        int len = nums.length;

        if (len % 2 == 0) {
            return nums[len / 2 - 1];
        } else {
            return nums[len / 2];
        }
    }
}

   
// Solution #1 to reduce the time complexity to O(n). Under this circumstance, I would like to use
// the quickSelect method to partition those numbers in place and also has the O(n) complexity

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        sort(nums, 0, nums.length - 1);

        if (nums.length % 2 == 0) {
            return nums[nums.length / 2 - 1];
        } else {
            return nums[nums.length / 2];
        }

    }
    
    private void sort(int[] nums, int start, int end) {
    //  if (start == end) {
    //      return;
    //  }

        int i = start;
        int j = end;
        int pivot = nums[(i + j) / 2];
    
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }

            while (i <= j && nums[j] > pivot) {
                j--;
            }
            // swap numbers
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        // going for the recursive method

        if (start < j) {
            sort(nums, start, j);
        }
        if (i < end) {
            sort(nums, i, end);
        }
    }
}

/*
    Remember there is a way to use recursive that is the base case! Here we use the start < j and i < end as the 
    indicator to end.
*/