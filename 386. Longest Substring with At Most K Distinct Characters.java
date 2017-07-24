/**
 * Given a string s, find the length of the longest substring T that contains
 * at most k distinct characters.
 */

/*
    Example
    For example, Given s = "eceba", k = 3,
                             
                                
    T is "eceb" which its length is 4.

 */

///////////////////
// Use a HashMap //
///////////////////
    
public class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = s.length();
        char c;

        for (i = 0; i < n; i++) {
            while (j < n) {
                c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    if (map.size() == k) {
                        break;
                    }
                    map.put(c, 1);
                }
                j++;
            }

            /* Handle the character at i */
            maxLen = Math.max(maxLen, j - i);
            c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                if (count > 1) {
                    map.put(c, count - 1);
                } else {
                    /* Remove a key and value pair in hashMap */
                    map.remove(c);
                }
            }  
        }   
        return maxLen;
    }
}

/////////////////////////
// Using a ASCII thing //
/////////////////////////

public class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        int[] map = new int[256];
        int i = 0;
        int j = 0;
        int n = s.length();        
        char c;

        for (i = 0; i < n; i++) {
            while (j < n) {
                c = s.charAt(j);
                if (map[c] > 0) {
                    map[c]++;
                } else {
                    if (getNoneZero(map) == k) {
                        break;
                    }
                    map[c]++;
                }
                j++;
            }
            /* 
                Handle the character at i & solve the problem at the same time
             */
            maxLen = Math.max(maxLen, j - i);
            c = s.charAt(i);
            if (map[c] > 0) { 
                map[c]--;
            }
        
        }

        return maxLen;
    }

    private int getNoneZero(int[] map) {
        int numNoneZero = 0;
        for (int i : map) {
            if (i > 0) {
                numNoneZero++;
            }
        }
        return numNoneZero;
    }
}   