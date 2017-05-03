// Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

// [1,1,2] -> [2]
// [1,2,2,4,5,4,5] -> [1]
// [] -> [], null -> null

// inputs : int[] nums
// outputs : int

// Use hash map O(n)




// Solution #1 bit manipulation
public class Solution {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int rst = 0;
        for (int i = 0; i < A.length; i++) {
            rst ^= A[i];
        }
        return rst;
    }
}

// Solution #2 hashSet
public class Solution {
	public int singleNumber(int[] A) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int n : A) {
			if (!set.add(n))
				set.remove(n);
		}
		Iterator<Integer> it = set.iterator();
		return it.next();
	}
}
