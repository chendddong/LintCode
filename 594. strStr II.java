// Implement strStr function in O(n + m) time.

// strStr return the first index of the target string in a source string. The
// length of the target string is m and the length of the source string is n.
// If target does not exist in source, just return -1.

// Have you met this question in a real interview? Yes
// Example
// Given source = abcdef, target = bcd, return 1.
// map{"1":b, "2":c, "3":d}

// two pointers cut the string in the amount of the target
// abcdefg
// abc,bcd,cde,def,efg

public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public int strStr2(String source, String target) {
        // corner cases:
        if (source == null || target == null) {
            return -1;
        }
        
        if (source.equals(target)) {
            return 0;
        }
        
        if (source.length() == 0) {
            return -1;
        }
        
        if (source.length() != 0 && target.length() == 0) {
            return 0;
        }
        // normal ones:
        // "tartarget", "target"
        int i = 0, j = target.length() - 1; // 5
        while (i <= j && j <= source.length()) { // 8 - 5 = 3
            if (j != source.length()) {
                String sub = source.substring(i, j + 1);
                if (sub.equals(target)) {
                    return i;
                } else {
                    i++;
                    j++;
                }                
            } else {
                String sub = source.substring(i);
                if (sub.equals(target)) {
                return i;
                } else {
                    break;
                }

            }

       
        }
        return -1;
    }
    
    
}

/* 
This simply just takes too much time for the comparison
*/

public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public int strStr2(String source, String target) {
        if(target == null) {
            return -1;
        }
        int m = target.length();
        if(m==0) {
            return 0;
        }
        
        if(source == null) {
            return -1;
        }
        int n = source.length();
        if(n==0) {
            return -1;
        }
        
        if (m == 0) {
            return 0;
        }
        
        // mod could be any big integer
        // just make sure mod * 33 wont exceed max value of int.
        int mod = Integer.MAX_VALUE / 33;
        int hash_target = 0;

        // 33 could be something else like 26 or whatever you want
        for (int i = 0; i < m; ++i) {
            hash_target = (hash_target * 33 + target.charAt(i) - 'a') % mod;
            if (hash_target < 0) {
                hash_target += mod;
            }
        }

        int m33 = 1;
        for (int i = 0; i < m - 1; ++i) {
            m33 = m33 * 33 % mod;
        }

        int value = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= m) {
                value = (value - m33 * (source.charAt(i - m) - 'a')) % mod;
            }

            value = (value * 33 + source.charAt(i) - 'a') % mod;
            if (value < 0) {
                value += mod;
            }

            if (i >= m - 1 && value == hash_target) {
                // you have to double check by directly compare the string
                if (target.equals(source.substring(i - m + 1, i + 1))) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
}

/*
Guess it's just something about the lower level hash
*/
