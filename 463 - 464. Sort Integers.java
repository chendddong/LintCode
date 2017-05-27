/*
    Given an integer array, sort it in ascending order. Use selection sort, bubble
    sort, insertion sort or any O(nlogn) algorithm.
 */

/*
    Example
    Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
 */

//////////////////////////
// Solution 1 QuickSort //
//////////////////////////

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int left = start, right = end;
        /* key point 1: pivot is the value, not the index */
        int pivot = A[(start + end) / 2];

        /* key point 2: every time you compare left & right, it should be left
        <= right not left < right */
        
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left++;
                right--;
            }
        }
        
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}

//////////////////////////
// Solution 2 MergeSort //
//////////////////////////

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        /* For the less cost, so declare the helper arr here*/
        int[] result = new int[A.length];
        mergeSortHelp(A, 0, A.length - 1, result);
    }
    
    private void mergeSortHelp(int[] A, int start, int end, int[] result) {
        if (start >= end) {
            return;
        }
        /* divid part */
        int mid = (start + end) / 2;
        mergeSortHelp(A, start, mid, result);
        mergeSortHelp(A, mid + 1, end, result);
        merge(A, start, end, result);
    }
    
    private void merge(int[] A, int start, int end, int[] result) {
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        int index = start;
        
        /* where merging happens */
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) { // A[left] <= A[right] Would cause TLE
                result[index++] = A[left++];
            } else {
                result[index++] = A[right++];
            }
        }
        
        /* The unfinished business */
        while (left <= mid) {
            result[index++] = A[left++];
        }
        while (right <= end) {
            result[index++] = A[right++];
        }        
        
        /* Give it back */
        for (int i = start; i <= end; i++) {
            A[i] = result[i];
        }
    }
}

/*
    Thoughts:

    The most important sorting for now.
    Have to understand it and be skillful when it comes to the sorting problem
 */


