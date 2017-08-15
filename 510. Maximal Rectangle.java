/*
    Given a 2D boolean matrix filled with False and True, find the largest
    rectangle containing all True and return its area.
 */

/*
    Example
    Given a matrix:

    [
      [1, 1, 0, 0, 1],
      [0, 1, 0, 0, 1],
      [0, 0, 1, 1, 1],
      [0, 0, 1, 1, 1],
      [0, 0, 0, 0, 1]
    ]
    return 6.
 */

/*
    We can treat this problem as the follow up of the largest rectangle in
    histogram. All we need to do is to treat the matrix like a m-row array and
    plug in with the largestRectangleArea right way.

    VERY VERY VERY Important 

    Algorithm:

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
public class Solution {

    public int maximalRectangle(boolean[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[][] height = new int[m][n];
        /*  
            Traverse the matrix and convert the matrix to height array for each
            row. 
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!matrix[i][j]) {
                    height[i][j] = 0; /* Mark 0 for false */
                /* 
                    Mark 1's based on the previous row index except the first
                    row 
                 */
                } else { 
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            maxArea = Math.max(largestRectangleArea(height[i]) , maxArea);
        }
        return maxArea;
    }
    private int largestRectangleArea(int[] height) {
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

/* Algorithm walkthrough */

// matrix[][]
// [
//   [1, 1, 0, 0, 1],
//   [0, 1, 0, 0, 1],
//   [0, 0, 1, 1, 1],      m x n
//   [0, 0, 1, 1, 1],
//   [0, 0, 0, 0, 1]
// ]
// 
// 
// height[][]
// [
//   [1, 1, 0, 0, 1,  0],
//   [0, 2, 0, 0, 2,  0],
//   [0, 0, 1, 1, 3,  0],   m x (n + 1)
//   [0, 0, 2, 2, 4,  0],
//   [0, 0, 0, 0, 5,  0]
// ]        

        
////////////////
// DP Version //
////////////////




