/*
    Given a sorted array of n integers, find the starting and ending position  
    of a given target value.

    If the target is not found in the array, return [-1, -1].
 */


/*
    Example
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4].
 */


public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A.length == 0) {
            return new int[]{-1, -1};
        }
        /* Find the first occurence and then the last */

        /* Make a list of length 2 */       
        int start, end, mid;
        int[] bound = new int[2]; 
        
        // search for left bound
        start = 0; 
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            bound[0] = start;
        } else if (A[end] == target) {
            bound[0] = end;
        } else {
            /* Mind this circumstance*/
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        // search for right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        } else {
            /* Also this one*/
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        return bound;
    }
}
