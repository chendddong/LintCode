/*
    Given n books and the ith book has A[i] pages. You are given k people to copy
    the n books.

    n books list in a row and each person can claim a continuous range of the n
    books.   For example one copier can copy the books from ith to jth continuously, 
    but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).

    They start copying books at the same time and they all cost 1 minute to
    copy 1 page of a book. What's the best strategy to assign books so that the slowest copier can finish at earliest time?
 */

/*
    Example
    Given array A = [3,2,4], k = 2.

    Return 5( First person spends 5 minutes to copy book 1 and book 2 and
    second person spends 4 minutes to copy book 3. )

 */

///////////////////////////////////////////////////////////////////////////////
    // • When to binary the answer?
    //     1. Most / Least key word
    //     2. There is a threshold say, yes or no. There is a critical point
///////////////////////////////////////////////////////////////////////////////



///////////////////
// Binary Search //
///////////////////

/* 
    this version cost O(n log m) where n is the number of books and m is the
    sum of the pages. So if the m is extremely large, the time complexity would
    go up quickly.
*/

public class Solution {

    public int copyBooks(int[] pages, int k) {
        if (pages.length == 0) {
            return 0;  
        }
        
        /* Find the search interval */
        int total = 0;
        int max = pages[0];
        for (int i = 0; i < pages.length; i++) {
            total += pages[i];
            if (max < pages[i]) {
                max = pages[i];
            }
        }
        
        int start = max; /* At least we have to take this much time */
        int end = total; 
        
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (countCopiers(pages, mid) > k) { /* Check */
                start = mid;
            } else {
                end = mid;
            }
        }
        
        /* start = 4 end = 5 */

        if (countCopiers(pages, start) <= k) {
            return start;
        }
        
        return end;
    }
    
    private int countCopiers(int[] pages, int limit) {
        if (pages.length == 0) {
            return 0;
        }
        
        int copiers = 1;
        /* 
            limit is always >= pages[0] since the smallest limit is the max
            number in the pages 
         */
        int sum = pages[0]; 
        for (int i = 1; i < pages.length; i++) {
            if (sum + pages[i] > limit) {
                copiers++;
                sum = 0;
            }
            sum += pages[i];
        }
        
        return copiers;
    }
}

/////////////////////////
// Dynamic Programming //           Comeback for this solution later
/////////////////////////


public class Solution {

    int [][]init(int []A)  
    {  
        int n = A.length;
        int [][]w = new int [n+2][n+2];
        for(int i = 1; i <= n; i++) {  
            for(int j = i+1; j <= n; j++)  
            {  
                for(int k = i;k <= j;++k) {
                    w[i][j] += A[k - 1];  
                }
            } 
        }
        return w; 
    } 
    
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int [][]w = init(pages);
        int [][]dp = new int[n + 2][k + 2];
        int [][]s = new int[n + 2][k + 2];
        
        int ans = Integer.MIN_VALUE;
        if(n <= k) {
            for(int i = 0; i < n; i++) 
             ans = Math.max(ans, pages[i]);
            return ans;
        }
        
        for(int i = 0;i <= n;++i)  {
            dp[i][1] = w[1][i];
            
        }
        
        for(int nk = 2; nk <= k; nk++) {
            
            for(int i = nk; i <= n; i++) {
                dp[i][nk] = Integer.MAX_VALUE;
                for(int j = 0; j < i; j++) {  
                    if(dp[i][nk] == Integer.MAX_VALUE || dp[i][nk] > Math.max(dp[j][nk-1], w[j+1][i]))  
                        dp[i][nk] = Math.max(dp[j][nk-1], w[j+1][i]);   
                }  
            }
        }
        return dp[n][k];
    }
}