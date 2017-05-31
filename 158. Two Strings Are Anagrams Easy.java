/**
 * Write a method to decide if two strings are anagrams or not.
 */

//////////////////
// Solution #0  //
//////////////////

/* time complexity is nlogn because of the sort method. */
/* too slow */
public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        /* edge cases */
        if ((s == null && t == null) || (s.length() == 0 && t.length() == 0)) {
            return true;
        }

        /* early stop */
        if (s.length() != t.length()) {
            return false;
        }

        /* sort the two strings to two arrays */
        char[] ch_a = s.toCharArray();
        char[] ch_b = t.toCharArray();
        Arrays.sort(ch_a);
        Arrays.sort(ch_b);

        int indexA = 0, indexB = 0;
        
        /* one character at a time */
        while (indexA < s.length() - 1) {
            if (ch_a[indexA++] != ch_b[indexB++]) {
                return false;
            }
        }

        if ((indexA == indexB) && (indexA == s.length() - 1) && (indexB == t.length() - 1)) {
            return true;
        }

        return false;
    }
}


////////////////////////////////////////////
// Solution #1: Sort the strings O(nlogn) //
////////////////////////////////////////////
/* too slow */

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        return sort(s).equals(sort(t));
    }

    private static String sort(String a) {
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}

/*
    Always remember to use String.equals() to compare two strings.
*/

/////////////////////////////////////////////////
// Solution #2: Check counts for unique char.  //
/////////////////////////////////////////////////

/* O(max(n, m)) */
/* but this one has used some extra space AKA int[] count = new int[256]; */

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        /* Early stop */
        if (s.length() != t.length()) {
            return false;
        }

        /* General Case -- for all the ASCII in the string */
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            /* convert Char to int and then count */
            int index = (int) s.charAt(i);
            count[index]++;
        }

        for (int j = 0; j < t.length(); j++) {
            int index = (int) t.charAt(j);
            count[index]--;
            /* not anagram */
            /* 
                E.g.
                    s = [a,b,c]
                count = [97, 98, 99]
                    t = [a,b,d]
                count[99] < 0; 
            */
            if (count[index] < 0) {
                return false;
            }
        }
        return true;
    }
}

/* 
    remember to use this to create arrays full of 0 int[] count = new int[256];
    This is way better and identical for the two for loops than the answer that the author offered
*/

///////////////////////////////////////////////
// Solution #3: Counts for each unique char. //
///////////////////////////////////////////////

/* O(max(n, m)) */
class Solution {
    public static boolean anagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[256];
        int num_unique_chars = 0;
        int num_completed_t = 0;
        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            if (letters[c] == 0) {
                ++num_unique_chars;
                ++letters[c];
            }
        }

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            /* early stop */
            if (letters[c] == 0) {
                return false;
            }
            --letters[c];
            if (letters[c] == 0) {
                ++num_completed_t;
                if (num_completed_t == num_unique_chars) {
                    /* it's a match if t has been processed completely */
                    return i == t.length() - 1;
                }
            }
        }
        return false;
    }
}

/*
    Basically, this has the same flow of the second solution 
*/


///////////////////////////////////
// Solution 4 Modularized Counts //
///////////////////////////////////

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public static final int NUM_LETTERS = 26; /* Can use offset counts */
    public static final int NUM_ASCII = 256; /* General Case direct count */

    public boolean anagram(String s, String t) {
        /* early stop */
        if (s.length() != t.length()) {
            return false;
        }
        
        /* Count characters */
        int[] firstCounts = counts(s);
        int[] secondCounts = counts(t);
        
        int result = 0;
        for (int i = 0; i < NUM_ASCII; ++i) {
            result += Math.abs(firstCounts[i] - secondCounts[i]);
        }
        return result == 0;
    }
    
    private static int[] counts(String s) {
        int[] arr = new int[NUM_ASCII];
        for (int i = 0; i < s.length(); ++i) {
            arr[s.charAt(i)]++;
        }
        return arr;
    }
}

////////////////////////
// Solution 5 HashMap //
////////////////////////

//  Time Complexity: O(n) using a HashMap
// Space Complexity: O(n)

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */

    public boolean anagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        s = s.toLowerCase();
        t = t.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        
        /* Fill HashMap with 1st String */
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.merge(ch, 1, Integer::sum);
        }
        
        /* Compare 2nd String to 1st String's HashMap */
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
    
};