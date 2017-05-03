class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
    	if (nums == null) {
    		return results;
    	}

    	if (nums.length == 0) {
    		results.add(new ArrayList<Integer>());
    		return results;
    	}

    	ArrayList<Integer> list = new ArrayList<Integer>();
    	helper(results, list, nums);
    	return results;
    }

    public void helper(ArrayList<List<Integer>> results,
    				   ArrayList<Integer> list,
    				   int[] nums) {
    	if (list.size() == nums.length) {
    		results.add(new ArrayList<Integer>(list));
    		return;
    	}

    	for (int i = 0; i < nums.length; i++) {
    		if (list.contains(nums[i])) {
    			continue;
    		}
    		list.add(nums[i]);
    		helper(results, list, nums);
    		list.remove(list.size() - 1);
    	}
    }
}
