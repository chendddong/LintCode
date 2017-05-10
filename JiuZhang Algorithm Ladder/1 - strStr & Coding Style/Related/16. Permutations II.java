/**
 *  Given a list of numbers with duplicate number in it. Find all unique permutations.
 */

/*
    Example
    For numbers [1,2,2] the unique permutations are:

    [
      [1,2,2],
      [2,1,2],
      [2,2,1]
    ]

*/


class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
    
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
    
        if (nums == null) {
            return results;
        }
    
        if(nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        for ( int i = 0; i < visited.length; i++){
            visited[i] = 0;
        }
     
        helper(results, list, visited, nums);    
        return results;
    }
    
    
    public void helper(ArrayList<List<Integer>> results, 
                   ArrayList<Integer> list, int[] visited, int[] nums) {
        
        if(list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if ( visited[i] == 1 || ( i != 0 && nums[i] == nums[i - 1]
            && visited[i-1] == 0)){
                continue;
            }
            /*
            What the if clause did is to eliminate the duplicates. For example,
            for a sorted array [1,2',2''], if we swap the first 2 say 2' and the
            second 2 say 2'', we would consider those two permutations the
            same. So what we could do is to regulate the sequence of the same
            the number and let them appear in the same sequence in the results,
            which guarantees the uniqueness.
            */
            visited[i] = 1;
            list.add(nums[i]);
            helper(results, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
     } 
}

/*
    Thoughts

    1.  The if clause:

        if ( visited[i] == 1 || ( i != 0 && nums[i] == nums[i - 1]
        && visited[i-1] == 0)){
            continue;
        }       
        
    2.  the visited array
 */