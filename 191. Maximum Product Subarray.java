/**
 * Find the contiguous subarray within an array (containing at least one
 * number) which has the largest product.
 */

/*
    Example
    For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 */

/////////////////////////////////
// DP Template with O(n) Space //
/////////////////////////////////

public class Solution {

    /*
        Have to take consideration into the negative number.
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;

        /* 
            State :
                max[i] means maximum product that can be achieved ending with i
                min[i] means minimum product that can be achieved ending with i
         */
        int[] max = new int[n];
        int[] min = new int[n];

        /* Init */
        int result = nums[0];
        for (int i = 0; i < n; i++) {
            min[i] = max[i] = nums[i];
        }

        /* Function */
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            
            result = Math.max(result, max[i]); /* Update result */
        }
        
        /* Result */
        return result;
    }
}

///////////////////
// DP O(1) Space //
///////////////////

public class Solution {
    /*
        Traverse the array just once.
        Use 4 variables to keep track of the min, max, the preMin and preMax.
        For each number, we are going to calculate the max and compare it with
        the current res;
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int minPre = nums[0], maxPre = nums[0];
        int max = nums[0], min = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], Math.max(maxPre*nums[i], minPre*nums[i]));
            min = Math.min(nums[i], Math.min(maxPre*nums[i], minPre*nums[i]));
            res = Math.max(res, max); /* Update */
            maxPre = max;
            minPre = min;
        }

        return res;
    }
}

//////////////////////////
// Smart O(n) Solution  //
//////////////////////////

public class Solution {
    public int maxProduct(int[] A) {
        int res = A[0];
        int n = A.length;
        int imax = res;
        int imin = res;
        int temp = 0;

        for (int i = 1; i < n; i++) {
            if (A[i] < 0) {
                temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);

            res = Math.max(res, imax);
        }
        return res;
    }
}

