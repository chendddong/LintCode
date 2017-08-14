
// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
// The same repeated number may be chosen from C unlimited number of times.
// Notice
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// Example
// Given candidate set [2,3,6,7] and target 7, a solution set is:
// [7]
// [2, 2, 3]
// version 1: Remove duplicates & generate a new array

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> results = new ArrayList<>();
    	if (candidates == null || candidates.length == 0) {
    		return results;
    	}

    	int[] nums = removeDuplicates(candidates);

    	dfs(nums, 0, new ArrayList<Integer>(), target, results);

    	return results;
    }
    // how to remove duplicates and store it in an new array
    // just remember this
    private int[] removeDuplicates(int[] candidates) {
    	Arrays.sort(candidates);

    	int index = 0;
    	for (int i = 0; i < candidates.length; i++) {
    		if (candidates[i] != candidates[index]) {
    			candidates[++index] = candidates[i];
    		}
    	}

    	int[] nums = new int[index + 1];
    	for (int i = 0; i < index + 1; i++) {
    		nums[i] = candidates[i];
    	}
    	return nums;
    }

    private void dfs(int[] nums,
    				 int startIndex,
    				 List<Integer> combination,
    				 int remainTarget,
    				 List<List<Integer>> results) {
    	if (remainTarget == 0) {
    		results.add(new ArrayList<Integer>(combination));
    		return;
    	}

    	for (int i = startIndex; i < nums.length; i++) {
    		if (remainTarget < nums[i]) {
    			break;
    		}

    		combination.add(nums[i]);
    		dfs(nums, i, combination, remainTarget - nums[i], results);
    		combination.remove(combination.size() - 1);
    	}
    }
}