/*
    Write an efficient algorithm that searches for a value in an m x n matrix, 
    return the occurrence of it.

    This matrix has the following properties:

    Integers in each row are sorted from left to right.
    Integers in each column are sorted from up to bottom.
    No duplicate integers in each row or column.
 */

/*
    Example
    Consider the following matrix:

    [
      [1, 3, 5, 7],
      [2, 4, 7, 8],
      [3, 5, 9, 10]
    ]
    Given target = 3, return 2.
 */

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        /* corner cases */
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        /* search from the bottom left */
        int n = matrix.length;
        int m = matrix[0].length;
        int x = n - 1;
        int y = 0;
        int count = 0;
        
        /* Draw and think*/

        while (x >= 0 && y < m) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                count++;
                x--;
                y++;
            }
        }

        return count;

    }
}



/*
    Thoughts:
    1. Time is O(m + n);
    
    More like a brain teaser So there should be no problem.
    Think about he possibility
 */
