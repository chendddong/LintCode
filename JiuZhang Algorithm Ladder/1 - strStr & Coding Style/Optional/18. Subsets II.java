/**
 * Given a list of numbers that may has duplicate numbers, return all possible subsets
 */

/*
     Notice

    Each element in a subset must be in non-descending order.
    The ordering between two subsets is free.
    The solution set must not contain duplicate subsets.
    Have you met this question in a real interview? Yes
    Example
    If S = [1,2,2], a solution is:

    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
*/

    //////////////
    // Solution //
    //////////////

class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        /* [[]] */
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);

        ArrayList<Integer> subset = new ArrayList<Integer>();
        subsetsHelper(nums, 0, subset, results);

        return results;

    }

    private void subsetsHelper(int[] nums,
                               int startIndex,
                               ArrayList<Integer> subset,
                               ArrayList<ArrayList<Integer>> results) {
        results.add(new ArrayList<Integer>(subset));

        for (int i = startIndex; i < nums.length; ++i) {
            if (i != 0 && nums[i] == nums[i - 1] && i != startIndex) {
                continue;
            }
            subset.add(nums[i]);
            subsetsHelper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}

/* 
    Thoughts

    1.  How to eliminate the duplicates
        if (i != 0 && nums[i] == nums[i - 1] && i != startIndex) 
    2.  How to prevent array index out of boundary
*/
