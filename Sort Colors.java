// Given an array with n objects colored red, white or blue, 
// sort them so that objects of the same color are adjacent, 
// with the colors in the order red, white and blue.
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

//  Notice
// You are not suppose to use the library's sort function for this problem. 
// You should do it in-place (sort numbers in the original array).

// Example 
// Inputs:  [2,1,0,1,1,1,0,2,2,2,1]
// Outputs: [0,0,1,1,1,1,1,2,2,2,2]

// Test cases:
// normal one, calling the method
// edge case: null and [] just return

// Solution by jiuzhang
public class Solution {
	public void sortColors(in[] a) {
		if (a == null || a.length <= 1) {
			return;
		}

		int pl = 0;
		int pr = a.length - 1;
		int i = 0;
		while (i <= pr) {
			if (a[i] == 0) {
				swap(a, pl, i);
				pl++;
				i++;
			} else if (a[i] == 1) {
				i++;
			} else {
				swap(a, pr, i);
				pr--;
			}
		}
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

/*
Well-organized algorithm

3 pointers

nums[i] == 0
swap i , l
increment i and l

nums[i] == 1
increment i 

numbs[i] == 2
swap i , r
decrement r
*/
