/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 */


/*
    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.

     Notice

    This problem have two method which is Greedy and Dynamic Programming.

    The time complexity of Greedy method is O(n).

    The time complexity of Dynamic Programming method is O(n^2).

    We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.

    Have you met this question in a real interview? Yes
    Example
    A = [2,3,1,1,4], return true.

    A = [3,2,1,0,4], return false.

    // axis dp // 

 */

///////////////
// Template  //
///////////////

public class Solution {

    /*
        Time complexity : O(n ^ 2). There are two loops obviously
        Space complexity : O(n);
     */

    public boolean canJump(int[] A) {
        /* These corner cases are tricky */
        if (A == null || A.length == 0) return false; // true
        if (A.length == 1) return true;
        if (A[0] == 0) return false;

        /* State : dp[i] represents if the we can jump to this point */
        boolean[] dp = new boolean[A.length];
        /* Init : set the first number dp[0] = true */
        dp[0] = true;
        /* Function */
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] >= i - j) {
                    dp[i] = true;
                    break;
                }                
            }
            if (!dp[i]) return false; /* Can't move anymore */
        }
        
        /* Answer */
        return dp[A.length - 1];
    }
}
    /* Walkthrough */
    //  0  1  2  3  4          i
    // [2, 3, 1, 1, 4]         A[i]
    //  1  1  0  0  0          dp[i]

////////////////////////
// A cleaner version  //
////////////////////////

public class Solution {
    public boolean canJump(int[] A) {
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
        
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                /* The dp[j] must be true to jump further */
                if (dp[j] && j + A[j] >= i) { 
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[A.length - 1];
    }
}


////////////
// Greedy //
////////////

public class Solution {

    /*
        Once we have our code in the bottom-up state, we can make one final, important observation. From a given position, when we try to see if we can jump to a GOOD position, we only ever use one - the first one (see the break statement). In other words, the left-most one. If we keep track of this left-most GOOD position as a separate variable, we can avoid searching for it in the array. Not only that, but we can stop using the array altogether.

        Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index (currPosition + nums[currPosition] >= leftmostGoodIndex). If we can reach a GOOD index, then our position is itself GOOD. Also, this new GOOD position will be the new leftmost GOOD index. Iteration continues until the beginning of the array. If first position is a GOOD index then we can reach the last index from the first position.

        To illustrate this scenario, we will use the diagram below, for input array nums = [9, 4, 2, 1, 0, 2, 0]. We write G for GOOD, B for BAD and U for UNKNOWN. Let's assume we have iterated all the way to position 0 and we need to decide if index 0 is GOOD. Since index 1 was determined to be GOOD, it is enough to jump there and then be sure we can eventually reach index 6. It does not matter that nums[0] is big enough to jump all the way to the last index. All we need is one way.


        Time complexity : O(n). We are doing a single pass through the nums array, hence n steps, where n is the length of array nums.

        Space complexity : O(1). We are not using any extra memory.

        Index   0   1   2   3   4   5   6
        nums    9   4   2   1   0   2   0
        memo    U   G   B   B   B   G   G

     */    
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}






