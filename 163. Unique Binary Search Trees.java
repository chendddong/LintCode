/**
 * Given n, how many structurally unique BSTs (binary search trees) that store
 * values 1...n?
 * 
 *         -- TreeDemo 26.3 
 *         -- LeetCode 96
 *         -- LintCode 163
 *         -- LeetCode 95
 *         -- LintCode 164
 */

/*
    Example
    Given n = 3, there are a total of 5 unique BST's.

    1           3    3       2      1
     \         /    /       / \      \
      3      2     1       1   3      2
     /      /       \                  \
    2     1          2                  3
 */

////////////////
// DP Optimal //
////////////////

/*
    The case for 3 elements example
    Count[3] = Count[0]*Count[2]  (1 as root)
                  + Count[1]*Count[1]  (2 as root)
                  + Count[2]*Count[0]  (3 as root)

    Therefore, we can get the equation:
    Count[i] = ∑ Count[0...k] * [ k+1....i]     0<=k<i-1  
*/

public class Solution {
    public int numTrees(int n) {
        if (n <= 0) {
            return 1;
        }
        
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;

        for(int i = 2; i <= n; ++i) {
            for(int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}

/*
    The problem is to calculate the number of unique BST. To do so, we need to define two functions:

    G(n): the number of unique BST for a sequence of length n.

    F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.

    As one can see, G(n) is the actual function we need to calculate in order to solve the problem. And G(n) can be derived from F(i, n), which at the end, would recursively refer to G(n).

    First of all, given the above definitions, we can see that the total number of unique BST G(n), is the sum of BST F(i) using each number i as a root.
    i.e.

    G(n) = F(1, n) + F(2, n) + ... + F(n, n). 
    Particularly, the bottom cases, there is only one combination to construct a BST out of a sequence of length 1 (only a root) or 0 (empty tree).
    i.e.

    G(0)=1, G(1)=1. 
    Given a sequence 1…n, we pick a number i out of the sequence as the root, then the number of unique BST with the specified root F(i), is the Cartesian product of the number of BST for its left and right subtrees. For example, F(3, 7): the number of unique BST tree with number 3 as its root. To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root, which is to say, we need to construct an unique BST out of its left subsequence [1, 2] and another BST out of the right subsequence [4, 5, 6, 7], and then combine them together (i.e. Cartesian product). The tricky part is that we could consider the number of unique BST out of sequence [1,2] as G(2), and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4). Therefore, F(3,7) = G(2) * G(4).

    i.e.

    F(i, n) = G(i-1) * G(n-i)   1 <= i <= n 
    Combining the above two formulas, we obtain the recursive formula for G(n). i.e.

    G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
    In terms of calculation, we need to start with the lower number, since the value of G(n) depends on the values of G(0) … G(n-1).
 */
