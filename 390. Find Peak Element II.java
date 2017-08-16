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


///////////////////
// Only climb up //    
///////////////////

/* The worst case big O could be O(m * n) climbing shape is a snake */
class Solution {

    public List<Integer> findPeakII(int[][] A) {
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

    }
}

/////////////////
// Linear Time //
/////////////////

/* 
    Algorithm :
    

 */

class Solution {

    public List<Integer> findPeakII(int[][] A) {

    }
}






