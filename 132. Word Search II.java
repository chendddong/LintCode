/*
    Given a matrix of lower alphabets and a dictionary. Find all words in the
    dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 

    Example
    Given matrix:
    doaf
    agai
    dcan
    and dictionary:
    {"dog", "dad", "dgdg", "can", "again"}

    return {"dog", "dad", "can", "again"}
 */

/*
    Very Very Very Important:
    
    Just draw the search tree when we are doing the search
    We can do this just by using the DFS, first.

    Then we can transfer the code by using the Trie because the Trie data
    Structure can prune the branches.        
 */

/////////
// DFS //
/////////

public class Solution {
    private static int m;
    private static int n;
    public static ArrayList<String> wordSearchII(char[][] board,
       ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<>();
        if (words == null || words.size() == 0) {
            return result;
        }
        for (String word : words) {
            if (exist(board, word)) {
                result.add(word);
            }    
        }
        return result;
    }
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

        /* Find neighbors */
        boolean result = dfs(board, word, wordIndex + 1, i, j + 1) ||
                dfs(board, word, wordIndex + 1, i - 1, j) ||
                dfs(board, word, wordIndex + 1, i, j - 1) ||
                dfs(board, word, wordIndex + 1, i + 1, j);

        board[i][j] = word.charAt(wordIndex); /* Assign back clever move */
        // board[i][j] ^= 256;
        return result;
    }  
}
