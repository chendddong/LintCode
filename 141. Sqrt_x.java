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

///////////////////////////////////////////////////
// Solution 1 StraightForward Using Math.sqrt(); //
///////////////////////////////////////////////////

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        return  (int) Math.sqrt(x);
    }
}

////////////////////////////////////
// Solution 2 Using Binary Search //
////////////////////////////////////


class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public static int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        /* Find the min index and the max index*/
        long tempSqrt = (long) x;
        while (tempSqrt * tempSqrt > x) {
            tempSqrt /= 2;
        }

        /* The perfect sqrt*/
        if (tempSqrt * tempSqrt == x) {
            return (int) tempSqrt;
        }

        /* 999999999 */
        /* 30517 ~ 61035 */
        long start = tempSqrt;  
        long end = tempSqrt * 2;


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

/////////////////////////////////////////////
// Solution 3 Using Binary Search Directly //
/////////////////////////////////////////////

/* find the last number which square of it <= x */

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // find the last number which square of it <= x
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
}

