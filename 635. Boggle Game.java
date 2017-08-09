/*
    Given a board which is a 2D matrix includes a-z and dictionary dict, find
    the largest collection of words on the board, the words can not overlap in the same position. return the size of largest collection.
 */

/*
     Notice

    The words in the dictionary are not repeated.
    You can reuse the words in the dictionary.

    Example
    Give a board below

    [['a', 'b', 'c'],
     ['d', 'e', 'f'],
     ['g', 'h', 'i']]
    dict = ["abc", "cfi", "beh", "defi", "gh"]
    Return 3 // we can get the largest collection["abc", "defi", "gh"]
 */

/* Come back later though */
class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode('0');
    }

    public void insert(String word) {
        if(word == null || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode(ch);
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }
}

class TrieNode {
    char value;
    boolean isWord;
    TrieNode[] children;

    TrieNode(char v) {
        value = v;
        isWord = false;
        children = new TrieNode[26];
    }
}

public class Solution {

    public int boggleGame(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        List<String> path = new ArrayList<>();
        findWords(result, board, visited, path, 0, 0, trie.root);
        return result.size();
    }

    public void findWords(List<String> result, char[][] board, boolean[][] visited, List<String> words, int x, int y, TrieNode root) {

        int m = board.length;
        int n = board[0].length;
        for (int i = x; i < m; i++) {
            for (int j = y; j < n; j++) {
                List<List<Integer>> nextWordIndexes = new ArrayList<>();
                List<Integer> path = new ArrayList<>();
                getNextWords(nextWordIndexes, board, visited, path, i, j, root);
                for (List<Integer> indexes : nextWordIndexes) {
                    String word = "";
                    for (int index : indexes) {
                        int row = index / n;
                        int col = index % n;
                        visited[row][col] = true;
                        word += board[row][col];
                    }

                    words.add(word);
                    if (words.size() > result.size()) {
                        result.clear();
                        result.addAll(words);
                    }
                    findWords(result, board, visited, words, i, j, root);
                    for (int index : indexes) {
                        int row = index / n;
                        int col = index % n;
                        visited[row][col] = false;
                    }
                    words.remove(words.size() - 1);
                }
            }
            y = 0;
        }
    }
    
    int []dx = {0, 1, 0, -1};
    int []dy = {1, 0, -1, 0};
    private void getNextWords(List<List<Integer>> words, char[][] board,
                              boolean[][] visited, List<Integer> path, int i, int j, TrieNode root) {
        if(i < 0 | i >= board.length || j < 0 || j >= board[0].length
            || visited[i][j] == true || root.children[board[i][j] - 'a'] == null) {
            return;
        }

        root = root.children[board[i][j] - 'a'];
        if(root.isWord) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(i * board[0].length + j);
            words.add(newPath);
            return;
        }

        visited[i][j] = true;
        path.add(i * board[0].length + j);
        for (int k = 0; k < 4; k ++) {
            getNextWords(words, board, visited, path, i + dx[k], j + dy[k], root);
        }
        path.remove(path.size() - 1);
        visited[i][j] = false;
    }
}