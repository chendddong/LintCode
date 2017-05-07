// Find K-th largest element in an array. and N is much larger than k.
// You can swap elements in the array

// Example
// In array [9,3,2,4,8], the 3rd largest element is 4.

// In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

/* We can use Arrays.sort to sort the Array and then return the kth number */
import java.util.*;
class Solution {
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
};

/* Apparently, this is OK and can get a AC and the time O(nlogn) 
   Since N is much larger than k. We can think of another idea.
   if we can create a minHeap with k element, and then we just have to
   traverse the integer array and put them into the minHeap and at last just pop
   the number out.
*/

import java.util.*;
class Solution {
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        // we do not need a comparator coz it is the ascending order
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        // [9,3,2,4,8] 3
        // [4, 8, 9]
        for (int i = 0; i < nums.length; ++i) {
            if (pq.size() < k) {
                pq.add(nums[i]);
            } else {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }

        return (int)pq.poll();

    }
};   

/* 
1. Use of PQ, think reversely
2. How to add and pop when necessary
3. Time O(n)
*/