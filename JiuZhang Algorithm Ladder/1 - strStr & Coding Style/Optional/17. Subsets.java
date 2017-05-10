/**
 * Given a set of distinct integers, return all possible subsets.
 */

/*
     Notice

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    Have you met this question in a real interview? Yes

    Example
    If S = [1,2,3], a solution is:

    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
 */

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        /* sort before we go */
        Arrays.sort(nums);

        ArrayList<Integer> subset = new ArrayList<>();
        subsetsHelper(nums, 0, subset, results);

        return results;
    }
    /* Recursion 3 components
       1. What: Find all the subsets start with subset and add it to the results
     */
    private void subsetsHelper(int[] nums,
                          int startIndex,
                          ArrayList<Integer> subset,
                          ArrayList<ArrayList<Integer>> results) {
        /* Recursion 3 components
           2. Divide: 
         */        
        /* deep copy subset & add to the results */
        results.add(new ArrayList<Integer>(subset));

        for (int i = startIndex; i < nums.length; ++i) {
            subset.add(nums[i]);
            subsetsHelper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }

        /* Recursion 3 components
           3. End of the recursion: Base Case. 
         */        
    }
}
