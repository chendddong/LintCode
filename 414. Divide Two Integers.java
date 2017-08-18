/**
 *      Divide two integers without using multiplication, division and mod 
 *      operator.If it is overflow, return 2147483647
 * 
 */

/*
    Example
    Given dividend = 100 and divisor = 9, return 11.
 */

/* Use bit manipulation */
public class Solution {

    public int divide(int dividend, int divisor) {
        /* These edge cases are bit annoying */
        if (divisor == 0) {
             return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; /* Shift the max */
        }
        
        boolean isNegative = (dividend < 0 && divisor > 0) || 
                             (dividend > 0 && divisor < 0);
                             
        long a = Math.abs((long) dividend); /* abs for the shift action */
        long b = Math.abs((long) divisor);
        int result = 0;
        /* Draw it on the white board and explain */
        while(a >= b) {
            int shift = 0;
            while(a >= (b << shift)) {
                shift++;
            }
            a -= b << (shift - 1); /* Subtract a */
            result += 1 << (shift - 1); /* Increment result by shifting 1 */
        }
        return isNegative ? -result: result; /* Make sure the negativity */
    }
}

/*
    Thoughts:

    1. Use left shit to compare the value with the dividend and divisor
       find the proper value for the certain position and then add it to the
       result.
    2. Good example of bit manipulation
 */