public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // [1,1] [2,2] [3,3] [4,5] [5,8] [6, 13]
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
/* 
takes too much time or say stacks
*/


public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int last = 1, lastlast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }
}

/*
sequence matters

now = last + lastlast;
lastlast = last;
last = now;

*/