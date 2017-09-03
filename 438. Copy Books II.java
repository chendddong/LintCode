/*
    Given n books( the page number of each book is the same) and an array of
    integer with size k means k people to copy the book and the i th integer is the time i th person to copy one book). You must distribute the continuous id books to one people to copy. (You can give book A[1],A[2] to one people, but you cannot give book A[1], A[3] to one people, because book A[1] and A[3] is not continuous.) Return the number of smallest minutes need to copy all the books.

 */

/*
    Example
    Given n = 4, array A = [3,2,4], .

    Return 4( First person spends 3 minutes to copy book 1, Second person spends 4 minutes to copy book 2 and 3, Third person spends 4 minutes to copy book 4. )
 */

/////////////////
// DP template //               Comeback later
/////////////////

/*
    dp[i][j] means upto the ith person, the min amount of time to copy j books.
 */

public class Solution {

    public int copyBooksII(int n, int[] times) {
        int k = times.length;
        int[][] dp = new int[2][n+1];

        for (int j = 0 ; j <= n; ++j) {
            dp[0][j] = j * times[0];
        }

        for (int i = 1; i < k; ++i) {
            for (int j = 1; j <= n; ++j) {
                int a = i%2;
                int b = 1-a;
                
                dp[a][j] = Integer.MAX_VALUE;
                for (int l = 0; l <= j; ++l) {
                    if (dp[b][j-l] > times[i] * l) {
                        dp[a][j] = Math.min(dp[a][j], dp[b][j-l]);
                    } else {
                        dp[a][j] = Math.min(dp[a][j], times[i] * l);
                        break;
                    }
                }
                
            }
        }

        return f[(k-1)%2][n];
    }
}


///////////////////////////
// Binary Search Version //             73% Comeback later
///////////////////////////

public class Solution {

    public int copyBooksII(int n, int[] times) {
        if (times.length == 0 || n <= 0) return Integer.MAX_VALUE;

        /* Find the search interval */
        int start = 0;
        int end = Integer.MAX_VALUE;
        
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (countBook(times, mid) >= n) 
                end = mid;
            else
                start = mid;
        }

        if (countBook(times, start) >= n)
            return start;

        return end;
    }

    private int countBook(int[] times, int totalTime) {
        int book = 0;
        for (int time : times) 
            book += totalTime / time;

        return book;
    }
}   



