// practice version
class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
    	if (A == null || B == null) {
    		return 0;
    	}

    	int len = A.length + B.length;

    	double result = 0;
    	// odd
    	if (len % 2 == 0) {
    		result = (findKth(A, B, 0, 0, len / 2) +
    				  findKth(A, B, 0, 0, len / 2 + 1)) / 2.0;
    	} else {
    		result = findKth(A, B, 0, 0, len / 2 + 1);
    	}

    	return result;
    }

    // Find the Kth large number
    public int findKth(int[] A, int[] B, int indexA, int indexB, int k) {
    	int lenA = A.length;
    	int lenB = B.length;

    	if (indexA >= lenA) {
    		return B[indexB + k - 1];
    	} else if (indexB >= lenB) {
    		return A[indexA + k - 1];
    	}

    	// base case, we have to exit since when k = 1, we can not divide anymore
    	if (k == 1) {
    		return Math.min(A[indexA], B[indexB]);
    	}
    	// because we start from index 0
    	int mid = k / 2 - 1;

    	int keyA = indexA + mid >= lenA ? Integer.MAX_VALUE : A[indexA + mid];
    	int keyB = indexB + mid >= lenB ? Integer.MAX_VALUE : B[indexB + mid];

    	// since we throw away k / 2 elements;
    	int kNew = k - k / 2;

    	if (keyA < keyB) {
    		return findKth(A, B, indexA + k / 2, indexB, kNew);
    	} else {
    		return findKth(A, B, indexA, indexB + k / 2, kNew);
    	}
    }
}
