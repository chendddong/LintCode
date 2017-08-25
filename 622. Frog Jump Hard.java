/*
    A frog is crossing a river. The river is divided into x units and at each unit
    there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

    Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

    If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

     Notice

    The number of stones is ≥ 2 and is < 1100.
    Each stone's position will be a non-negative integer < 2^31.
    The first stone's position is always 0.
 */

/*
    Given stones = [0,1,3,5,6,8,12,17]

    There are a total of 8 stones.
    The first stone at the 0th unit, second stone at the 1st unit,
    third stone at the 3rd unit, and so on...
    The last stone at the 17th unit.

    Return true. The frog can jump to the last stone by jumping 
    1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
    2 units to the 4th stone, then 3 units to the 6th stone, 
    4 units to the 7th stone, and 5 units to the 8th stone.

    Given stones = `[0,1,2,3,4,8,9,11]`

    Return false. There is no way to jump to the last stone as 
    the gap between the 5th and 6th stone is too large.
 */

/////////////////////////////////
// Use HashMap as the dp array //
/////////////////////////////////

public class Solution {
    /*
        Time complexity : O(n^2) Two nested loops are there
        Space complexity : O(n^2) Hashmap size can grow upto n^2
     */
    public boolean canCross(int[] stones) {
        /*  
            Init a hash map with a size as the dp 
            State: dp.get(i) are the jump sizes we can use
         */
        HashMap<Integer, HashSet<Integer>> dp = new HashMap<>(stones.length);
        for (int i = 0; i < stones.length; i++) {
            dp.put(stones[i], new HashSet<Integer>());
        }

        /* Init */
        dp.get(0).add(0);

       /* Function */
        for (int i = 0; i < stones.length; i++) {
            for (int k : dp.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) { /* 3 steps */
                    if (step > 0 && dp.containsKey(stones[i] + step)) {
                        dp.get(stones[i] + step).add(step);
                    }
                }
            }
        }

        /* Answer */
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}

/* 
    Come back later for this walk through.

    The dp map is: 
    ++++++++++++++
    dp[0] -> 0, 
    dp[1] -> 1, 
    dp[2] -> 2, 
    dp[3] -> 2, 
    dp[4] -> 1, 3, 
    dp[5] -> 2, 3, 
    dp[6] -> 4,
    ++++++++++++++    
*/

///////////////////////////
// Brute Force Recursive //         TLE
///////////////////////////
/*
    In the brute force approach, we make use of a recursive function canCrosscanCross which takes the given stone array, the current position and the current jumpsize as input arguments. We start with currentPosition=0currentPosition=0 and jumpsize=0. Then for every function call, we start from the currentPositioncurrentPosition and check if there lies a stone at (currentPostion + newjumpsize)(currentPostion+newjumpsize), where, the newjumpsize could be jumpsize, jumpsize+1 or jumpsize-1jumpsize−1. In order to check whether a stone exists at the specified positions, we check the elements of the array in a linear manner. If a stone exists at any of these positions, we call the recursive function again with the same stone array, the currentPositioncurrentPosition and the newjumpsize as the parameters. If we are able to reach the end of the stone array through any of these calls, we return true to indicate the possibility of reaching the end.

    Time complexity : O(3^n) because of the recursion
    Space complexity : O(n). Recursion of depth n is used.    
 */
    
public class Solution {
    public boolean canCross(int[] stones) {
        return can_Cross(stones, 0, 0);
    }
    public boolean can_Cross(int[] stones, int ind, int jumpsize) {
        for (int i = ind + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[ind];
            if (gap >= jumpsize - 1 && gap <= jumpsize + 1) { /* O(n^3) */
                if (can_Cross(stones, i, gap)) {
                    return true;
                }
            }
        }

        return ind == stones.length - 1; /* See if we can reach there */
    }
}

//////////////////////////////////
// Recursion with binary Search //          TLE
//////////////////////////////////

/*
    In the previous brute force approach, we need to find if a stone exists at (currentPosition + new jumpsize)(currentPosition+newjumpsize), where newjumpsize] could be either of jumpsize-1, jumpsize or jumpsize+1. But in order to check if a stone exists at the specified location, we searched the given array in linearly. To optimize this, we can use binary search to look for the element in the given array since it is sorted. Rest of the method remains the same.

    Time complexity : O(3^n) because of the recursion
    Space complexity : O(n). Recursion of depth n is used.   
 */
