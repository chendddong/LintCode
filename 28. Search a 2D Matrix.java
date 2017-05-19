/*
    Write an efficient algorithm that searches for a value in an m x n matrix.

    This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
 */


/*
    Example
    Consider the following matrix:

    [
        [1, 3, 5, 7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
    ]

    Given target = 3, return true.
 */

////////////////////////////////////////
// Solution 1 Using One Bianry Search //
////////////////////////////////////////

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0;
        int end = n * m - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] < targte) {
                start = mid;
            } else if (matrix[row][col] > target) {
                end = mid;
            } else {
                return true;
            }
        }

        int row = start / m;
        int col = start % m;
        if (matrix[row][col] == target) {
            return true;
        }

        int row = end / m;
        int col = end % m;
        if (matrix[row][col] == target) {
            return true;
        }

        return false;

    }
}


///////////////////////////////////////////////
// Solution 2 Search the Row and then Column //
///////////////////////////////////////////////


public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     * 
     * Binary Search twice
     * 
     */
     
     
     
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0] == null) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        
        /* find the row Index */
        int start = 0, end = row - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }
        
        /* find the column index */
        start = 0;
        end = column - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (matrix[row][start] == target) {
            return true;
        } else if (matrix[row][end] == target) {
            return true;
        } 
        return false;
    }
}
