/*
    There is an integer array which has the following features:

    The numbers in adjacent positions are different.
    A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
    We define a position P is a peek if:

    A[P] > A[P-1] && A[P] > A[P+1]
    Find a peak element in this array. Return the index of the peak.
*/

/*
     Notice

    The array may contains multiple peeks, find any of them.

    Example
    Given [1, 2, 1, 3, 4, 5, 7, 6]

    Return index 1 (which is number 2) or 6 (which is number 7)
 */

/////////////////////////////////////////////////////
// Solution 1 Love & Understanding & Possibilities //
/////////////////////////////////////////////////////


class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid - 1] == A[mid + 1] && A[mid - 1] < A[mid] && A[mid + 1] <
                A[mid]) {
                return mid;
            } else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return A[start] > A[end] ? start : end;
    }
}

/////////////////////////////////////////
// Solution 2 Control the Border a bit //
/////////////////////////////////////////



class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        /* Restrict start and end so there are at least three elements to
        compare with */
        int start = 1, end = A.length-2; 
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]) {
                end = mid;
            } else if(A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[start] < A[end]) {
            return end;
        } else { 
            return start;
        }
    }
}
