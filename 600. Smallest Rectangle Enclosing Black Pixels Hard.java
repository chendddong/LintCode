/*
    An image is represented by a binary matrix with 0 as a white pixel and 1 as
    a black pixel. The black pixels are connected, i.e., there is only one
    black region. 
    
    Pixels are connected horizontally and vertically. Given the location (x,y)
    of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
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

/*
    An image is represented by a binary matrix with 0 as a white pixel and 1 as
    a black pixel. The black pixels are connected, i.e., there is only one
    black region. 
    
    Pixels are connected horizontally and vertically. Given the location (x,y)
    of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
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

///////////////////////////////////////////
// Search all points then update l r t b //             AC O(n ^ 2)
///////////////////////////////////////////

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int top = x, bottom = x;
        int left = y, right = y;
        for (x = 0; x < image.length; ++x) {
            for (y = 0; y < image[0].length; ++y) {
                if (image[x][y] == '1') {
                    top = Math.min(top, x);
                    bottom = Math.max(bottom, x + 1);
                    left = Math.min(left, y);
                    right = Math.max(right, y + 1);
                }
            }
        }
        return (right - left) * (bottom - top);
    }
}

//////////////////////////////////////////////////
// Use bit Or to see if certain row / col has 1 //           AC O(n ^ 2)
//////////////////////////////////////////////////


public class Solution {

    public int minArea(char[][] image, int x, int y) {
        /* Use cast to cast the number in two sides and count those number of
        ones and return the area */
  
        /* Corner Cases */
        if (image == null || image.length == 0) {
            return 0;
        }
        
        /* Just one row */
        int count = 0;
        if (image.length == 1) {
            for (int i = 0; i < image[0].length; i++) {
                if (image[0][i] == '1') {
                    count++;
                }
            }
            
            return count;
        }
        
        /* Just one col */        
        if (image[0].length == 1) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][0] == '1') {
                    count++;
                }
            }
            
            return count;
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


///////////////////////
// Condensed Version //         AC O(log n)
///////////////////////

public class Solution {
    char[][] board = null;
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) 
            return 0;
        
        board = image;
        int n = image.length;
        int m = image[0].length;
        
        /* Left, right, top, bottom */
        int l = find(0, y, 'l');
        int r = find(y, m - 1, 'r');
        int t = find(0, x, 't');
        int b = find(x, n - 1, 'b');
        
        return (r - l + 1) * (b - t + 1);
    }
    private int find(int start, int end, char x) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (x == 'l' || x == 't') {
                if (isEmpty(mid, x)) 
                    start = mid;
                else 
                    end = mid;                
            } else { /* x == 'r || x == 'b' */
                if (isEmpty(mid, x)) 
                    end = mid;
                else
                    start = mid;
            }
        }
        
        if (x == 'l' || x == 't') {
            if (isEmpty(start, x))
                return end;
            return start;             
        } else { /* x == 'r' || x == 'b' */
            if (isEmpty(end, x))
                return start;
            return end;              
        }
       
    }    
    private boolean isEmpty(int index, char x) {
        if (x == 'l' || x == 'r') {
            for (int i = 0; i < board.length; i++) {
                if (board[i][index] == '1')
                    return false;
            }
            return true;
        } else { /* x == 't' || x == 'b' */
            for (int i = 0; i < board[0].length; i++) {
                if (board[index][i] == '1')
                    return false;
            }
            return true;
        }
    }
 
}

//////////////////////////////////
// Think Symmetrically O(log n) //            AC O(log n)
//////////////////////////////////

public class Solution {
    char[][] board = null;
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) 
            return 0;
        
        board = image;
        int n = image.length;
        int m = image[0].length;
        
        int left = findLeft(0, y);
        int right = findRight(y, m - 1);
        int top = findTop(0, x);
        int bottom = findBottom(x, n - 1);
        
        return (right - left + 1) * (bottom - top + 1);
    }
    private int findLeft(int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(mid)) 
                start = mid;
            else 
                end = mid;
        }
        
        if (isEmptyColumn(start))
            return end;
            
        return start;
    }
    private int findRight(int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(mid)) 
                end = mid;
            else 
                start = mid;
        }
        if (isEmptyColumn(end))
            return start;
            
        return end;
    }    
    private int findTop(int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(mid))
                start = mid;
            else 
                end = mid;
        }
        if (isEmptyRow(start))
            return end;
        
        return start;
    }
    private int findBottom(int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(mid)) 
                end = mid;
            else 
                start = mid;
        }
        if (isEmptyRow(end))
            return start;
        
        return end;
    }    
    private boolean isEmptyColumn(int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == '1')
                return false;
        }
        return true;
    }
    private boolean isEmptyRow(int row) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == '1')
                return false;
        }
        return true;
    }    
}