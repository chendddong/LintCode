/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 */

/*
    Example
    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

//////////////////
// Two Pointers //
//////////////////

public class Solution {
    
    /*
        The Pillar from the left and right is the most important.
        It's the cornerstone.
        That's why we use two pointer. Left Pointer, right pointer 
     */
    public int trapRainWater(int[] heights) {

        /* Two pointers */
        int left = 0;
        int right = heights.length - 1;
        int res = 0;
        if (left >= right) return res; /* Edge */

        /* Start from head and tail */
        int leftmost = heights[left]; 
        int rightmost = heights[right];

        /* Until the pointers meet */
        while (left < right) {
            if (leftmost < rightmost) { /* Should start form a small one */
                left++; /* If the number keeps decreasing, go ahead */
                if (leftmost > heights[left]) {
                    res += leftmost - heights[left]; /* Update the res */
                } else {
                    leftmost = heights[left]; /* Move the leftmost */
                }
            } else {
                right--; /* Same for the right side */
                if (rightmost > heights[right]) {
                    res += rightmost - heights[right];
                } else {
                    rightmost = heights[right];
                }
            }
        }

        return res;
    }
};
