//////////////////////////////////////
// Solution 1 Using a StringBuilder //
//////////////////////////////////////
///
///
public class Solution {
    /**
     * @param num a positive number
     * @return true if it's a palindrome or false
     */
    public boolean palindromeNumber(int num) {
        String numStr = String.valueOf(num);
        String reversed = new StringBuilder(numStr).reverse().toString();
        return reversed.equals(numStr);
    }
}

/*
    Thoughts:

    1.  Could talk about the negative number
 */

/////////////////////////////////////
// Solution 2 Position by Position //
/////////////////////////////////////

public class Solution {
    /**
     * @param num a positive number
     * @return true if it's a palindrome or false
     */
    public boolean palindromeNumber(int num) {
        /* Since there would be a comparison */
        int temp = num;
        int reversed = 0;
        
        while (temp != 0) {
            reversed = reversed * 10 + temp % 10;
            temp = temp / 10;
        }
        return reversed == num;
    }
}



