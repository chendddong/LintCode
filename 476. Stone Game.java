/**
 * There is a stone game.At the beginning of the game the player picks n piles
 * of stones in a line.
 */

/*
    The goal is to merge the stones in one pile observing the following rules:

    At each step of the game,the player can merge two adjacent piles to a new pile.
    The score is the number of stones in the new pile.
    You are to determine the minimum of the total score.

    Example
    For [4, 1, 1, 4], in the best solution, the total score is 18:

    1. Merge second and third piles => [4, 2, 4], score +2
    2. Merge the first two piles => [6, 4]，score +6
    3. Merge the last two piles => [10], score +10
    Other two examples:
    [1, 1, 1, 1] return 8
    [4, 4, 5, 9] return 43
 */

////////////////////////////////////////////////////////////////////
// Things we need to take care of in the interval DP              //
//     1. We want to get the max/min/count of a certain interval. //
//     2. The function should be updated using the interval.      //
//     3. Dealing with the problem from big to small.             //
////////////////////////////////////////////////////////////////////
    

public class Solution {
    /*
        Time complexity : O(n ^ 3)
        When to use memory search instead of the for loop dp:
            1. There is an interval 
            2. There is a game problem(who's gonna win)
     */
    public int stoneGame(int[] A) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;

        /* 
            State : dp[i][j] means combine the ith and jth stone, the smallest
            cost that we can achieve.
        */
        int[][] dp = new int[n][n];
        int[][] visited = new int[n][n];

        /* Init */
        for (int i = 0; i < n; i++)
            dp[i][i] = 0; /* No merge no cost */

        /* Preparation: the sum from i to j */
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            sum[i][i] = A[i];
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }

        return memorySearch(0, n-1, dp, visited, sum);
    }

    int memorySearch(int l, int r, int[][] dp, int[][] visited, int[][]sum) {
        /* Check the cache */
        if (visited[l][r] == 1)
            return dp[l][r];

        if (l == r) { /* Init : self to self */
            visited[l][r] = 1;
            return dp[l][r];
        }
            

        dp[l][r] = Integer.MAX_VALUE;

        for (int k = l; k < r; k++)
            dp[l][r] = Math.min(dp[l][r], memorySearch(l,k,dp,visited,sum) + 
                                          memorySearch(k+1,r,dp,visited,sum) +
                                          sum[l][r]);
        visited[l][r] = 1; /* Mark the cache */
        return dp[l][r]; /* Return the search result */
    }
}


/////////////////
// For loop DP //
/////////////////

public class Solution {

    public int stoneGame(int[] A) {

        if(A.length == 0) return 0;
        
        int n = A.length;

        /* 
            State : dp[i][j] means combine the ith and jth stone, the smallest
            cost that we can achieve.
        */
        int[][] dp = new int[n][n];
        int[] sums = new int[n + 1];
        sums[0] = 0;

        /* Init */
        for(int i = 0;i < n; i++){
            for(int j = i; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE; /* No self merge */ 
            }
        }

        /* Init 2 and prepare */
        for(int i = 0; i < A.length; i++){
            dp[i][i] = 0;
            sums[i + 1] = sums[i] + A[i];
        }
        
        return search(0, A.length - 1, dp, sums);
    }
    
    private int search(int start, int end, int[][] dp, int[] sums){
        /* Check the cache */
        if(dp[start][end] != Integer.MAX_VALUE){
            return dp[start][end];
        }

        /* Same as the memory search one */
        int min = Integer.MAX_VALUE;
        for(int k = start; k < end; k++){
            int left = search(start,k,dp,sums);
            int right = search(k + 1, end, dp, sums);
            int now = sums[end + 1]- sums[start];
            min = Math.min(min,left + right + now);
        }
        dp[start][end]=min;
        return min;
    }
}
