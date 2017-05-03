	// * 1. we need a results to store all results
	// * 2. corner case
	// * 3. we need a inner layer result to store the result
	// * 4. Dont forget to sort in this problem
	// * 5. Use helper to get the subsets for that first element(startIndex) in the result
	// * 6. the helper function, the corner case [[]], then recursion
	// * 7. do remember the backtracking step 

class Solution {
    /**
     * the practice version
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<>();
    	if (nums == null || nums.length == 0) {
    		return results;
    	}

    	ArrayList<Integer> subset = new ArrayList<Integer>();
    	Arrays.sort(nums);
    	int startIndex = 0;
    	helper(results, subset, startIndex, nums);

    	return results;
    }

    private void helper(ArrayList<ArrayList<Integer>> results,
    					ArrayList<Integer> subset, int startIndex
    					int[] nums) {
    	// deep copy
    	results.add(new ArrayList<Integer>(subset));
    	int size = nums.length;
    	for (int i = 0; i < size; i++) {
    		subset.add(nums[i]);
    		//recurisive part
    		helper(results, subset, i + 1, nums);
    		// backtracking remove the last element
    		subset.remove(subset.size() - 1);
    	}
    }
}