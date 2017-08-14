// Given an array S of n integers, 
// are there elements a, b, c in S such that
// a + b + c = 0? 
// Find all unique triplets in the array which gives the sum of zero.

// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

// The solution set must not contain duplicate triplets.

// For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

// (-1, 0, 1)
// (-1, -1, 2)

// public class Solution {
//     /**
//      * @param numbers : Give an array numbers of n integer
//      * @return : Find all unique triplets in the array which gives the sum of zero.
//      */
//     public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
//     	if (numbers == null || numbers.length == 0) {
//     		return new ArrayList<>();
//     	}

// 		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
//         int[] sorted = new int[numbers.length];
//         System.arraycopy(numbers, 0, sorted, 0, numbers.length);
        
//     	for (int i = 0; i < numbers.length; i++) {
//     		int target = 0 - numbers[i];
//     		int[] noIthNums = deleteIth(sorted, i);
//     		ArrayList<Integer> result = twoSum(noIthNums, target);
//     		sorted = new int[numbers.length];
//     		System.arraycopy(numbers, 0, sorted, 0, numbers.length);
//     		if (result.size() != 0) {
//     		    result.add(numbers[i]);
//     		    Collections.sort(result);
//     		    results.add(result);
//     		    continue;
//     		}
//     	}

//     	return results;
//     }

// 	public ArrayList<Integer> twoSum(int[] numbers, int target) {
// 		if (numbers == null || numbers.length == 0) {
// 			return new ArrayList<Integer>();
// 		}

// 		// copy and sort the original array;
//         int[] sorted = new int[numbers.length];
//         System.arraycopy(numbers, 0, sorted, 0, numbers.length);
//         Arrays.sort(sorted);

// 		int i = 0, j = numbers.length - 1;

// 		while (i < j) {
// 			if (sorted[i] + sorted[j] > target) {
// 				j--; 
// 				continue;
// 			}
// 			if (sorted[i] + sorted[j] < target) {
// 				i++; 
// 				continue;
// 			} 
// 			if (sorted[i] + sorted[j] == target) {
// 				break;				
// 			}
// 		}

// 		// find the indices in the original array
// 		int newI = -1;
// 		int newJ = -1;

// 		for (int k = 0; k < numbers.length; k++) {
// 			if (numbers[k] == sorted[i] || numbers[k] == sorted[j]) {
// 				if (newI == -1) {
// 					newI = k + 1;
// 				} else {
// 					newJ = k + 1;
// 				}
// 			}
// 		}

// 		ArrayList<Integer> result = new ArrayList<Integer>();
		
// 		if (newI != -1 && newJ != -1) {
// 		    result.add(numbers[newI]);
// 		    result.add(numbers[newJ]);
// 		    return result;
// 		} 
		
// 		return result;

// 	}


//     public int[] deleteIth(int[] numbers, int i) {
//     	int[] newNums = new int[numbers.length - 1];
//     	for (int j = 0; j < i; j++) {
//     		newNums[j] = numbers[j];
//     	}

//     	for (int j = i; j < numbers.length - 1; j++) {
//     		newNums[j] = numbers[j + 1];
//     	}

//     	return newNums;
//     }
// }


/* 
by far, this is ugly and I would like to give it a try, but unfortunately it was not quite as planned, so
I will refer to the answer.
*/

public class Solution {
    /**
     * @param nums : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return results;
        }
        
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicate triples with the same first numebr
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];
            
            twoSum(nums, left, right, target, results);
        }
        
        return results;
    }
    
    public void twoSum(int[] nums,
                       int left,
                       int right,
                       int target,
                       ArrayList<ArrayList<Integer>> results) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ArrayList<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                results.add(triple);
                
                left++;
                right--;
                // skip duplicate pairs with the same left
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                // skip duplicate pairs with the same right
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}