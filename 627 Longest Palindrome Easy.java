/**
 * Given a string which consists of lowercase or uppercase letters, find the 
 * length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 */


/*
    Assume the length of given string will not exceed 1010.
    Example
    Given s = "abccccdd" return 7
    One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

////////////////////////////////////////
// Solution 1 Counting each Character //
////////////////////////////////////////

public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int lengthOfPalin = 0;
        /* Lower and Uppercases */
        int[] count = new int['z' - 'A' + 1];

        /* Count offset of the character since it is a number */
        for (int i =0; i < s.length(); ++i) {
            int val = s.charAt(i) - 'A';
            count[val]++;
        }

        /* increment the length of Palindrome */
        for(Integer cnt : count) {
            if (cnt % 2 == 0) {
                lengthOfPalin += cnt;
            } else {
                lengthOfPalin += cnt - 1;
            }
        }

        /* aabbccdd -- all evens */
        if (lengthOfPalin == s.length()) {
            return lengthOfPalin;
        }

        /* aaaaabbdde with odd */
        return lengthOfPalin + 1;

    }
}

//////////////////////////////////////
// Solution 2 Using a Character set //
//////////////////////////////////////

public class Solution {
    public int longestPalindrome(String s) {

        /* Use set to store odd-numbered character */
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }


        int remove = set.size();
        if (remove == 0) {
            return s.length() - remove;
        }

        /* only that one odd number */
        return s.length() - remove + 1;
    }
}


