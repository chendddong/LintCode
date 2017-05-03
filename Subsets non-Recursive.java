class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	int n = nums.length;
    	Arrays.sort(nums);

        // 1 << n is 2^n
        // each subset equals to an binary integer between 0 .. 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // 3 -> 011 -> [1, 2]
        // 4 -> 100 -> [3]
        // 5 -> 101 -> [1, 3]
        // 6 -> 110 -> [2, 3]
        // 7 -> 111 -> [1, 2, 3]  
        
        for (int i = 0; i < (1 << n); i++) {
        	ArrayList<Integer> subset = new ArrayList<Integer>();
        	for (int j = 0; j < n; j++) {
        		// check whether the jth digit in i's binary representation is 1
        		// this is the most important part
        		// 2 << 11 == 1000000000000
        		// 2 << 33 == 2 << 1 == 100;
        		if ((i & (1 << j)) != 0) {
        			subset.add(nums[j]);
        		}
        	}
        	result.add(subset);
        } 	

        return result;
    }
}