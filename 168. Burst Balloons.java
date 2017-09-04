/*
    Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
    number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 */

/*
    Find the maximum coins you can collect by bursting the balloons wisely.
    - You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
    - 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

    Example
    Given [4, 1, 5, 10]
    Return 270

    nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20
    nums = [4, 5, 10]    burst 5, get coins 4 * 5 * 10 = 200 
    nums = [4, 10]       burst 4, get coins 1 * 4 * 10 = 40
    nums = [10]          burst 10, get coins 1 * 10 * 1 = 10

    Total coins 20 + 200 + 40 + 10 = 270
 */

public class Solution {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        /* State : dp[i][j] means the max value to burst balloon i to j */
        /* n + 2 is for 2 dummies */
        int[][] dp = new int[n + 2][n + 2]; 
        int[][] visited = new int[n + 2][n + 2];
        int[] arr = new int[n + 2]; 

        /* Init */
        for (int i = 1; i <= n; i++) 
            arr[i] = nums[i - 1];
        arr[0] = 1;
        arr[n + 1] = 1;

        return search(dp, visited, arr, 1, n);
    }
    private int search(int[][] dp, int[][] visited, int[] arr, int l, int r) {
        /* Check cache */
        if (visited[l][r] == 1)
            return dp[l][r];

        int res = 0;
        /* Draw the search tree if necessary */
        for (int k = l; k <= r; k++) {
            /* If there is only one element left */            
            int mid = arr[l - 1] * arr[k] * arr[r + 1];
            
            int left = search(dp, visited, arr, l, k - 1);
            int right = search(dp, visited, arr, k + 1, r);
            /* The total cost for that certain interval */
            res = Math.max(res, left + mid + right);
        }

        visited[l][r] = 1; /* Mark */
        dp[l][r] = res; /* Cache */

        return res;
    }
}
