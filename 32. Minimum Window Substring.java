/**
 * Given a string source and a string target, find the minimum window in
 * source which will contain all the characters in target.
 */

/*
    If there is no such window in source that covers all characters in target, return the empty string "".

    If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.

    Clarification
    Should the characters in minimum window has the same order in target?

    Not necessary.
    Example
    For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"
 */
 
///////////////////////////////////
// Valid function check two Maps //
///////////////////////////////////

public class Solution {    
    /* Can get the targetHash number as well as initialize it */
    private int initTargetHash(int []targethash, String Target) {
        int targetnum =0 ;
        for (char ch : Target.toCharArray()) {
            targetnum++;
            targethash[ch]++;
        }
        return targetnum;
    }
    private boolean valid(int []sourcehash, int []targethash) {
        
        for(int i = 0; i < 256; i++) {
            if(targethash[i] > sourcehash[i])    
                return false;
        }
        return true;
    }
    public String minWindow(String Source, String Target) {
        /* queueing the position that matches the char in T */
        int ans = Integer.MAX_VALUE;
        String minStr = "";
        
        int[] sourcehash = new int[256];
        int[] targethash = new int[256];

        /* Go over the algorithm */
        // source = "ADOBECODEBANC", target = "ABC" ans = 5 minStr = "BANC"
        //                    i
        //                        j 
        // targethash = (A:1, B:1, C:1)
        // sourcehash = (B:1, A:1, N:1, C:1)

        initTargetHash(targethash, Target);
        int j = 0, i = 0;
        for(i = 0; i < Source.length(); i++) {
            /* Add character to sourceHash until it has all the target char */
            while( !valid(sourcehash, targethash) && j < Source.length()  ) {
                sourcehash[Source.charAt(j)]++;
                if(j < Source.length() )
                    j++;
                else 
                    break;
            }
            /* 
                Solve the problem by comparing the j - 1 and the current best,
                update it when necessary.
             */
            if(valid(sourcehash, targethash) ){
                if(ans > j - i ) {
                    ans = Math.min(ans, j - i );
                    minStr = Source.substring(i, j );
                }
            }
            /* Update SourceHash and the i index */
            sourcehash[Source.charAt(i)]--;
        }
        return minStr;
    }
}

/////////////////////////////////////////////////
// Comparing the total number of selected char //
/////////////////////////////////////////////////

public class Solution {
    public String minWindow(String Source, String Target) {

        /* Initializers */
        int ans = Integer.MAX_VALUE;
        String minStr = "";
        int[] targethash = new int[256];
        int targetnum = initTargetHash(targethash, Target);
        int sourcenum = 0;
        int i = 0;
        int j = 0;

        /* Go over the algorithm */
        // source = "ADOBECODEBANC", target = "ABC" ans = 6 minS = "ADOBEC"
        //           j    i
        // targethash = (D:-1, O:-1, E:-1, A:1) targetnum = 3
        //                                       sourcenum = 2;
        for (i = 0; i < Source.length(); i++) {
            if (targethash[Source.charAt(i)] > 0) {
                sourcenum++;
            }

            targethash[Source.charAt(i)]--;

            while (sourcenum >= targetnum) {
                if (ans > i - j + 1) {
                    ans = Math.min(ans, i - j + 1);
                    minStr = Source.substring(j, i + 1);
                }
                targethash[Source.charAt(j)]++;
                if (targethash[Source.charAt(j)] > 0) {
                    sourcenum--;
                }
                j++;
            }
        }
        return minStr;
    }

    private int initTargetHash(int[] targethash, String Target) {
        int targetnum = 0;
        for (char ch : Target.toCharArray()) {
            targetnum++;
            targethash[ch]++;
        }
        return targetnum;
    }
}