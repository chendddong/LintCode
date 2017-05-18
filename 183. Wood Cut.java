/*
    Given n pieces of wood with length L[i] (integer array). Cut them into small
    pieces to guarantee you could have equal or more than k pieces with the same  
    length. What is the longest length you can get from the n pieces of wood?  
    Given L & k, return the maximum length of the small pieces.
 */

/*
    You couldn't cut wood into float length.
    If you couldn't get >= k pieces, return 0
    For L=[232, 124, 456], k=7, return 114.
    end is 228
 */

public class Solution{
    public int woodCut(int[] L, int k) {
        /* find the max piece */
        int max = 0;
        for (int i = 0; i < L; ++i) {
            max = Math.max(max, L[i]);
        }

        /* find the largest length that can cut the number of pieces needed */
        int start = 1;
        int end = max;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (count(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        /* find the largest one so starts with the lareger one */
        if (count(L, end) >= k) {
            return end;
        }

        if (count(L, start) >= k) {
            return start;
        }

        return 0;
    }

    private int count(int[] L, int length) {
        int sum = 0;
        for (int i = 0; i < L.length; ++i) {
            sum += L[i] / length;
        }

        return sum;
    }
}

/*
    The process and how to translate the thing into thought process
 */