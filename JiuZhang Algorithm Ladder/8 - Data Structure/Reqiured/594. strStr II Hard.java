/**
 * Implement strStr function in O(n + m) time. 
 * strStr return the first indexofthe target string 
 * in a source string. The length of the target string 
 * is m and the length of the source string is n.If target 
 * does not exist in source, just return -1.
 */


/*
    Example
    Given source = abcdef, target = bcd, return 1.
 */

public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    
    int BASE = 1000000;
    public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        int m = target.length();
        if (m == 0) {
            return 0;
        }

        int power = 1;
        for (int i = 0; i < m; ++i) {
            power = (power * 31) % BASE;
        }


        int targetCode = 0;
        for (int i = 0; i < m; ++i) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }

        int hashCode = 0;
        int n = source.length();
        for (int i = 0; i < n; ++i) {
            /* abc + d */
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            if (i < m - 1) {
                continue;
            }

            /* abcd - a */
            if (i >= m) {
                hashCode = (hashCode - source.charAt(i - m) * power) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }

            /* double check */
            if (hashCode == targetCode) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }

            }
        }

        return -1;
    }
}

/*
    Thoughts
    1. The deep understanding of the Hash Function!
 */