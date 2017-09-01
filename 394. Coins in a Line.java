/*
    There are n coins in a line. Two players take turns to take one or two
    coins from right side until there are no more coins left. The player who
    take the last coin wins.
 */

/*
    Could you please decide the first play will win or lose?

    Example
    n = 1, return true.

    n = 2, return true.

    n = 3, return false.

    n = 4, return true.

    n = 5, return true.

    Challenge 
    O(n) time and O(1) memory
 */

//////////////////////////////////////
// DP Drawing search tree bottom up //
//////////////////////////////////////

public class Solution {
    // int[] dp; we can put it in here in case it goes too deep
    public boolean firstWillWin(int n) {
        int[] dp = new int[n + 1];
        return MemorySearch(n, dp);
    }
    private boolean MemorySearch(int n, int[] dp) {
        if (dp[n] != 0)
            if (dp[n] == 1)
                return false;
            else /* dp[n] == 2 */
                return true;

        if (n <= 0) dp[n] = 1;
        else if (n == 1) dp[n] = 2;
        else if (n == 2) dp[n] = 2;
        else if (n == 3) dp[n] = 1;
        else 
            /* Take care of these index by drawing the search tree*/
            if ((MemorySearch(n - 2, dp) && MemorySearch(n - 3, dp)) ||
                 MemorySearch(n - 3, dp) && MemorySearch(n - 4, dp)) {
                dp[n] = 2;
            } else {
                dp[n] = 1;
            }
    }
}

/////////////////////////////
// Memory Search  top down //            StackOverflow
/////////////////////////////

public class Solution {

    public boolean firstWillWin(int n) {
        boolean []dp = new boolean[n+1];
        boolean []flag = new boolean[n+1];
        return MemorySearch(n, dp, flag);
    }
    boolean MemorySearch(int i, boolean []dp, boolean []flag) {
        if(flag[i] == true) {
            return dp[i];
        }
        if(i == 0) {
            dp[i] = false;
        } else if(i == 1) {
            dp[i] = true;
        } else if(i == 2) {
            dp[i] = true;
        } else { /* Too deep */
            /* dp[i] 现在还剩i个硬币，现在当前取硬币的人最后输赢状况 */ 
            dp[i] = !MemorySearch(i-1, dp, flag) || !MemorySearch(i-2, dp,
                flag); 
        }
        flag[i] = true;
        return dp[i];
    }
}

/////////////////
// DP top down //           Not easy to come up
/////////////////

public class Solution {

    public boolean firstWillWin(int n) {
        /* Base case / Init */
        if (n == 0)
            return false;
        else if (n == 1)
            return true;
        else if (n == 2)
            return true;
           
        /* dp[i] 现在还剩i个硬币，现在当前取硬币的人最后输赢状况 */ 
        boolean []dp = new boolean[n+1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        for (int i = 3; i <= n; i++) 
            dp[i] = !dp[i - 1] || !dp[i - 2];
            
        return dp[n];
    }
}


