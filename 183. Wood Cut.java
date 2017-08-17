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

public class Solution {

    public int woodCut(int[] L, int k) {

        /* Narrow down the binary search interval */
        int start = 1;
        int end = findMax(L);
        
        /* Template */
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (count(L, mid) >= k) { /* Check */
                start = mid;
            } else {
                end = mid;
            }
        }
        
        /* Need the largest one so we starts with the larger one */ 
        if (count(L, end) >= k) {
            return end;
        }
        
        if (count(L, start) >= k) {
            return start;
        }
        
        return 0;
    }
    private int findMax(int[] L) {
        int max = 0;
        for (int wood : L) {
            max = Math.max(wood, max);
        }
        return max;
    }
    private int count(int[] L, int pc) {
        int count = 0;
        for (int wood : L) {
            count += wood / pc;
        }
        return count;
    }
};