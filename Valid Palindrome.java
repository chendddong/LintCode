// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// Have you consider that the string might be empty? This is a good question to ask during an interview.

// For the purpose of this problem, we define empty string as valid palindrome.

// Example
// "A man, a plan, a canal: Panama" is a palindrome.

// "race a car" is not a palindrome.

// Solution #0 definitely first in my mind is to use two pinters at the beginning the string and at the end of the string

public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
    	if (s == null) {
    		return false;
    	}
    	if (s == "") {
    		return true;
    	}

    	// we have to split the string first and use the regex
    	String[] words = s.toLowerCase().split("[ \n\t\r.,;:!?(){]");
    	StringBuilder sb = new StringBuilder();
    	for (String word : words) {
    		sb.append(word);
    	}
    	String cleanS = sb.toString();

    	int i = 0;
    	int j = cleanS.length() - 1;

    	while (i <= j) {
    		if (cleanS.charAt(i) != cleanS.charAt(j)) {
    			return false;
    		}
    		i++;
    		j--;
    	}

    	return true;

    }
}

/* 
1. the regex we can always refer to the Internet, but in the interview we must know something about it like how to 
clean a string.

2. yep two pointers
*/


// Solution #1 by jiuzhang

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int front = 0;
        int end = s.length() - 1;

        while (front < end) {
            while (front < s.length() && !isvalid(s.charAt(front))){ // nead to check range of a/b
                front++;
            }

            if (front == s.length()) { // for emtpy string “.,,,”     
                return true; 
            }           

            while (end >= 0 && ! isvalid(s.charAt(end))) { // same here, need to check border of a,b
                end--;
            }

            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                front++;
                end--;
            }
        }

        return end <= front; 
    }

    private boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}

/*
This answer is checked by the generic Character.isLetter() and Character.isDigit();

And the way to check the non-letter only-diameters is to traverse from both ways;
*/
