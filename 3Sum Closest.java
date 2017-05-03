// Given an array S of n integers, find three integers in S such that 
// the sum is closest to a given number, target. Return the sum of the three integers.

// [4, 2, 3, 6, 7, 8] 
// [2, 3, 4, 6, 7, 8] 
// [3, 4, 6, 7, 8] 14

// time complexity is O(n^2)

// public class Solution {
//     /**
//      * @param numbers: Give an array numbers of n integer
//      * @param target : An integer
//      * @return : return the sum of the three integers, the sum closest target.
//      */
//     public int threeSumClosest(int[] numbers, int target) {
//     	if (numbers == null || numbers.length < 3) {
//     		return -1;
//     	}
//     	int result = Integer.MAX_VALUE;
// 		Arrays.sort(numbers);
//     	for (int i = 0; i < numbers.length; i++) {
//     		int target4Two = target - numbers[i];
//     		int closestTwoSum = twoSum(numbers, i + 1, numbers.length - 1, target4Two);
//     		result = Math.min(closestTwoSum, result);
//     	}

//     	return result;
//     }

//     public int twoSum(int[] nums, int left, int right, int target) {
//     	int diff = Integer.MAX_VALUE;
//     	while (left < right) {
//     		int v = nums[left] + nums[right];
//     		if (v == target) {
//     			return 0;
//     		}
//     		if (v > target) {
//     			diff = Math.min(diff, Math.abs(v - target));
//     			right--;
//     		}
//     		if (v < target) {
//     			diff = Math.min(diff, Math.abs(v - target));
//     			left++;
//     		}
//     	} 
//     	return diff;
//     }
// }

/* 
Turns out there are major problems involved 
the logic should be more simple I guess
*/


// Solution #1

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
    	if (numbers == null || numbers.length < 3) {
    		return -1;
    	}

    	Arrays.sort(numbers);
    	int bestSum = numbers[0] + numbers[1] + numbers[2];
    	for (int i = 0; i < numbers.length; i++) {
    		int start = i + 1, end = numbers.length - 1;
    		while (start < end) {
    			int sum = numbers[i] + numbers[start] + numbers[end];
    			if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
    				bestSum = sum;
    			}

    			if (sum < target) {
    				start++;
    			} else {
    				end--;
    			}
    		}
    	}

    	return bestSum;
    }
}
