/*
    An image is represented by a binary matrix with 0 as a white pixel and 1 as a
    black pixel. The black pixels are connected, i.e., there is only one black region. 
    Pixels are connected horizontally and vertically. Given the location (x, y) of one 
    of the black pixels, return the area of the smallest (axis-aligned) rectangle that
     encloses all black pixels.
 */


/*
    Example
    For example, given the following image:

    [
      "0010",
      "0110",
      "0100"
    ]
    and x = 0, y = 2,
    Return 6.
 */

//////////////////////////////////////////////
// Solution 1 Not Using x, y Too SLow No AC //
//////////////////////////////////////////////


public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        /* Use cast to cast the number in two sides and count those number of
        ones and return the area */

        /* Corner Cases */
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }

        int countRowOnes = 0;
        int countColOnes = 0;
        int flag = 0;

        int n = image.length;
        int m = image[0].length;

        /* for each row we & every number */
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m - 1; ++j) {
                flag = flag | ( Character.getNumericValue(image[i][j]) | Character.getNumericValue(image[i][j + 1]) );
            }
            if (flag == 1) {
                countRowOnes++;
                flag = 0;
            }
        }
        
        flag = 0;
        /* for each col we & every number */
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n - 1; ++j) {
                flag = flag | (Character.getNumericValue(image[j][i]) | Character.getNumericValue(image[j + 1][i]));
            }
            if (flag == 1) {
                countColOnes++;
                flag = 0;
            }
        }

        return countColOnes * countRowOnes;

    }
}

/////////////////////////////////////////////
// Solution 2 Think Symmetrically O(log n) //
/////////////////////////////////////////////



public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        
        int n = image.length;
        int m = image[0].length;
        
        int left = findLeft(image, 0, y);
        int right = findRight(image, y, m - 1);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, n - 1);

        /* test for the final resutl */
        return (right - left + 1) * (bottom - top + 1);
    }
    
    /* Find left Index */
    private int findLeft(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (isEmptyColumn(image, start)) {
            return end;
        }
        
        return start;
    }

    /* Find right Index */
    private int findRight(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (isEmptyColumn(image, end)) {
            return start;
        }
        
        return end;
    }

    /* Find Top Index */
    
    private int findTop(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (isEmptyRow(image, start)) {
            return end;
        }
        
        return start;
    }

    /* Find Bottom Index */
    
    private int findBottom(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (isEmptyRow(image, end)) {
            return start;
        }
        
        return end;
    }
    
    
    private boolean isEmptyColumn(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return false;
            }
        }
        return true;
    }
    
    private boolean isEmptyRow(char[][] image, int row) {
        for (int j = 0; j < image[0].length; j++) {
            if (image[row][j] == '1') {
                return false;
            }
        }
        return true;
    }
}