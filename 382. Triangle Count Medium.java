/*
    Given an array of integers, how many three numbers can be found in the array,
    so that we can build an triangle whose three edges length is the three numbers that we find?

    Have you met this question in a real interview? Yes
    Example
    Given array S = [3,4,6,7], return 3. They are:

    [3,4,6]
    [3,6,7]
    [4,6,7]
    Given array S = [4,4,4,4], return 4. They are:

    [4(1),4(2),4(3)]
    [4(1),4(2),4(4)]
    [4(1),4(3),4(4)]
    [4(2),4(3),4(4)]
 */

/*
    Time complexity : O(n^2)
    Space complexity : O(log n) because of the sorting
 */


public class Solution {

    /* This is important because of the move of the pointer. */
    public int triangleCount(int[] S) {
        /* Must be 3 or more numbers */
        if (S == null || S.length < 3) {
            return 0;
        }

        int count = 0;
        int left = 0;
        int right = S.length - 1;        
        Arrays.sort(S); /* Always sort an array */
        
        /* Walk through */
        // [3,4,6,7]
        //  l     
        //    r 
        //        i
        for (int i = 0; i < S.length; i++) {
            left = 0;
            right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }

        }

        return count;
    }
}

/* 
    The code here is actually very concise and easy, the hardest thing is to think the matter through.

    If the time complexity is not less than nlogn we can just sort it using the generic sort method
*/


/////////////////////////
// More Intuitive Scan //
/////////////////////////

public class Solution {
    public int triangleCount(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1; /* Walk through and see the happening */
            }
        }
        return count;
    }
}