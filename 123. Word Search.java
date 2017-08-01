/**
 * Given a 2D board and a word, find if the word exists in the grid.
 */

/*
    The word can be constructed from letters of sequentially adjacent cell, 
    where "adjacent" cells are those horizontally or vertically neighboring. 
    The same letter cell may not be used more than once.

    Have you met this question in a real interview? Yes
    Example
    Given board =

    [
      "ABCE",
      "SFCS",
      "ADEE"
    ]
    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.
 */

/////////
// DFS //
/////////

public class Solution {
    private static int m;
    private static int n;
    public static boolean exist(char[][] board, String word) {
        /* Edge is bit tricky: */
        if (board == null || board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }

        m = board.length;
        n = board[0].length;
        int wordIndex = 0;
        /* Traverse each Character in the board. Always start with the first */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char wordCh = word.charAt(wordIndex);
                char mapCh = board[i][j];
                if (wordCh == mapCh) {
                    boolean result = dfs(board, word, wordIndex, i, j);
                    /* Find the result */
                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    private static boolean dfs(char[][] board,
                        String word,
                        int wordIndex,
                        int i,
                        int j) {
        if (wordIndex == word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(wordIndex)) {
            return false;
        }

        board[i][j] = '!'; /* Mark temporarily */
        // board[i][j] ^= 256;

        /* 
            Or we could just use a character transformer:
            board[i][j] ^= 256; // after this the number would not be valid

            And we must transfer it back down below.
            
            Example:

            1,0000,0000 ^
            0,0001,0011 =
            1,0001,0011

            1,0001,0011 ^
            1,0000,0000 =
            0,0001,0011         
         */
        
        /* Find neighbors */
        boolean result = dfs(board, word, wordIndex + 1, i, j + 1) ||
                dfs(board, word, wordIndex + 1, i - 1, j) ||
                dfs(board, word, wordIndex + 1, i, j - 1) ||
                dfs(board, word, wordIndex + 1, i + 1, j);

        board[i][j] = word.charAt(wordIndex); /* Assign back clever move */
        // board[i][j] ^= 256;
        return result;
    }
    /* LintCode's test case is wrong.. so I tested on the intelliJ */
    // public static void main(String args[]) {
    //     char[][] board = {
    //                       {'A','B','C','E'},
    //                       {'S','F','C','S'},
    //                       {'A','D','E','E'}
    //                      };
    //     String  word1 = "ABCCED";
    //     String  word2 = "SEE";
    //     String  word3 = "ABCB";
    //     System.out.println(exist(board, word2));
    //    for (char[] chA : board) {
    //        for (char ch : chA) {
    //            System.out.println(ch);
    //        }
    //    }
    // }
}



