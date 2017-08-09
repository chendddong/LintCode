/**
 * Given a set of words without duplicates, find all word squares you can build
 * from them.
 */

/*
    A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

    For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

    b a l l
    a r e a
    l e a d
    l a d y

     Notice

    There are at least 1 and at most 1000 words.
    All words will have the exact same length.
    Word length is at least 1 and at most 5.
    Each word contains only lowercase English alphabet a-z.

    Given a set ["area","lead","wall","lady","ball"]
    return [["wall","area","lead","lady"],["ball","area","lead","lady"]]
    Explanation:
    The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).

    Given a set ["abat","baba","atan","atal"]
    return [["baba","abat","baba","atan"],["baba","abat","baba","atal"]]
    Explanation:
    The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 */

/*
    In the industry, Trie data structure can be used as: Type-head in the
    search engine
         
    What's the point
        1. concerning to traverse the character one by one
        2. We need to extract the space complexity
        3. Something about the prefix
        
        
    We should learn these questions by heart：
        1. Number of Islands II
        2. Implement Trie;
        3. Word Search II
 */

////////////////////////
// Trie(prefix) + DFS //
////////////////////////
        
public class Solution {
    class TrieNode {
        List<String> startWith; /* Use this in the DFS later */
        TrieNode[] children;

        TrieNode() {
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void insert(String[] words) {
            for (String w : words) {
                TrieNode cur = root;
                for (char ch : w.toCharArray()) {
                    int idx = ch - 'a';
                    if (cur.children[idx] == null) {
                        cur.children[idx] = new TrieNode();
                    }
                    cur.children[idx].startWith.add(w); /* Track startWith */
                    cur = cur.children[idx];
                }
            }
        }
        List<String> findByPrefix(String prefix) {
            List<String> result = new ArrayList<>();
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                /* If stops before the last char of prefix, return [] */
                if (cur.children[idx] == null) { 
                    return result;
                }
                cur = cur.children[idx]; /* Go down the tree */
            }
            /* Add starWith words */
            result.addAll(cur.startWith);
            return result;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if (words == null || words.length == 0) {
            return ans;
        }

        /* Initializer */
        int len = words[0].length();
        Trie trie = new Trie();
        trie.insert(words);

        /* Traverse each word int the words array */
        List<String> ansBuilder = new ArrayList<>();
        for (String w : words) {
            ansBuilder.add(w);
            /* 
                Go for DFS see if the current ansBuilder fits the 'square', if
                it satisfies the square, add the Builder to ans. If not,
                backtracking, adding another word and do the DFS search all over again.
             */ 
            search(len, trie, ans, ansBuilder); 
            ansBuilder.remove(ansBuilder.size() - 1); /* Backtracking */
        }

        return ans;

    }
    /* DFS */
    private void search(int len, Trie tr,
                        List<List<String>> ans,
                        List<String> ansBuilder) {
        if (ansBuilder.size() == len) {
            ans.add(new ArrayList<>(ansBuilder)); /* Deep copy */
            return;
        }

        int idx = ansBuilder.size();
        StringBuilder prefixBuilder = new StringBuilder();

        for (String s : ansBuilder) {
            prefixBuilder.append(s.charAt(idx));
        }
        List<String> startWith = tr.findByPrefix(prefixBuilder.toString());
        for (String sw : startWith) {
            ansBuilder.add(sw);
            search(len, tr, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }
    }
}