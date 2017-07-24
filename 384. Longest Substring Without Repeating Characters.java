/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 */

/*
    Example
    For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

    For "bbbbb" the longest substring is "b", with the length of 1.
 */

//////////////////
// Brute Force  //
//////////////////
    

public class Solution {
    /*
            Time complexity : O(n^3); Because we are checking the string
            character by character using a double loop and also check if they
            are unique. So basically we need to traverse nearly triple time
            times the N

            Space complexity : O(min(n, m)). We need O(k) space for checking a
            substring has no duplicate characters, where k is the size of the Set. The size of the Set is upper bounded by the size of the string n and the size of the charSet/alphabet m.

     */    
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    maxCount = Math.max(maxCount, j - i);
                }
            }
        }    
        return maxCount;
    }
    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
}

////////////////////////////////////
// Use a HashSet / Sliding window // 
////////////////////////////////////

public class Solution {
    /*
        Time complexity : O(2n) = O(n). In the worst case each character will be visited twice by i and j. 

        Space complexity : is the same as the brute force solution.
     */
   
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }    

        int i = 0;
        int j = 0;
        int maxConut = 0;
        HashSet<Character> set = new HashSet<>();

        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j++));
                    maxConut = Math.max(j - i, maxConut);
                } else {
                    break;
                }
            }
            /* Don't for get to remove the i as to update it */
            set.remove(s.charAt(i));            
        }

        return maxConut;

    }
}

///////////////
// ASCII 256 //
///////////////

public class Solution {
        /*
        Complexity Analysis:

        Time complexity : O(n). Index j will iterate n times.

        Space complexity (HashMap) : O(min(m, n)). Same as the previous
        approach. Space complexity (Table): O(m). mm is the size of the charSet.
         */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int maxConut = 0;
        
        /* 
            Always think about using the the ASCII thing when dealing with
            Charterers. Commonly used ASCII table:
            
            int[26] for Letters 'a' - 'z' or 'A' - 'Z'
            int[128] for ASCII
            int[256] for Extended ASCII            
         */
        
        int[] map = new int[128];
        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (map[s.charAt(j)] == 0) {
                    map[s.charAt(j++)] = 1;
                    maxConut = Math.max(maxConut, j - i);
                } else {
                    break;
                }
            }
            /* Delete this character in the map */
            map[s.charAt(i)] = 0;
        }

        return maxConut;
    }
}

/* 
    The template for this kind of problem:
    ------------------------------------------------------
    int i = 0, j = 0;
    for (i = 0; i < length; i++) {
        while (j < n) {
            if (satisfy) {
                ** Always there is a increment **
                update j;
            } else {
                break;
            }
            ** Solve the problem some where in between **
        }
        ** Set a state where we can renew the next position for i **
        update i;
    }
    ------------------------------------------------------
 */