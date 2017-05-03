// Given an array of integers, how many three numbers can be found in the array, 
// so that we can build an triangle whose three edges length is the three numbers that we find?

// Solution #0

// Inputs : int[] nums;
// outputs: int (how many triplets can we find);

// 1. null input 2. empty array 3. less than three numbers --  return 0; 
// regular cases: [3, 2, 4, 5] [3, 3, 3, 3]

// go through the process what we can found is 
// 

// the runtime should be O(n^2)

class Solution {
	public int triangleCount(int[] S) {
		if (S == null || S.length < 3) {
			return 0;
		}
		
		int left = 0, right = S.length - 1;
		int count = 0;
		Arrays.sort(S);
		for (int i = 0; i < S.length; i++) {
			// since it's three numbers
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
The code here is atucally very consice and easy, the hardest thing is to think the matter through.

If the time complexity is not less than nlogn we can just sort it using the generic sort method
*/