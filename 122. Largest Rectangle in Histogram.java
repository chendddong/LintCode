/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the 
 * histogram.
 */

/*
    Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

    histogram

    The largest rectangle is shown in the shaded area, which has area = 10 unit.

    Example
    Given height = [2,1,5,6,2,3],
    return 10.
 */

/////////////////
// Brute Force //               TLE
/////////////////

/*
    Firstly, we need to take into account the fact that the height of the rectangle formed between any two bars will always be limited by the height of the shortest bar lying between them which can be understood by looking at the figure below:

    Thus, we can simply start off by considering every possible pair of bars and finding the area of the rectangle formed between them using the height of the shortest bar lying between them as the height and the spacing between them as the width of the rectangle. We can thus, find the required rectangle with the maximum area.

    Time: O(n^3)
    Space: constant
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) { /* Start from j = i*/
                int minH = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    minH = Math.min(minH, heights[k]);
                }
                maxArea = Math.max(maxArea, minH * (j - i + 1));
            }
        }
        return maxArea;
    }
}

////////////////////////
// Better brute force //            TLE
////////////////////////

/*
    We can do one slight modification in the previous approach to optimize it to some extent. Instead of taking every possible pair and then finding the bar of minimum height lying between them every time, we can find the bar of minimum height for current pair by using the minimum height bar of the previous pair.

    Time: O(n)
    Space : constant
 */

public class solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minH = Integer.MAX_VALUE; /* Modification */
            for (int j = i; j < heights.length; j++) {
                minH = Math.min(minH, heights[j]); /* Omit the 3rd loop */
                maxArea = Math.max(maxArea, minH * (j - i + 1));
            }
        }
        return maxArea;
    }
}

/*
    If we use two pointers to solve this problem. The time complexity would be
    O(n ^ 2). So We should use Increasing stack(Decreasing stack) to solve this
    problem.

 */

//////////////////////
// Increasing Stack //
//////////////////////

/*
    The running time for this is O(n) since the elements only in and out for 
    twice, so we can say it's O(n);

    Space : O(n) stack is used
 */
public class Solution {

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i <= height.length; i++) {
            int cur = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && cur <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}

/* 
    The stack can only store value that is larger than the previous
    value, and if it is not the case, we had dealt with it early.
    
    Traverse the index from 0 to length, assign cur value to the index
    value, the last index's value is -1 or Integer.MIN_VALUE;
    
    if stack is not empty and cur value less than the height[peek()],
        h = height[pop()] from the stack
        w = i when stack is empty else w = i - peek() - 1;
        update the max each time we are inside

    Each time we push the index to the stack.
 */





