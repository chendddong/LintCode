


public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // find the maxium difference between the number;
        // brute force from the last number to the left number find best difference
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = prices.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = prices[i] - prices[j];
                if (diff > max) {
                    max = diff;
                }
            }
        }
        
        return max;
    }
}

/* 
O(n^2)
*/
// [3,2,3,1,2]
//  0 1 2 3 4

// int min = Integer.MIN_VALUE -1; // min is set to Integer.MAX_VALUE by underflow
// int max = Integer.MAX_VALUE +1; // max is set to Integer.MIN_VALUE by overflow

 

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;  //just remember the smallest price
        int profit = 0;
        // for (int i : prices) {
        //     min = i < min ? i : min;
        //     profit = (i - min) > profit ? i - min : profit;
        // }
        
        // [3,2,3,1,2] 
        // O(n)
        for (int i : prices) {
            if (i < min) {
                min = i;
            } else {
                min = min;
            }
            
            if ((i - min) > profit) {
                profit = i - min;
            } else {
                profit = profit;
            }
        }
        return profit;
    }
}

