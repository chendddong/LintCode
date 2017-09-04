///////////////////////////
// Binary Search Version //             73% Comeback later
///////////////////////////

public class Solution {

    public int copyBooksII(int n, int[] times) {
        if (times.length == 0 || n <= 0) return Integer.MAX_VALUE;

        /* Find the search interval */
    
        int start = 0;
        int end = findHigh(times, n);
        // int start = 0; /* when use this the countBook should be long type */
        // int end = Integer.MAX_VALUE;        
        
        /* Binary search */
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (countBook(times, mid) >= n) 
                end = mid;
            else
                start = mid;
        }

        /* Smallest possible */
        if (countBook(times, start) >= n)
            return start;

        return end;
    }

    private int countBook(int[] times, int totalTime) {
        int book = 0;
        for (int time : times) 
            book += totalTime / time;

        return book;
    }
    
    private int findHigh(int[] times, int n) {
        int result = Integer.MAX_VALUE;
        for (int time : times) {
            result = Math.min(time, result);
        }
        result = (n * n) / result;

        return result;
    }
} 