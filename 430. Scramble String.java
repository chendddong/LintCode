/**
 * Given a string s1, we may represent it as a binary tree by partitioning it 
 * to two non-empty substrings recursively.
 */

/*
    Below is one possible representation of s1 = "great":

        great
       /    \
      gr    eat
     / \    /  \
    g   r  e   at
               / \
              a   t
    To scramble the string, we may choose any non-leaf node and swap its two children.

    For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

        rgeat
       /    \
      rg    eat
     / \    /  \
    r   g  e   at
               / \
              a   t
    We say that "rgeat" is a scrambled string of "great".

    Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

        rgtae
       /    \
      rg    tae
     / \    /  \
    r   g  ta  e
           / \
          t   a
    We say that "rgtae" is a scrambled string of "great".

    Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */

////////////////////
// Regular Search //
////////////////////

class Solution {
    /*
        1. We need to determine if the characters are all the same. Using ASCII
        2. Recursively compare the string by using the substring both
        sequentially and reversely */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        

        if (!isValid(s1, s2)) return false;
        
        int n = s1.length();
        /* Start from 1 since we are using the substring */
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) 
                return true;

            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) 
                return true;
        }

        return false;
    }

    private boolean isValid(String s1, String s2) {
        int[] letters = new int[26];
        int n = s1.length();

        for (int i = 0; i < n; i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) return false;
        }

        return true;
    }    
}

////////////////////////////////
// Cache Search Using HashMap //
////////////////////////////////

public class Solution {
    HashMap<String, Boolean> hash = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        if (hash.containsKey(s1 + ":" + s2)) /* Search the cache first */
            return hash.get(s1 + ":" + s2);

        int n = s1.length();
        if (n == 1) return s1.charAt(0) == s2.charAt(0); /* Just one Char */

        /* Start from 1 since we are using the substring */
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                hash.put(s1 + ":" + s2, true);
                return true;                
            }
            if  (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                 isScramble(s1.substring(i), s2.substring(0, n - i))) {
                hash.put(s1 + ":" + s2, true);
                return true;
            }       
        }

        hash.put(s1 + ":" + s2, false);
        return false;        

    }
}

/////////////////////////
// Cashing using array //
/////////////////////////

public class Solution {

     private boolean checkScramble(String s1,int start1, String s2, int start2, int k, int [][][]visit) {
        /*
            In here, k starts from one to s1.length(), so the index is n + 1;
         */
        if(visit[start1][start2][k] ==  1)
            return true;
        if(visit[start1][start2][k] == -1)
            return false;
        
        
        if (s1.length() != s2.length()) {
            visit[start1][start2][k] = -1;
            return false;
        }
        
        if (s1.length() == 0 || s1.equals(s2)) {
            visit[start1][start2][k] = 1;
            return true;
        }
        
        if (!isValid(s1, s2)) {
            visit[start1][start2][k] = -1;
            return false;
        } 
        /* 
            Base cases above;
            1. Check the hash
            2. Check string's length; 
                not equal
                empty String
            3. Check the ASCII

        */
        
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, s1.length());
            
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, s2.length());
            
            String s23 = s2.substring(0, s2.length() - i);
            String s24 = s2.substring(s2.length() - i, s2.length());
            
            if (checkScramble(s11,start1, s21, start2, i, visit) && checkScramble(s12, start1+i, s22, start2+i,k-i, visit))  {
                visit[start1][start2][k] = 1;
                return true;
            }
            
            if (checkScramble(s11,start1, s24, start2+k-i, i, visit) && checkScramble(s12,start1+i, s23,start2, k-i, visit))
            {
                visit[start1][start2][k] = 1;
                return true;
            }
        }
        visit[start1][start2][k] = -1;
        return false;
    }
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        int [][][] visit = new int[len][len][len + 1];                         
        return checkScramble(s1,0,s2,0, len, visit);
    }
    private boolean isValid(String s1, String s2) {
        int[] letters = new int[26];
        int n = s1.length();

        for (int i = 0; i < n; i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) return false;
        }

        return true;
    }
    /* 
        1. Convert s1 and s2 to char[];
        2. sort the charArray and compare the newly formed String to see if
        they are equal.
        */
    // private boolean isValid(String s1, String s2) {
    //     char[] arr1 = s1.toCharArray();
    //     char[] arr2 = s2.toCharArray();
    //     Arrays.sort(arr1);
    //     Arrays.sort(arr2);
    //     if (!(new String(arr1)).equals(new String(arr2))) {
    //         return false;
    //     }
    //     return true;
    // }    
}

////////
// DP //                    Comeback later
////////

public class Solution {

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n+1];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            
        for (int len = 2; len <= n; ++len)
            for (int x = 0; x < n && x + len <= n; ++x)
                for (int y = 0; y < n && y + len <=n; ++y)
                    for (int k= 1; k < len; ++k)
                    dp[x][y][len] |= dp[x][y][k] && dp[x + k][y + k][len - k]
                    || dp[x][y + len - k][k] && dp[x + k][y][len - k];
    
        return dp[0][0][n];
    }
}



