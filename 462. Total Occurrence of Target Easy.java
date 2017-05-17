/**
 * Given a target number and an integer array sorted in ascending order. Find
 * the total number of occurrences of target in the array.
 */

/*
    Example
    Given [1, 3, 3, 4, 5] and target = 3, return 2.

    Given [2, 2, 3, 4, 6] and target = 4, return 1.

    Given [1, 2, 3, 4, 5] and target = 6, return 0.
*/

////////////////////////////////////////////////
// Solution 1 Find first Index, loop the rest //
////////////////////////////////////////////////

/*
    Too slow wrost case is O(n)
 */
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        /* Find the firt target and for loop the rest, increment the count */
        
        /* corner cases */
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (A[start] == target) {
            return findOccurrence(A, start, target);
        }
        
        if (A[end] == target) {
            return findOccurrence(A, end, target);
        }
        
        return 0;
    }
    
    private int findOccurrence(int[] A, int firstIndex, int target) {
        int count = 1;
        for (int i = firstIndex + 1; i < A.length; ++i) {
            if (A[i] == target) {
                count++;
            }
        }
        return count;
    }
}

/////////////////////////////////////
// Solution 2 binary search twice  //
/////////////////////////////////////

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        /* Find the firt target and for loop the rest, increment the count */
        
        /* corner cases */
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        /* First Occurrence*/
        if (A[start] == target) {
            return findLatOccurrence(A, start, target) - start + 1;
        }
        
        if (A[end] == target) {
            return findLatOccurrence(A, end, target) - end + 1;
        }
        
        return 0;
    }
    /* Find the last Occurrence*/
    private int findLatOccurrence(int[] A, int firstIndex, int target) {
        int start = firstIndex;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }  
        
        if (A[end] == target) {
            return end;
        }
        
        if (A[start] == target) {
            return start;
        }
        
        return start;
    }
    
}
