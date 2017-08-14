// Given a string which contains only letters. Sort it by lower case first and upper case second.

// Solution #0 naive one by myself
public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
    	if (chars == null || chars.length == 0) {
    		return;
    	}
    	// put those in two arrays
    	ArrayList<Character> smalls = new ArrayList<Character>();
    	ArrayList<Character> caps = new ArrayList<Character>();

    	for (int i = 0; i < chars.length; i++) {
    		if (chars[i] >= 97 || chars[i] <= 122) {
    			smalls.add(chars[i]);
    		} else {
    			caps.add(char[i]);
    		}
    	}

    	int index = 0;
    	for (Character small : smalls) {
    		chars[index++] = small;
    	}

    	for (Character cap : caps) {
    		chars[index++] = cap;
    	}
    }
}

// Solution #1 by partition by myself

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
    	if (chars == null || chars.length == 0) {
    		return;
    	}
    	int left = 0;
    	int right = chars.length - 1;
    	while (left <= right) {
    		while (left <= right && chars[left] >= 97 && chars[left] <= 122) {
    			left++;
    		}
    		while (left <= right && chars[right] >= 65 && chars[right] <= 90) {
    			right--;
    		}

    		if (left <= right) {
    			swap(left, right, chars);
    			left++;
    			right--;
    		}
    	} 
    }

   	private void swap(int left, int right, char[] chars) {
   		char temp = chars[left];
   		chars[left] = chars[right];
   		chars[right] = temp;
   	}
}

/* 
This one would be faster than the first one 
*/

// Solution #2 by jiuzhang
public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        int i = 0, j = chars.length - 1;
		char tmp ;
		while ( i <= j) {
			while (i <= j && Character.isLowerCase(chars[i]) ) i++;
			while (i <= j && Character.isUpperCase(chars[j]) ) j--;
			if (i <= j) {
				tmp = chars[i];
				chars[i] = chars[j];
				chars[j] = tmp;
				i++; j--;
			}
		}
        //write your code here
		return ;
    }
}

/*
There are methods like Character.isLowerCase(chars[i])
which can be used as to check if certain characters are 
LowerCases or UpperCases
 */

