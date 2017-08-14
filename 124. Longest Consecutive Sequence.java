// Given an unsorted array of integers, find the 
// length of the longest consecutive elements sequence.

// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence 
// is [1, 2, 3, 4]. Return its length: 4.

// Given an unsorted array of integers, find the length 
// of the longest consecutive elements sequence.

// Your algorithm should run in O(n) complexity.

// Example
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. 
// Return its length: 4.

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            
            int up = nums[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            
            longest = Math.max(longest, up - down - 1);
        }
        
        return longest;
    }
}

/* 
Set ups and down and give the difference between the up and down
and we can do it both ways form the ups or the downs

This algorithm is brilliant
*/