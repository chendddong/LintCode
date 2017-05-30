*
 * Given a rotated sorted array, recover it to sorted array in-place.
 */


/*
    Clarification
    What is rotated array?

    For example, the original array is [1,2,3,4], The rotated array of it can
    be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
    Example
    [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

 */
    
//////////////////////////////////
// Solution #0 straightforward? //
//////////////////////////////////

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	if (nums == null || nums.size() == 0) {
    		return;
    	}

    	Collections.sort(nums);
    }
}

/* 
There is definitely a way to sort the ArrayList which is to use Collections.sort something like Arrays.sort();
*/


////////////////////////////////////////////
// Solution #1 Java Class Add to the Last //
////////////////////////////////////////////


/*
    Solution #1 we can know the size of the of the ArrayList and we can use binary search to get the smallest number
    and the index i then try to add the first i numbers to the ArrayList at same time delete that number
    So the time complexity actually is O(n)
 */


public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	if (nums == null || nums.size() == 0) {
    		return;
    	}
    	// time complexity can be O(n)
    	int min = Collections.min(nums);
		int minIndex = nums.indexOf(min);
		
		while (nums.get(0) != min) {
			nums.add(nums.get(0));
			nums.remove(0);
		}	
    }
}

/*
    This is a O(n) algorithm. There are some nice features in the Java Class, feel free to explore that in the future.

    Try to remember how to find the min in the ArrayList Collections.min(nums)
    Try to remember how to find the minIndex in nums.indexOf(Collections.min(nums))
*/


 /////////////////////////////////////////////////
 // Solution #2 by Tree Swaps in-Place Rotation //
 /////////////////////////////////////////////////


import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    
    /* Three swaps */
    private void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
        	int temp = nums.get(i);
        	nums.set(i, nums.get(j));
        	nums.set(j, temp);
        }
    }

    // [4,  5,  1, 2, 3] -> [1, 2, 3, 4, 5]
    //    index
    
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	for (int index = 0; index < nums.size() - 1; index++) {
            /* find the max-number position */
    		if (nums.get(index) > nums.get(index + 1)) {
    			reverse(nums, 0, index);
    			reverse(nums, index + 1, nums.size() - 1);
    			reverse(nums, 0, nums.size() - 1);
    			return;
    		}
    	}
    }
    
}

/*
    This is weird. How can somebody come up with something like this?
    Actually it is pretty good. all the moves are O(n) without additional space being used;

    Reverse Reverse and Reverse!
*/


////////////////////////////////////////////////////////////////////////////
// Another similar question left-rotated / right-rotated the sorted array //
////////////////////////////////////////////////////////////////////////////
    

import java.util.Scanner;

//  Time Complexity: O(n)
// Space Complexity: O(1) by doing an "in place" rotation
public class Solution {
    public static void main(String [] args) {
        /* Save input */
        Scanner scan = new Scanner(System.in);
        int size         = scan.nextInt();
        int numRotations = scan.nextInt();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();
        
        /* Rotate array (in place) using 3 reverse operations */
        numRotations %= size; // to account for numRotations > size
        int rotationSpot = numRotations - 1;
        reverse(array, 0, rotationSpot);
        reverse(array, rotationSpot + 1, size - 1);
        reverse(array, 0, size - 1);

        /* another way to choose a rotationSpot */

        // int rotationSpot = size - 1 - numRotations;
        // reverse(array, 0, size - 1);
        // reverse(array, 0, rotationSpot);
        // reverse(array, rotationSpot + 1, size - 1);
        
        /* Print rotated array */
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
    
    /* Swap from start to end -- Much cleaner this way */
    private static void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // /* Reverses array from "start" to "end" inclusive */
    // private static void reverse(int [] array, int start, int end) {
    //     /* clearer than using a while loop */
    //     if (array == null || start < 0 || start >= array.length || 
    //         end < 0 || end >= array.length || start >= end) {
    //         return;
    //     }
    //     int mid = (start + end) / 2;
    //     for (int i = start; i <= mid; i++) {
    //         int offset = i - start; // use a offset in here to be elegant
    //         swap(array, start + offset, end - offset);
    //     }
    // }
    
    // /* basic three way swaps */
    // private static void swap(int [] array, int i, int j) {
    //     int temp = array[i];
    //     array[i] = array[j];
    //     array[j] = temp;
    // }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

}

/*
    This problem can also be extended to the 'right' rotate where we would be
    choosing a rotationSpot accordingly. Blow are some pseudo codes

    arr = [1, 2, 3, 4, 5] , k = 2(after modulo), size = 5;
    
    Based on the previous experience we could choose the rotationSpot as p 
    1.  p = size - k (index 3)
        reverse(arr, 0 , p - 1);
        reverse(arr, p , size - 1);
        reverse(arr, 0 , size - 1);

    2.  p = k - 1 (index 1)
        reverse(arr, 0, size - 1);
        reverse(arr, 0, p);
        reverse(arr, p + 1 ,size - 1);

 