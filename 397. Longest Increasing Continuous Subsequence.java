/**
 * Give an integer array，find the longest increasing continuous subsequence in
 * this array.
 */

/*
    An increasing continuous subsequence:

    Can be from right to left or from left to right.
    Indices of the integers in the subsequence should be continuous.
     Notice

    O(n) time and O(1) extra space.

    Example
    For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

    For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.

 */

////////////////////
// Traverse twice //
////////////////////

public class Solution {

    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int answer = 1;
        
        /* Left to right */
        int length = 1;
        for (int i = 1; i < n; i++) {
            
            if (A[i] > A[i - 1]) /* Increasing */
                length ++;
            else 
                length = 1;
            
            answer = Math.max(answer, length);
        }
        
        /* Right to left */
        length = 1;
        for (int i = 1; i < n; i++) {
            
            if (A[i] < A[i - 1]) /* Decreasing */
                length ++;
            else 
                length = 1;
            
            answer = Math.max(answer, length);
        }
        
        return answer;
    }
}

////////////////////////////
// DP Not so quick though //
////////////////////////////

public class Solution {

    public int longestIncreasingContinuousSubsequence(int[] A) {
        int n = A.length;
        int num1 = LIS(A);
        int num2 = LIS(reverse(A));
        return Math.max(num1, num2);
    }
    private int LIS(int[] A) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        /* dp[i] means the LIS at the ith position increasingly */
        int[] dp = new int[n];

        /* Init */
        for (int i = 0; i < n; i++) 
            dp[i] = 1;

        /* Function */
        int res = 1; /* At least there is one */
        for (int i = 1; i < n; i++) {
            if (A[i - 1] < A[i])
                dp[i] = dp[i - 1] + 1;
            res = Math.max(dp[i], res); /* Update */
        }

        return res;
    }
    private int[] reverse(int[] A) { /* Reverse the array manually */
        int i = 0;
        int j = A.length - 1;
        int temp = 0;

        while (i < j) {
            temp = A[i];
            A[i++] = A[j];
            A[j--] = temp;
            // i++;
            // j--;
        }

        return A;
    }
}