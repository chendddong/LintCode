/*
    Given a big sorted array with positive integers sorted by ascending order.
    The array is so big so that you can not get the length of the whole array
    directly,   and you can only access the kth number by ArrayReader.get(k)   
    (or ArrayReader->get(k) for C++). Find the first index of a target number.  
    Your algorithm should be in O(log k), where k is the first index of the target number.

    Return -1, if the number doesn't exist in the array.

    If you accessed an inaccessible index (outside of the array),
    ArrayReader.get will return 2,147,483,647.

 */

/*
    Example
    Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.

    Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.

 */


/////////////////////////////////////////////
// Solution 1 think about how to get the k //
/////////////////////////////////////////////


/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {

        /* find the number k O(log n)*/
        int k = 1;
        while (reader.get(k - 1) < target) {
            k *= 2;
        }
        
        int start = 0;
        int end = k - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            } else if (reader.get(mid) > target) {
                end = mid;
            } else {
                end = mid;
            }
        }
        
        if (reader.get(start) == target) {
            return start;
        }
        
        if (reader.get(end) == target) {
            return end;
        }
        
        return -1;
        
    }
}

////////////////////////////////////////////
// Solution 2 An alternative way to get K //
////////////////////////////////////////////


/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */

public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        /* find the number k O(log n)*/

        int k = 0;
        if (reader.get(k) < target) {
            k = 1;
        }
        
        while (reader.get(k) < target) {
            k = k * 2 + 1;
        }
        
        int start = 0;
        int end = k ;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            } else if (reader.get(mid) > target) {
                end = mid;
            } else {
                end = mid;
            }
        }
        
        if (reader.get(start) == target) {
            return start;
        }
        
        if (reader.get(end) == target) {
            return end;
        }
        
        return -1;
        
    }
}
