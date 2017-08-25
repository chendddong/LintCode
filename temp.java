Summary

Given a sorted stone array containing the positions at which there are stones in a river. We need to determine whether it is possible or not for a frog to cross the river by stepping over these stones, provided that the frog starts at position 0, and at every step the frog can make a jump of size k-1k−1, kk or k+1k+1 if the previous jump is of size kk.

Solution

Approach #1 Brute Force [Time Limit Exceeded]

In the brute force approach, we make use of a recursive function canCrosscanCross which takes the given stone array, the current position and the current jumpsizejumpsize as input arguments. We start with currentPosition=0currentPosition=0 and jumpsize=0jumpsize=0. Then for every function call, we start from the currentPositioncurrentPosition and check if there lies a stone at (currentPostion + newjumpsize)(currentPostion+newjumpsize), where, the newjumpsizenewjumpsize could be jumpsizejumpsize, jumpsize+1jumpsize+1 or jumpsize-1jumpsize−1. In order to check whether a stone exists at the specified positions, we check the elements of the array in a linear manner. If a stone exists at any of these positions, we call the recursive function again with the same stone array, the currentPositioncurrentPosition and the newjumpsizenewjumpsize as the parameters. If we are able to reach the end of the stone array through any of these calls, we return truetrue to indicate the possibility of reaching the end.

Java

public class Solution {
    public boolean canCross(int[] stones) {
        return can_Cross(stones, 0, 0);
    }
    public boolean can_Cross(int[] stones, int ind, int jumpsize) {
        for (int i = ind + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[ind];
            if (gap >= jumpsize - 1 && gap <= jumpsize + 1) {
                if (can_Cross(stones, i, gap)) {
                    return true;
                }
            }
        }
        return ind == stones.length - 1;
    }
}
Complexity Analysis

Time complexity : O(3^n)O(3
​n
​​ ). Recursion tree can grow upto 3^n3
​n
​​ .
Space complexity : O(n)O(n). Recursion of depth nn is used.
Approach #2 Better Brute Force[Time Limit Exceeded]

Algorithm

In the previous brute force approach, we need to find if a stone exists at (currentPosition + new jumpsize)(currentPosition+newjumpsize), where newjumpsizenewjumpsize could be either of jumpsize-1jumpsize−1, jumpsizejumpsize or jumpsize+1jumpsize+1. But in order to check if a stone exists at the specified location, we searched the given array in linearly. To optimize this, we can use binary search to look for the element in the given array since it is sorted. Rest of the method remains the same.

Java

public class Solution {
    public boolean canCross(int[] stones) {
        return can_Cross(stones, 0, 0);
    }
    public boolean can_Cross(int[] stones, int ind, int jumpsize) {
        if (ind == stones.length - 1) {
            return true;
        }
        int ind1 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize);
        if (ind1 >= 0 && can_Cross(stones, ind1, jumpsize)) {
            return true;
        }
        int ind2 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize - 1);
        if (ind2 >= 0 && can_Cross(stones, ind2, jumpsize - 1)) {
            return true;
        }
        int ind3 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize + 1);
        if (ind3 >= 0 && can_Cross(stones, ind3, jumpsize + 1)) {
            return true;
        }
        return false;
    }
}
Complexity Analysis

Time complexity : O(3^n)O(3
​n
​​ ). Recursion tree can grow upto 3^n3
​n
​​ .
Space complexity : O(n)O(n). Recursion of depth nn is used.
Approach #3 Using Memorization [Accepted]

Algorithm

Another problem with above approaches is that we can make the same function calls coming through different paths e.g. For a given currentIndexcurrentIndex, we can call the recursive function canCrosscanCross with the jumpsizejumpsize, say nn. This nn could be resulting from previous jumpsizejumpsize being n-1n−1,nn or n+1n+1. Thus, many redundant function calls could be made prolonging the running time. This redundancy can be removed by making use of memorization. We make use of a 2-d memomemo array, initialized by -1−1s, to store the result returned from a function call for a particular currentIndexcurrentIndex and jumpsizejumpsize. If the same currentIndexcurrentIndex and jumpsizejumpsize happens is encountered again, we can return the result directly using the memomemo array. This helps to prune the search tree to a great extent.

java

public class Solution {
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
        for (int i = ind + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[ind];
            if (gap >= jumpsize - 1 && gap <= jumpsize + 1) {
                if (can_Cross(stones, i, gap, memo) == 1) {
                    memo[ind][gap] = 1;
                    return 1;
                }
            }
        }
        memo[ind][jumpsize] = (ind == stones.length - 1) ? 1 : 0;
        return memo[ind][jumpsize];
    }
}
Complexity Analysis

Time complexity : O(n^3)O(n
​3
​​ ). Memorization will reduce time complexity to O(n^3)O(n
​3
​​ ).

Space complexity : O(n^2)O(n
​2
​​ ). memomemo matrix of size n^2n
​2
​​  is used.

Approach #4 Using Memorization with Binary Search [Accepted]

Algorithm

We can optimize the above memorization approach, if we make use of Binary Search to find if a stone exists at currentPostion + newjumpsizecurrentPostion+newjumpsize instead of searching linearly.

java

public class Solution {
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
Complexity Analysis

Time complexity : O\big(n^2 log(n)\big)O(n
​2
​​ log(n)). We traverse the complete dpdp matrix once (O(n^2))(O(n
​2
​​ )). For every entry we take atmost nn numbers as pivot.

Space complexity : O(n^2)O(n
​2
​​ ). dpdp matrix of size n^2n
​2
​​  is used.

Approach #5 Using Dynamic Programming[Accepted]

Algorithm

In the DP Approach, we make use of a hashmap mapmap which contains key:valuekey:value pairs such that keykey refers to the position at which a stone is present and valuevalue is a set containing the jumpsizejumpsize which can lead to the current stone position. We start by making a hashmap whose keykeys are all the positions at which a stone is present and the valuevalues are all empty except position 0 whose value contains 0. Then, we start traversing the elements(positions) of the given stone array in sequential order. For the currentPositioncurrentPosition, for every possible jumpsizejumpsize in the valuevalue set, we check if currentPosition + newjumpsizecurrentPosition+newjumpsize exists in the mapmap, where newjumpsizenewjumpsize can be either jumpsize-1jumpsize−1, jumpsizejumpsize, jumpsize+1jumpsize+1. If so, we append the corresponding valuevalue set with newjumpsizenewjumpsize. We continue in the same manner. If at the end, the valuevalue set corresponding to the last position is non-empty, we conclude that reaching the end is possible, otherwise, it isnt.

For more understanding see this animation-

1 / 19
java

public class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}
Complexity Analysis

Time complexity : O(n^2)O(n
​2
​​ ). Two nested loops are there.

Space complexity : O(n^2)O(n
​2
​​ ). hashmaphashmap size can grow upto n^2n
​2
​​  .