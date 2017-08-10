
67













        
        
        
         
                        cur.children[idx] = new TrieNode();
                        List<List<String>> ans,
                        List<String> ansBuilder) {
                    cur = cur.children[idx];
                    cur.children[idx].startWith.add(w); /* Track startWith */
                    if (cur.children[idx] == null) {
                    int idx = ch - 'a';
                    return result;
                    }
                /* If stops before the last char of prefix, return [] */
                backtracking, adding another word and do the DFS search all over again.
                cur = cur.children[idx]; /* Go down the tree */
                for (char ch : w.toCharArray()) {
                Go for DFS see if the current ansBuilder fits the 'square', if
                if (cur.children[idx] == null) { 
                int idx = ch - 'a';
                it satisfies the square, add the Builder to ans. If not,
                TrieNode cur = root;
                }
                }
             */ 
            /* 
            /* Add starWith words */
            ans.add(new ArrayList<>(ansBuilder)); /* Deep copy */
            ansBuilder.add(sw);
            ansBuilder.add(w);
            ansBuilder.remove(ansBuilder.size() - 1);
            ansBuilder.remove(ansBuilder.size() - 1); /* Backtracking */
            children = new TrieNode[26];
            for (char ch : prefix.toCharArray()) {
            for (String w : words) {
            List<String> result = new ArrayList<>();
            prefixBuilder.append(s.charAt(idx));
            result.addAll(cur.startWith);
            return ans;
            return result;
            return;
            root = new TrieNode();
            search(len, tr, ans, ansBuilder);
            search(len, trie, ans, ansBuilder); 
            startWith = new ArrayList<>();
            TrieNode cur = root;
            }
            }
        /* Initializer */
        /* Traverse each word int the words array */
        1. concerning to traverse the character one by one
        1. Number of Islands II
        2. Implement Trie;
        2. We need to extract the space complexity
        3. Something about the prefix
        3. Word Search II
        for (String s : ansBuilder) {
        for (String sw : startWith) {
        for (String w : words) {
        if (ansBuilder.size() == len) {
        if (words == null || words.length == 0) {
        int idx = ansBuilder.size();
        int len = words[0].length();
        List<List<String>> ans = new ArrayList<>();
        List<String> ansBuilder = new ArrayList<>();
        List<String> findByPrefix(String prefix) {
        List<String> startWith = tr.findByPrefix(prefixBuilder.toString());
        List<String> startWith; /* Use this in the DFS later */
        return ans;
        StringBuilder prefixBuilder = new StringBuilder();
        Trie trie = new Trie();
        Trie() {
        trie.insert(words);
        TrieNode root;
        TrieNode() {
        TrieNode[] children;
        void insert(String[] words) {
        }
        }
        }
        }
        }
        }
        }
        }
        }
     Notice
    /* DFS */
    All words will have the exact same length.
    class Trie {
    class TrieNode {
    Each word contains only lowercase English alphabet a-z.
    Explanation:
    Explanation:
    Given a set ["abat","baba","atan","atal"]
    Given a set ["area","lead","wall","lady","ball"]
    In the industry, Trie data structure can be used as: Type-head in the
    private void search(int len, Trie tr,
    public List<List<String>> wordSquares(String[] words) {
    return [["baba","abat","baba","atan"],["baba","abat","baba","atal"]]
    return [["wall","area","lead","lady"],["ball","area","lead","lady"]]
    search engine
    The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
    The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
    There are at least 1 and at most 1000 words.
    We should learn these questions by heart：
    What's the point
    Word length is at least 1 and at most 5.
    }
    }
    }
    }
 */
 */
/*
// Trie(prefix) + DFS //
////////////////////////
////////////////////////
9**************
public class Solution {
}