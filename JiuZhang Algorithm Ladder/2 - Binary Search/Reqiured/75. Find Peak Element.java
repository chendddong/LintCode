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

//////////////////////////////////////////
// Love & Understanding & Possibilities //
//////////////////////////////////////////

/*
    Note that PEAK could be more than 1 in an array, whereas there is only 1
    MAX.
 */
class Solution {

    public int findPeak(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid - 1] == A[mid + 1] && A[mid - 1] < A[mid] && A[mid + 1] <
                A[mid]) { /* Peak is the mid */
                return mid;
            /* Increasing, go right */
            } else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                start = mid;
            } else { /* Decreasing, go left */
                end = mid;
            }
        }
        
        return A[start] > A[end] ? start : end; /* The larger index*/
    }
}

/////////////////////////////////////////
// Solution 2 Control the Border a bit //
/////////////////////////////////////////

class Solution {

    public int findPeak(int[] A) {
        /* 
            Restrict start and end so there are at least three elements to
            compare with.
         */
        int start = 1, end = A.length - 2; 
        while (start + 1 <  end) {
            int mid = (start + end) / 2;
            if (A[mid] < A[mid - 1]) {  /* Decreasing, go left */
                end = mid;
            } else if(A[mid] < A[mid + 1]) {  /* Increasing, go right */
                start = mid;
            } else {
                start = mid; // end = mid
            }
        }

        return A[start] > A[end] ? start : end; /* The larger index */
    }
}
