// inputs : String s
// outputs : int result

// test cases : null, ""
// abbca, abcdefg, bbbbbb, abcabcbb

// HashMap, size of the map
// 


public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occured index
        int j = 0;
        int i = 0;
        int ans = 0;

        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)] == 0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            map[s.charAt(i)] = 0;
        }
        
        return ans;
    }
}
// abbca i = 0, j = 0, map['a'] = 1, ans = 1, j = 1; 
//       i = 0, j = 1, map['b'] = 1, ans = 2, j = 2;
//       i = 0, j = 2, map['b'] = 1, map['a'] = 0;
//       i = 1, j = 2, map['b'] = 1, map['b'] = 0;
//       i = 2, j = 2, map['b'] = 1, ans = 2, j = 3;
//       i = 2, j = 3, map['c'] = 1, ans = 2, j = 4;
//       i = 2, j = 4, map['a'] = 1, ans = 3, j = 5;

