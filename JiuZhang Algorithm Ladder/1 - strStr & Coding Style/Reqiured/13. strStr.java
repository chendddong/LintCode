
/**
 *      For a given source string and a target string, you should output the
 *      first index(from 0) of target string in source string.
 *      If target does not exist in source, just return -1.
 */

/*
    Do I need to implement KMP Algorithm in a real interview?

    Not necessary. When you meet this problem in a real interview, the interviewer 
    may just want to test your basic implementation ability. But make sure your confirm 
    with the interviewer first.
    
    Example:

    If source = "source" and target = "target", return -1.
    If source = "abcdabcdefg" and target = "bcd", return 1.
 */




/*
    ////////////////////////////////////
    // Solution 1 write a double loop //
    ////////////////////////////////////
    
    Runtime O(n^2)

 */

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        
        // if ( target.length() == 0 && source.length() == 0) {
        //     return 0;
        // }

        // if (target.length() > source.length()) {
        //     return -1;
        // }
 
        /* targetwhat total number of outer loop is 10 - 6 + 1
           source
         */
        int outLoopNum = source.length() - target.length() + 1;
        int innerLoopNum = target.length();

        /* targetwhat 
           get */
        for (int i = 0; i < outLoopNum; ++i) {
            int j = 0;
            for (j = 0; j < innerLoopNum; ++j) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }

            if (j == target.length()) {
                return i;
            }
        }

        return -1;
    }
}


/*
    1. Declare the variable outside the loop since we are using it afterwards
    2. Edge cases [""] [""]
    3. We have already coverd the cases 45 - 51 in the main code.
 */