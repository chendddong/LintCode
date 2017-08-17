/*
    Given an array with positive and negative numbers, find the maximum average
    sub-array which length should be greater or equal to given length k.

 */


 
/*
    It's guaranteed that the size of the array is greater or equal to k.
    Example
    Given nums = [1, 12, -5, -6, 50, 3], k = 3

    Return 15.667 // (-6 + 50 + 3) / 3 = 15.667
 */

public class Solution {

    public double maxAverage(int[] nums, int k) {
        double l = Integer.MAX_VALUE; // smallest
        double r = Integer.MIN_VALUE; // largest

        /* Find the smallest / largest number in the array */
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < l) {
                l = nums[i];
            }
            if (nums[i] > r) {
                r = nums[i];
            }
        }

        while (r - l >= 1e-6) {
            double mid = (l + r) / 2.0;
            if (check_valid(nums, mid, k)) {/* The mid is too small go right */
                l = mid;
            } else { /* The mid is too large go left */
                r = mid;
            }
        }
        return l;
    }

    private boolean check_valid(int[] nums, double mid, int k) {
        int n = nums.length;
        double min_pre = 0;
        double[] sum = new double[n + 1]; 
        sum[0] = 0;
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1] - mid;
            if (i >= k && sum[i] - min_pre >= 0) {
                return true;
            }

            if (i >= k) {
                min_pre = Math.min(min_pre, sum[i - k + 1]);
            }
        }

        return false;
    }
}

/*
    Thoughts: 

    1. The maximum average of a sub-array must lie between the min and max of
    this array. We have to therefore narrow down the min and max of the array
    by one traversal.
    2. Then we need to narrow down the search interval until it reaches a
    epsilon (e.g. 1e-6). We can check and update the mid value along the way.

    个人理解：
    1、一个数组的子数组的最大平均数一定在数组的最大值和最小值之间，所以二分法的第一步限定average位于[min,max]之中。
    2、接下去要做的就是不断的缩小范围，直至max-min足够小（如1e-6），那我们就得到了想要的结果。
    缩小范围的思想如下：
    每一轮设置mid=(min+max)/2，然后将原数组中的每一个数减去这个mid，如果能找到（经过提醒，改正为：大于等于） 
    k个相邻数的总和大于0的情况，那么说明最终结果一定比这个mid要更大，限定下一轮寻找范围在[mid,max]之中。反之在限定在
    [min,mid]之中。

    那么在实际算法中我们需要解决的关键一步就是，如何判断“有（大于等于）k个相邻数的总和大于0的情况存在”。
    首先，我们可以用sum数组来存储减掉mid值的原数组的各总和（sum[i]存储num[0]-mid到num[i-1]-mid的总和），  当sum
    [i]存储的总和个数超过k时（即i>k），也就是说我们保证了这个子数组的长度达到k后，可以砍掉之前一些拖后腿的数。这些拖后腿 
    的数在上述链接的代码中是用min_pre来实现的。当之前拖后腿的数值小于min_pre时，更新min_pre=sum[i - k + 1]。sum[i]
    存储的是num[0]~num[i-1]减去mid的总和，而min_pre存储的是num[0]~num[k]减掉mid的总和，这样sum
    [i]-min_pre得到的是  sum[k+1]~sum[i-1]，它所记录的总和个数也就是到num[i]为止能够找到的最大平均数 子数组的长度。    
 */

/////////////////
// Double loop //           TLE
/////////////////

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        for (int s = 0; s < nums.length - k + 1; s++) {
            long sum = 0;
            for (int i = s; i < nums.length; i++) {
                sum += nums[i];
                if (i - s + 1 >= k)
                    res = Math.max(res, sum * 1.0 / (i - s + 1));
            }
        }
        return res;
    }
}