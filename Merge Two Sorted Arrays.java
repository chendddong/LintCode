// Merge two given sorted integer array A and B into a new sorted integer array.
// Have you met this question in a real interview? Yes
// Example
// A=[1,2,3,4]
// B=[2,4,5,6]
// return [1,2,2,3,4,4,5,6]

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
    	// using brute force
    	int sizeA = A.length;
    	int sizeB = B.length;
    	int[] C = new int[sizeA + sizeB];
    	
    	for (int i = 0; i < sizeA; i++) {
    		C[i] = A[i];
    	}

    	for (int j = 0; j < sizeB; j++) {
    		C[j + sizeA] = B[j];
    	}

    	Arrays.sort(C);
    	return C;
    }
}