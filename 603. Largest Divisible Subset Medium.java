/*
    Given a set of distinct positive integers, find the largest subset such
    that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0
    or Sj % Si = 0.
 */

/*
     Notice

    If there are multiple solutions, return any subset is fine.

    Example
    Given nums = [1,2,3], return [1,2] or [1,3]

    Given nums = [1,2,4,8], return [1,2,4,8]
 */

////////
// DP //            Comeback later for a walkthrough
////////

public class Solution {
    /*
        Time : O(n ^ 2)
        Space : O(n)
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        int[] pre = new int[n];

        for (int i = 0; i < n; i++) {
            f[i] = 1;
            pre[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                    pre[i] = j;
                }
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        if (n == 0) return ans;

        int max = 0;
        int maxI = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] > max) {
                max = f[i];
                maxI = i;
            }
        }

        ans.add(nums[maxI]);
        while (maxI != pre[maxI]) {
            maxI = pre[maxI];
            ans.add(nums[maxI]);
        }
        Collections.reverse(ans);
        return ans;
    }
}