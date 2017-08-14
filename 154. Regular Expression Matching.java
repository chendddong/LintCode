// public class Solution {
//     /**
//      * @param s: A string 
//      * @param p: A string includes "." and "*"
//      * @return: A boolean
//      */
//     public boolean isMatch(String s, String p) {
//         if (s == null && p == null) {
//             return true;
//         }
        
//         if (s.length() == 0 && p.length() == 0) {
//             return true;
//         }
        
//         if (s.length() > p.length()) {
//             return false;
//         }
//         // * 42 . 46
//         char[] str_s = new char[s.length()];
//         for (int i = 0; i < s.length(); i++) {
//             str_s[i] = s.charAt(i);
//         }
        
//         char[] str_p = new char[p.length()];
//         for (int i = 0; i < p.length(); i++) {
//             str_p[i] = p.charAt(i);
//         }
        
//         for (int i = 0; i < p.length() - s.length() + 1; i++) {
//             int j = 0;
//             for (j = 0; j < s.length(); j++) {
//             //     if (p.charAt(i) != s.charAt(j) && p.charAt(i) != '*' && p.charAt(i) != '.') {
//             //         break;
//             //     }
//                 if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.') {
//                     continue;
//                 } else if (p.charAt(i) == s.charAt(j) &&)
//             }
            
//             if (j == s.length()) {
//                 return true;
//             }
//         }
        
//         return false;
        
        
//         // c*a*b -- p
//         //   aab -- s
//     }
// }


/*
Didnt quite get the logic of the '.' and the '*'
*/


//Solution #0 by jiuzhang

public class Solution {
    public boolean isMatch(String s, String p) {
        //Java note: s.substring(n) will be "" if n == s.length(), but if n > s.length(), index oob error
        
        int i = 0, j = 0;
        //you don't have to construct a state machine for this problem
 
        if (s.length() == 0) {
            return checkEmpty(p);
        }
 
        if (p.length() == 0) {
            return false;
        }
 
        char c1 = s.charAt(0);
        char d1 = p.charAt(0), d2 = '0'; //any init value except '*'for d2 will do
 
        if (p.length()>1){
            d2 = p.charAt(1);
        }
 
        if (d2 == '*') {
            if (compare(c1, d1)) {
                //fork here: 1. consume the character, and use the same pattern again.
                //2. keep the character, and skip 'd1*' pattern
                 
                //Here is also an opportunity to use DP, but the idea is the same
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            }
            else {
                return isMatch(s, p.substring(2));
            }
        }
        else {
            if (compare(c1, d1)) {
                return isMatch(s.substring(1), p.substring(1));
            }
            else {
                return false;
            }
        }
    }
    
    public boolean compare(char c1, char d1){
        return d1 == '.' || c1 == d1;
    }
 
    public boolean checkEmpty(String p) {
        if (p.length()%2 != 0) {
            return false;  
        }
 
        for (int i = 1; i < p.length(); i+=2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}