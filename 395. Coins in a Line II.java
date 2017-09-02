/*
    There are n coins with different value in a line. Two players take turns to
    take one or two coins from left side until there are no more coins left. The player who take the coins with the most value wins.
 */

/*
    Could you please decide the first player will win or lose?

    Example
    Given values array A = [1,2,2], return true.

    Given A = [1,2,4], return false.
 */

public class Solution {
    /*
        • State:
        • dp[i] There are i coins left, the one who
        go first will get more values in the end

        • Function:
        • i is the number of coins
        • coin[n-i] means the ith coin to the end
        • dp[i] = max(min(dp[i-2], dp[i-3])+coin[n-i] ) ，
         (min(dp[i-3],dp[i-4])+coin[n-i]+coin[n-i+1] )

        • Initialize:
        • dp[0] = 0
        • dp[1] = coin[i-1]
        • dp[2] = coin[i-2] + coin[i-1]
        • dp[3] = coin[i-2] + coin[i-3] of course

        • Answer:
        • dp[n] > sum/2    
     */
    public boolean firstWillWin(int[] values) {
        int[] dp = new int[values.length + 1];
        boolean[] flag = new boolean[values.length + 1];
        int sum = 0;
        for (int value : values) 
            sum += value;

        return sum < 2 * MemorySearch(values.length, dp, flag, values);
    }

    private int MemorySearch(int n, int[] dp, boolean[] flag, int[] values) {
        if (flag[n])
            return dp[n];
        flag[n] = true;
        if (n == 0)
            dp[n] = 0;
        else if (n == 1)
            dp[n] = values[values.length - 1] ;
        else if (n == 2)
            dp[n] = values[values.length - 1] + values[values.length - 2];
        else if (n == 3)
            dp[n] = values[values.length - 2] + values[values.length - 3];
        else {
            dp[n] = Math.max(Math.min(MemorySearch(n-2, dp, flag, values),
                                      MemorySearch(n-3, dp, flag, values)) 
                  + values[values.length-n],
                             Math.min(MemorySearch(n-3, dp, flag, values),
                                      MemorySearch(n-4, dp, flag, values))
                  + values[values.length-n] + values[values.length-n+1]
                );
        }

        return dp[n];
    }
}
