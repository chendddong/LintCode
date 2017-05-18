/**
 * Given a target number and an integer array A sorted in ascending order, find
 * the index i in A such that A[i] is closest to the given target.
 */



/*
    Return -1 if there is no element in the array.

    There can be duplicate elements in the array, and we can return any of   the
    indices with same value.
 */


///////////////////////////////////////
// Solution 1 Brute Force Binary Abs //
///////////////////////////////////////


public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    
    // [1,2,3,4,5,6,99] 59
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else { /* diff = 0 */
                return mid;
            }
        }

        return Math.abs(A[start] - target) <  Math.abs(A[end] - target) ? start : end;
    }
}



/////////////////////////
// Solution 2 Too long //
/////////////////////////


public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int index = firstIndex(A, target);
        if (index == 0) {
            return 0;
        }
        if (index == A.length) {
            return A.length - 1;
        }

        if (target - A[index - 1] < A[index] - target) {
            return index - 1;
        }
        return index;
    }
    
    private int firstIndex(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] >= target) {
            return start;
        }
        if (A[end] >= target) {
            return end;
        }
        return A.length;
    }
}