public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        if (n == 0 && x == 0) {
            return 0;
        }
        
        if (n == 0) {
            return 1;
        }
        
        if (x == 0) {
            return 0;
        }
        
        if (n == 1) {
            return x; 
        }
        
        if (n == -1) {
            return 1 / x;
        }
        
        double result = x;
        if (n > 1) {
            // the easiest way I can think of is to use the for loop
            // result = 2.1
            // x = 2.1
            // n = 3
            // result = x^2
            for (int i = 0; i < n - 1; i++) {
                result = result * x;
            } 
        } 
        
        if (n < -1) {
            // the easiest way I can think of is to use the for loop
            // result = 2.1
            // x = 2.1
            // n = 3
            // result = x^2
            for (int i = 0; i < Math.abs(n) - 1; i++) {
                result = result * x;
            }
            
            result = 1 / result;
        }
        
        if (n > 0 && n < 1) {
            result = Math.pow(x, n);
        }
        
        if (n < 0 && n > -1) {
            result = Math.pow(x, n);
        }
        
        return result;
    }
}


public class Solution {
    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n *= -1;
        }

        int k = n / 2;
        int l = n - k * 2;
        double t1 = pow(x, k);
        double t2 = pow(x, l);
        if (isNegative) {
            return 1/(t1*t1*t2);
        } else {
            return t1*t1*t2;
        }
    }
}