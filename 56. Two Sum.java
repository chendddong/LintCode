// Given an array of integers, find two numbers such that they add up to a specific target number.

// The function twoSum should return indices of the two numbers such that they add up to the target, 
// where index1 must be less than index2. 
// Please note that your returned answers (both index1 and index2) are NOT zero-based.


// inputs int[] nums int target
// outputs int[2] index1, index2 and index1 < index2 index starts from 1;

// test cases: 
// corner cases: 1. null 2. [] return -> [] 
// regular ones: nums = [3, 4, 7, 1], target = 5, can be found;
// regular ones: nums = [3, 4, 7, 1], target = 4, can not be found;

// we can either use hashMap or we can sort the array traverse them. 
// for hashMap method the runtime space O(N) and time is also O(N).

// Solution #0 using the hashMap I can't get it done personally
class Solution {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0) {
			return new int[0];
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < numbers.length; i++) {
			if (map.get(numbers[i]) != null) {
				int[] result = {map.get(numbers[i]) + 1, i + 1};
				return result;
			}
			map.put(target - numbers[i], i);
		}

		int[] result = {};
        return result;

	}
}

/* 
To use it as a buffer not and array to store all the values!
We have to mind the use of HashMap.

Store the target - nums[i] in the HashMap.
if we can find the something later in the array ==  target - nums[i]
that means that the two sum is target.
if we can't just keep adding the difference and index of the target and the number
at that index.
*/


// Solutions #1 We can also use two pointers and sort to solve this problem

class Solution {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0) {
			return new int[0];
		}

		// copy and sort the original array;
        int[] sorted = new int[numbers.length];
        System.arraycopy(numbers, 0, sorted, 0, numbers.length);
        Arrays.sort(sorted);

		int i = 0, j = numbers.length - 1;

		while (i < j) {
			if (sorted[i] + sorted[j] > target) {
				j--; 
				continue;
			}
			if (sorted[i] + sorted[j] < target) {
				i++; 
				continue;
			} 
			if (sorted[i] + sorted[j] == target) {
				break;				
			}
		}

		// find the indices in the original array
		int newI = -1;
		int newJ = -1;

		for (int k = 0; k < numbers.length; k++) {
			if (numbers[k] == sorted[i] || numbers[k] == sorted[j]) {
				if (newI == -1) {
					newI = k + 1;
				} else {
					newJ = k + 1;
				}
			}
		}

		int[] result = {newI,  newJ};
		Arrays.sort(result);
		return result;

	}
}

/* 
When you actually used the sort method, you have to find the actual positon
of the index in the unsorted array which leave no choice to copy the array
to a new array and then sorted the new array. 

Use this method to copy the new array:

int[] sorted = new int[numbers.length];
System.arraycopy(numbers, 0, sorted, 0, numbers.length);

dont forget to set these indices to -1 at first.
		int newI = -1;
		int newJ = -1;
*/
