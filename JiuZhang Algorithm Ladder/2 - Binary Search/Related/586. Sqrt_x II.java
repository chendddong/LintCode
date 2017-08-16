/*
    Implement double sqrt(double x) and x >= 0.

    Compute and return the square root of x.
 */

 
/*
    You do not care about the accuracy of the result, we will help you to output results.
    Example
    Given n = 2 return 1.41421356
 */

////////////////////
// Just Return it //
////////////////////

public class Solution {
    public double sqrt(double x) {
        return Math.sqrt(x);
    }
}

///////////////////
// Binary Search //
///////////////////

/*
    Thoughts:

    1. double type is different from the int type;
    2. when comes to the double, we have to set a epsilon to control the result
    3. if the right - left > epsilon, the loop goes on.
    4. we can return either the left or the right.
    5. When the x is less than 1. Just set the end to 1, it is experiential.
 */

public class Solution {

    public double sqrt(double x) {

        double left = 0.0;
        double right = x;
        double eps = 1e-12; 

        /* The numbers between 0 and 1 are getting larger when sqrt them */
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
        // return right;
    }
}

///////////////////
// Newton Method //
///////////////////

public class Solution {

    public double sqrt(double x) {
        double res = 1.0;
        double eps = 1e-12;

        while(Math.abs(res * res - x) > eps) {
            res = (res + x / res) / 2;
        }

        return res;
    }
}