/**
 *      Divide two integers without using multiplication, division and mod 
 *      operator.If it is overflow, return 2147483647
 * 
 */

/*
    Example
    Given dividend = 100 and divisor = 9, return 11.
 */

/* Use bit */
public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
             return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        if (dividend == 0) {
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean isNegative = (dividend < 0 && divisor > 0) || 
                             (dividend > 0 && divisor < 0);
                             
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while(a >= b){
            int shift = 0;
            while(a >= (b << shift)){
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative? -result: result;
    }
}

/*
    Thoughts:

    1. Use left shit to compare the value with the dividend and divisor
       find the proper value for the certain position and then add it to the
       result.
    2. Good example of bit manipulation
 */