public class Solution {
    public boolean canCross(int[] stones) {
        return can_Cross(stones, 0, 0);
    }
    public boolean can_Cross(int[] stones, int ind, int jumpsize) {
        if (ind == stones.length - 1) { /* Edge */
            return true;
        }
        /* Find possible next round rock */ 
        int ind1 = Arrays.binarySearch(stones, ind + 1, stones.length, stones
            [ind] + jumpsize); /* k */
        if (ind1 >= 0 && can_Cross(stones, ind1, jumpsize)) {
            return true;
        }
        int ind2 = Arrays.binarySearch(stones, ind + 1, stones.length, stones
            [ind] + jumpsize - 1); /* k - 1 */
        if (ind2 >= 0 && can_Cross(stones, ind2, jumpsize - 1)) {
            return true;
        }
        int ind3 = Arrays.binarySearch(stones, ind + 1, stones.length, stones
            [ind] + jumpsize + 1); /* k + 1 */
        if (ind3 >= 0 && can_Cross(stones, ind3, jumpsize + 1)) {
            return true;
        }
        return false;
    }
}

///////////////////
// Memory search //
///////////////////

public class Solution {

    /*
        Another problem with above approaches is that we can make the same
        function calls coming through different paths e.g. For a given currentIndexcurrentIndex, we can call the recursive function canCrosscanCross with the jumpsize, say n. This n could be resulting from previous jumpsize being n-1,n or n+1. Thus, many redundant function calls could be made prolonging the running time. This redundancy can be removed by making use of memorization. We make use of a 2-d memo array, initialized by −1 s, to store the result returned from a function call for a particular currentIndexcurrentIndex and jumpsize. If the same currentIndexcurrentIndex and jumpsize happens is encountered again, we can return the result directly using the memo  array. This helps to prune the search tree to a great extent.  

        Time complexity : O(n^3)
        Space complexity : O(n^2) memo matrix of size n^2 is used
     */

    public boolean canCross(int[] stones) {
        int[][] memo = new int[stones.length][stones.length];
        /* Put -1 in all memo */ 
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return can_Cross(stones, 0, 0, memo) == 1;
    }
    public int can_Cross(int[] stones, int ind, int jumpsize, int[][] memo) {

        if (memo[ind][jumpsize] >= 0) { /* Has something updated */
            return memo[ind][jumpsize];
        }

        for (int i = ind + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[ind];
            if (gap >= jumpsize - 1 && gap <= jumpsize + 1) { /* [k-1,k,k+1] */
                if (can_Cross(stones, i, gap, memo) == 1) {
                    memo[ind][gap] = 1; /* Can find == 1*/
                    return 1;
                }
            }
        }
        memo[ind][jumpsize] = (ind == stones.length - 1) ? 1 : 0;/* Last pos */
        return memo[ind][jumpsize];
    }
}


////////////////////////////
// Memory + Binary Search //
////////////////////////////

public class Solution {
    /*
        We can optimize the above memorization approach, if we make use of Binary Search to find if a stone exists at currentPostion + newjumpsizecurrentPostion+newjumpsize instead of searching linearly.

        Time complexity : O(n^2*logn) Traversal of the memo and binary search
        Space complexity : O(n^2) memo matrix of size n^2 is used.
     */
    public boolean canCross(int[] stones) {
        int[][] memo = new int[stones.length][stones.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return can_Cross(stones, 0, 0, memo) == 1;
    }
    public int can_Cross(int[] stones, int ind, int jumpsize, int[][] memo) {
        if (memo[ind][jumpsize] >= 0) {
            return memo[ind][jumpsize];
        }
        int ind1 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize);
        if (ind1 >= 0 && can_Cross(stones, ind1, jumpsize, memo) == 1) {
            memo[ind][jumpsize] = 1;
            return 1;
        }
        int ind2 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize - 1);
        if (ind2 >= 0 && can_Cross(stones, ind2, jumpsize - 1, memo) == 1) {
            memo[ind][jumpsize - 1] = 1;
            return 1;
        }
        int ind3 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize + 1);
        if (ind3 >= 0 && can_Cross(stones, ind3, jumpsize + 1, memo) == 1) {
            memo[ind][jumpsize + 1] = 1;
            return 1;
        }
        memo[ind][jumpsize] = ((ind == stones.length - 1) ? 1 : 0);
        return memo[ind][jumpsize];
    }
}














