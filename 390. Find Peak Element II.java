/**
 * There is an integer matrix which has the following features:
 */

/*
    The numbers in adjacent positions are different.
    The matrix has n rows and m columns.
    For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
    For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
    We define a position P is a peek if:

    A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1]
    && A[j][i] > A[j][i-1]
    Find a peak element in this matrix. Return the index of the peak.

     Notice

    The matrix may contains multiple peeks, find any of them.

    Example
    Given a matrix:

    [
      [1 ,2 ,3 ,6 ,5],
      [16,41,23,22,6],
      [15,17,24,21,7],
      [14,18,19,20,10],
      [13,14,11,10,9]
    ]
    return index of 41 (which is [1,1]) or index of 24 (which is [2,2])

    Solve it in O(n+m) time.

    If you come up with an algorithm that you thought it is O(n log m) or
    O(m log n), can you prove it is actually O(n+m) or propose a similar
    but O(n+m) algorithm?
 */

///////////////////////////////////////////////////////
// Double for loop and then check the four direction //  Got AC on LintCode
///////////////////////////////////////////////////////

/*  
    The runtime for this is O(m * n) since we are visiting only one time for
    each node.

    A slightly better way to search the matrix is to only go up till we hit a
    point where we can't go up anymore. 
    
    The worst case big O could be O(m * n) climbing shape is a snake.
 */

class Solution {
    int[][] board;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public List<Integer> findPeakII(int[][] A) {
        List<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0 || A[0].length == 0) return res;

        board = A;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isPeak(i, j)) {
                    res.add(i);
                    res.add(j);
                    break;
                }
            }
        }

        return res;
    }

    private boolean isPeak(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length)
            {
                return false;
            }

            if (board[nx][ny] > board[row][col]) return false;
        }
        return true;
    }
}

//////////////////////
// Better optimized //              The big O is O(n log n)
//////////////////////

/* 
    Algorithm :
    1. Find the Max value of the middle row as a start.
    2. Go to higher ground (could be up or down in the matrix) from the start
            if there is no higher ground, this point is a peak.
            else we can make sure there is a peak a in one half of the data.
 */
class Solution {

    public List<Integer> findPeakII(int[][] A) {

        List<Integer> ans = new ArrayList<>();
        /* 
            The binary search is bit different from the template since we are
            getting the only one peak not narrow it to a pair that we can
            handle latter.
         */
        int start = 1, end = A.length - 2;
        while (start <= end) {
            int mid = (start + end) / 2;
            int col = find(mid, A); /* Find max of the col */
            if (A[mid][col] < A[mid - 1][col]) {
                end = mid - 1;
            } else if (A[mid][col] < A[mid + 1][col]) {
                start = mid + 1;
            } else if (A[mid][col] > A[mid - 1][col] 
                    && A[mid][col] > A[mid + 1][col]) {
                ans.add(mid);
                ans.add(col);
                break;
            }
        }

        return ans;
    }
    private int find(int start, int[][] A) { /* Linear time */
        int col = 0;
        for (int i = 0; i < A[start].length; i++) {
            if (A[start][i] > A[start][col]) {
                col = i;
            }
        }
        return col;
    }
}


/////////////////
// Linear Time //
/////////////////

/* 
    Algorithm :
    Do the row and col binary search in turn recursively.
    
    VERY VERY VERY IMPORTANT. The fusion of recursion and binary search 
 */

class Solution {

    public List<Integer> findPeakII(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        return binarySearch(1, n - 2, 1, m - 2, A, true);
    }

    private List<Integer> binarySearch(int xl, int xr,
                                       int yl, int yr,
                                       int[][] A,
                                       boolean flag) {
        if (flag) { /* Find peak in a row */
            int mid = (xl + xr) / 2;
            int index = yl;
            for (int i = yl; i <= yr; i++) 
                if (A[mid][i] > A[mid][index]) 
                    index = i;

            if (A[mid - 1][index] > A[mid][index]) 
                return binarySearch(xl, mid - 1, yl, yr, A, !flag);
            else if (A[mid + 1][index] > A[mid][index])
                return binarySearch(mid + 1, xr, yl, yr, A, !flag);
            else 
                return new ArrayList<Integer>(Arrays.asList(mid, index));
        } else { /* Find peak in a col */
            int mid = (yl + yr) / 2;
            int index = xl;
            for (int i = xl; i <= xr; i++) 
                if (A[i][mid] > A[index][mid]) 
                    index = i;

            if (A[index][mid - 1] > A[index][mid]) 
                return binarySearch(xl, xr, yl, mid - 1, A, !flag);
            else if (A[index][mid + 1] > A[index][mid])
                return binarySearch(xl, xr, mid + 1, yr, A, !flag);
            else 
                return new ArrayList<Integer>(Arrays.asList(index, mid));
        }
    }
}






