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

/////////////////////////
// Backtracking + Trie //           Optimized Solution
/////////////////////////

/*
    Intuitively, start from every cell and try to build a word in the dictionary. Backtracking (dfs) is the powerful way to exhaust every possible ways. Apparently, we need to do pruning when current character is not in any word.

    How do we instantly know the current character is invalid? HashMap?
    How do we instantly know what's the next valid character? LinkedList?
    But the next character can be chosen from a list of characters. "Mutil-LinkedList"?
    Combing them, Trie is the natural choice. Notice that:

    TrieNode is all we need. search and startsWith are useless.
    No need to store character at TrieNode. c.next[i] != null is enough.
    Never use c1 + c2 + c3. Use StringBuilder.
    No need to use O(n^2) extra space visited[m][n].
    No need to use StringBuilder. Storing word itself at leaf node is enough.
    No need to use HashSet to de-duplicate. Use "one time search" trie.

    59ms: Use search and startsWith in Trie class like this popular solution.
    33ms: Remove Trie class which unnecessarily starts from root in every dfs call.
    30ms: Use w.toCharArray() instead of w.charAt(i).
    22ms: Use StringBuilder instead of c1 + c2 + c3.
    20ms: Remove StringBuilder completely by storing word instead of boolean in TrieNode.
    20ms: Remove visited[m][n] completely by modifying board[i][j] = '#' directly.
    18ms: check validity, e.g., if(i > 0) dfs(...), before going to the next dfs.
    17ms: De-duplicate c - a with one variable i.
    15ms: Remove HashSet completely.
    The final run time is 15ms. Hope it helps!
 */
public class Solution {

    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res); 
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
        board[i][j] = c;
    }

    public TrieNode buildTrie(ArrayList<String> words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
           }
           p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }     
}


///////////////////////////////////
// Trie Template Bit slow though //
///////////////////////////////////

public class Solution {

    class TrieNode {
        String s;
        boolean isString;
        HashMap<Character, TrieNode> children;
        public TrieNode() {
            isString = false;
            children = new HashMap<>();
            s = "";
        }
    }
    class Trie {
        private TrieNode root;
        public Trie(TrieNode node) {
            this.root = node;
        }
        /* We are gonna put every Word in the Trie not the matrix */
        public void insert(String s) {
            TrieNode cur = root;
            char[] sArray = s.toCharArray();
            for (int i = 0; i < sArray.length; i++) {
                if (!cur.children.containsKey(sArray[i])) { /* No previous */
                    cur.children.put(sArray[i], new TrieNode());
                }
                cur = cur.children.get(sArray[i]);
            }
            cur.s = s;
            cur.isString = true;
        }
        public boolean find(String s) {
            TrieNode cur = root;
            char[] sArray = s.toCharArray();            
            for (int i = 0; i < sArray.length; i++) {
                if (!cur.children.containsKey(sArray[i])) {
                    return false;
                }
                cur = cur.children.get(sArray[i]);
            }
            return cur.isString;
        }
    }
    public int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void search(char[][] board, int x, int y, TrieNode root,
        ArrayList<String> ans) {
        if (root.isString && !ans.contains(root.s)) {
            /* De-duplicate */
            ans.add(root.s);
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
            || board[x][y] == 0 || root == null) {
            return;
        }
        if (root.children.containsKey(board[x][y])) {
            for (int[] dir : dirs) {
                char cur = board[x][y];
                board[x][y] = 0; /* visited */
                search(board, x + dir[0], y + dir[1], root.children.get(cur),
                    ans);
                board[x][y] = cur;
            }
        }
    }

    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> ans = new ArrayList<String>();

        /* Insert to the Trie root */
        Trie tree = new Trie(new TrieNode());
        for (String word : words){
            tree.insert(word);
        }

        /* Search the whole tree */
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                search(board, i, j, tree.root, ans);
            }
        }
        return ans;
    }    


}

