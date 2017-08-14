// Given an array of integers, find how many pairs in the array such
// that their sum is less than or equal to a specific target number. 
// Please return the number of pairs.

// Inputs : int[] nums, int target;
// Outputs : int count;

// test case:
// corner cases

// two pointers

// an O(n) algorithm 

// public class Solution {
//     /**
//      * @param nums an array of integer
//      * @param target an integer
//      * @return an integer
//      */
//     public int twoSum5(int[] nums, int target) {
//     	if (nums == null || nums.length < 2) {
//     		return 0;
//     	}

//     	int i = 0;
//     	int j = nums.length - 1;
//     	int count = 0;
//     	Arrays.sort(nums);
//     	while (i <= j ) {
//     		if (i < j) {
//     			if (nums[i] + nums[j] <= traget) {
//     				count += i + 1;
//     				i++;
//     				j--;
//     			} else {
//     				j--;
//     			}
//     		}

//     		if (i == j) {
//     			if (nums[i] + nums[i + 1] <= traget) {
//     				count += i + 1;
//     				i++;
//     				j--;
//     			} else {
//     				if (nums[i - 1] + nums[i] <= traget) {
//     					count += i;
//     					i++;
//     					j--;
//     				}
//     			}

//     		}


// 		}
// 		int n = i - 1, r = 2;
// 		int add = n! / (2! * r!)
//     	return count + add;

//     }
// }

/* 
I know there is some point that I have to alter a little bit to avoid too much if and else
yep. feels bad man
*/

// Solution #1 by jiuzhang

public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
    	if (nums == null || nums.length < 2) {
    		return 0;
    	}

    	Arrays.sort(nums);
    	int count = 0;
    	int left = 0, right = nums.length - 1;

    	while (left < right) {
    		int v = nums[left] + nums[right];
    		if (v > target) {
    			right--;
    		} else {
    			count += right - left;
    			left++;
    		}
    	}

    	return count;
    }
}

/* 
two pointer at the beginning and the end
if  the sum is larger than target move the right--
else move the left++
remeber the count += right - left
*/