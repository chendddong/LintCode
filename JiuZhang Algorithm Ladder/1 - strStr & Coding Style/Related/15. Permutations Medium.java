/**
 * Given a list of numbers, return all possible permutations.
 */


/*
     Notice

    You can assume that there is no duplicate numbers in the list.

    Example
    For nums = [1,2,3], the permutations are:

    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
*/

/*
    corner cases:
    nums == null --> return []
    nums.length == 0 --> return [[]]
 */
    s
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results; 
        }

        Arrays.sort(nums);
        /** [1,2,3] */
        List<Integer> permutation = new ArrayList<Integer>();
        permutationHelper(nums, results, permutation);
        return results;

    }

    private void permutationHelper(int[] nums,
                                   List<List<Integer>> results,
                                   List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (permutation.contains(nums[i])) {
                continue;
            }
            permutation.add(nums[i]);
            permutationHelper(nums, results, permutation);
            permutation.remove(permutation.size() - 1);
        }
    }
}

/*
    Toughts

    1. permutation always start from index 0. And for that reason, we do not
    need a startIndex like in the Subsets. In order to skip the visited one:
        
        if (permutation.contains(nums[i])) {
            continue;
        }
 */

////////////////////////////////////
// Solution 2 Non-Recursion Stack //
////////////////////////////////////


class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> permutations
             = new ArrayList<List<Integer>>();
        if (nums == null) {
            
            return permutations;
        }

        if (nums.length == 0) {
            permutations.add(new ArrayList<Integer>());
            return permutations;
        }
        
        int n = nums.length;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        
        stack.add(-1);
        while (stack.size() != 0) {
            Integer last = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            
            // increase the last number
            int next = -1;
            for (int i = last + 1; i < n; i++) {
                if (!stack.contains(i)) {
                    next = i;
                    break;
                }
            }
            if (next == -1) {
                continue;
            }
            
            // generate the next permutation
            stack.add(next);
            for (int i = 0; i < n; i++) {
                if (!stack.contains(i)) {
                    stack.add(i);
                }
            }
            
            // copy to permutations set
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                permutation.add(nums[stack.get(i)]);
            }
            permutations.add(permutation);
        }
        
        return permutations;
    }
}