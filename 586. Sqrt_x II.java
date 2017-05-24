/*
    Implement double sqrt(double x) and x >= 0.

    Compute and return the square root of x.
 */

 
/*
    You do not care about the accuracy of the result, we will help you to output results.
    Example
    Given n = 2 return 1.41421356
 */

///////////////////////////////
// Solution 1 Just Return it //
///////////////////////////////

public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        return Math.sqrt(x);
    }
}

////////////////////////////////////
// Solution 2 Using Binary Search //
////////////////////////////////////

public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here
        double left = 0.0;
        double right = x;
        double eps = 1e-12;

        if(right < 1.0) {
            right = 1.0;
        }

        while(right - left > eps) {
            double mid = (right + left) / 2;
            if(mid * mid < x) {
                left = mid;
            }
            else {
                right = mid;
            }
        }

        return left;
    }
}

/*
    Thoughts:

    1. double type is different from the int type;
    2. when comes to the double, we have to set a epsilon to control the result
    3. if the right - left > epsilon, the loop goes on.
    4. we can return either the left or the right.
    5. When the x is less than 1. Just set the end to 1, it is experiential.
 */

//////////////////////////
// Solution 3 My way... //
//////////////////////////

public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        double epsilon = 1e-12;
        double start = 0;
        double end = x;
        double mid = x / 2;
        
        if (x < 1) {
            end = 1;
        }

            while (Math.abs(mid * mid - x) > epsilon) {
                mid = (start + end) / 2;
                if (mid * mid >= x) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            
            if (end * end <= x) {
                return end;
            }
            
            return start;
       
    }
}

//////////////////////////////
// Solution 4 Newton Method //
//////////////////////////////

public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        double res = 1.0;
        double eps = 1e-12;

        while(Math.abs(res * res - x) > eps) {
            res = (res + x / res) / 2;
        }

        return res;
    }
}

