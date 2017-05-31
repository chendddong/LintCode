/*
    Given a string s and a non-empty string p, find all the start indices of p's
    anagrams in s.
    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 40,000.
    The order of output does not matter.
 */

/*
    Example
    Given s = "cbaebabacd" p = "abc"

    return [0, 6]

    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".
 */


public class Solution {
    /**
     * @param s a string
     * @param p a non-empty string
     * @return a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        /* edge case */
        if (s == null || s.length() < p.length()) {
            return new ArrayList<>();
        } 
        List<Integer> list = new ArrayList<Integer>();
        /* find substrings and compare them with p */
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            /* last possible subStr */
            String subStr;
            if (i == s.length() - p.length()) {
                subStr = s.substring(i);
            } else {
                subStr = s.substring(i, i + p.length());
            }
            
            if (isAnagram(subStr, p) == 0) {
                list.add(i);
            }
        }
        return list;
    }
    
    /* Anagrams */
    public static final int NUM_LETTERS = 26;
    public static int isAnagram(String s, String t) {
        int[] sOffset = countOffsets(s);
        int[] tOffset = countOffsets(t);
        int result = 0;
        
        for (int i = 0; i < NUM_LETTERS; ++i) {
            result += Math.abs(sOffset[i] - tOffset[i]);
        }
        return result;
    }
    private static int[] countOffsets(String s) {
        int[] arr = new int[NUM_LETTERS];
        for (int i = 0; i < s.length(); ++i) {
            arr[s.charAt(i) - 'a']++;
        }
        return arr;
    }
}

/*
    The concept of modularization
 */