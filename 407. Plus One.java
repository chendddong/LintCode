public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // [1,2,3] --> [1,2,4]
        // [9,9,9] --> [1,0,0,0]
        // [9]
        // [1]
        if (digits == null) {
            return null;
        }
        
        if (digits.length == 0) {
            int[] newDigits = {1};
            return newDigits;
        }
        
        
        int carry = 0;
        
        int val = digits[digits.length - 1] + 1;
        
        if (val >= 10) {
            carry = 1;
            val = val % 10;
            digits[digits.length - 1] = val;
        } else {
            digits[digits.length - 1] = val;
        }
        
        for (int i = digits.length - 2; i >= 0; i--) {
            if (carry == 0) {
                val = digits[i];
            } else {
                val = digits[i] + 1;
            }
            
            if (val >= 10) {
                carry = 1;
                val = val % 10;
                digits[i] = val;
            } else {
                digits[i] = val;
                carry = 0;
            }
        }
        
        if (carry == 0) {
            return digits;
        }
        
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            newDigits[i + 1] = digits[i];
        }
        
        return newDigits;
        
    }
}

/* 
Think through the process and maybe do it in a simple way
*/


public class Solution {
    // The complexity is O(1)
    // f(n) = 9/10 + 1/10 * O(n-1)
    //  ==>  O(n) =  10 / 9 = 1.1111 = O(1)
    //  [1,2,3]
    public int[] plusOne(int[] digits) {
        int carries = 1;
        for(int i = digits.length-1; i>=0 && carries > 0; i--){  // fast break when carries equals zero
            int sum = digits[i] + carries;
            digits[i] = sum % 10;
            carries = sum / 10;
        }

        if(carries == 0)
            return digits;
            
        int[] rst = new int[digits.length+1];
        rst[0] = 1;
        for(int i=1; i< rst.length; i++){
            rst[i] = digits[i-1];
        }
        return rst;
    }
}

/* 
how to manipulate the numbers and carry!
            int sum = digits[i] + carries;
            digits[i] = sum % 10;
            carries = sum / 10;

Mind the index;

Mind the double exit condition i>=0 && carries > 0

*/

