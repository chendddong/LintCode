/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 */

/*
    Clarification
    Your algorithm should run in O(n) complexity.

    Example
    Given [100, 4, 200, 1, 3, 2],
    The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 */

/////////////
// HashSet //
/////////////

public class Solution {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;
        for (int num : nums) {

            int down = num - 1; /* Down 1*/
            int up = num + 1; /* Up 1 */
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            longest = Math.max(longest, up - down - 1); /* Give an example */
        }
        
        return longest;
    }
}

/* 
    Set ups and down and give the difference between the up and down
    and we can do it both ways form the ups or the downs

    This algorithm is brilliant
*/