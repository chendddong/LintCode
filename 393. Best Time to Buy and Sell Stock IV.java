/**
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 */

/*
    Design an algorithm to find the maximum profit. You may complete at most k transactions.

     Notice

    You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

    Example
    Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.
                    
    Challenge 
    O(nk) time.
 */

/**
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 */

/*
    Design an algorithm to find the maximum profit. You may complete at most k transactions.

     Notice

    You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

    Example
    Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.
                    
    Challenge 
    O(nk) time.
 */

/////////////////////////
// DP version Template //           AC
/////////////////////////

public class Solution {

    public int maxProfit(int k, int[] prices) {
        if (k == 0) return 0;

        /*
            因为最多买卖k次，如果k >= len / 2,那么说明，不相交的买卖次数最多能选出k段，否则的话，就会相交，如果相交了，我们合并成一次买卖就好了，所以我们把所有的prices[i]- prices[i - 1]大于0的都挑出来即可，这是一种贪心的思想。 
         */ 
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            }
            return profit;
        }

        /* 
            mustSell[i][j] means upto day i, there is at most j transactions,
            and with us selling the stock on that ith day, the max profit can
            we get.
         */ 
        int n = prices.length;
        int[][] mustSell = new int[n + 1][n + 1];
        int[][] globalBest = new int[n + 1][n + 1];

        /* Init */
        mustSell[0][0] = globalBest[0][0] = 0;
        for (int i = 1; i <= k; i++) /* No transactions on day 0 */ 
            mustSell[0][i] = globalBest[0][i] = 0;

        for (int i = 1; i < n; i++) {
            int gainorlose = prices[i] - prices[i - 1];
            /* On day i, with 0 transaction we get 0 profit */
            mustSell[i][0] = 0; 
            for (int j = 1; j <= k; j++) {
                mustSell[i][j] = Math.max(globalBest[i-1][j-1] + gainorlose, mustSell[i-1][j] + gainorlose);
                globalBest[i][j] = Math.max(globalBest[i-1][j], mustSell[i][j]);
            }
        }
        return globalBest[n - 1][k];
    }
}


////////////////////////
// Concise DP version //            come back for a walkthrough
////////////////////////

public class Solution {
    /**
     * dp[i, j] represents the max profit up until prices[j] using at most i
     * transactions. 
     * 
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[j] + dp[i-1, j]) { j in
     * range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, j] - prices[j]))
     *          
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * 
     * dp[i, 0] = 0; if there is only one price data point you can't make any
     * transaction.
     */    
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;
        
        /* If k >= n/2, then you can make maximum number of transactions. */
        if (k >= n/2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }
        
        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i-1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][n-1];
    }    
}
