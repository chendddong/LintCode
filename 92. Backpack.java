/**
 * Given n items with size Ai, an integer m denotes the size of a backpack. How
 * full you can fill this backpack?
 */

/*
     Notice

    You can not divide any item into small pieces.

    Example
    If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

    You function should return the max size we can fill in the given backpack.

    Challenge 
    O(n x m) time and O(m) memory.

    O(n x m) memory is also acceptable if you do not know how to optimize memory.
 */


/////////////////////////////////////////////////////////////
// The specialty of backpack DP                            //
//     1. Use the value as the DP's dimension              //
//     2. DP process is to fill out the big array          //
//     3. We can use rolling array to optimize the problem //
/////////////////////////////////////////////////////////////

public class Solution {
    /* Time complexity O(n*S) */
    public int backPack(int m, int[] A) {
        /* State : 0 to ith item, can we pick some of those to get S(value) */
        boolean[][] dp = new boolean[A.length + 1][m + 1];

        /* 
            Init : 
                f[i][0] = true
                f[0][1...target] = false
         */
        dp[0][0] = true;

        /* Function */
        for (int i = 1; i <= A.length; i++) 
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]])
                    dp[i][j] = true;
            }

        /*
            Answer: check all the f[n][j]
         */
        for (int i = m; i >= 0; i--)
            if (dp[A.length][i])
                return i;

        return 0;
    }
}






 