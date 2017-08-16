/*
    Implement int sqrt(int x).

    Compute and return the square root of x.
 */

/*
    Example
    sqrt(3) = 1

    sqrt(4) = 2

    sqrt(5) = 2

    sqrt(10) = 3
 */

////////////////////////////////////////
// StraightForward Using Math.sqrt(); //
////////////////////////////////////////

class Solution {
    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        return  (int) Math.sqrt(x);
    }
}


/////////////////////////
// Using Binary Search //
/////////////////////////

class Solution {

    public static int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        /* Narrow down the search */
        long tempSqrt = (long) x;
        while (tempSqrt * tempSqrt > x) {
            tempSqrt /= 2;
        }

        /* The perfect sqrt*/
        if (tempSqrt * tempSqrt == x) {
            return (int) tempSqrt;
        }

        long start = tempSqrt, end = start * 2;

        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end < x) {
            return (int) end;
        }

        if (start * start < x) {
            return (int) start;
        }

        return 0;
    }
}

//////////////////////////////////
// Using Binary Search Directly // 
//////////////////////////////////

/* Treat this as the template of value binary search */

class Solution {

    public int sqrt(int x) {
        long start = 1, end = x; /* Should use long instead of int */
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int) end; /* Cast to return type */
        }
        return (int) start;
    }
}

