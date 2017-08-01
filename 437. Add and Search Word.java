/*
    Design a data structure that supports the following two operations: addWord
    (word) and search(word)

    search(word) can search a literal word or a regular expression string containing only letters a-z or ..

    A . means it can represent any one letter.

     Notice

    You may assume that all words are consist of lowercase letters a-z.

    Example
    addWord("bad")
    addWord("dad")
    addWord("mad")
    search("pad")  // return false
    search("bad")  // return true
    search(".ad")  // return true
    search("b..")  // return true
 */

/*  
    What can appear in interview in terms of Trie:
        1. Implement the data structure
        2. The Something pertaining the Prefix
        3. DFS + TRIE(Most important one)
*/

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

///////////////////
// Array of Trie //
///////////////////

class TrieNode {
    public TrieNode[] children;
    public boolean hasWord;
    public TrieNode() { /* Assign the initialized children to null */
        children = new TrieNode[26];
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        hasWord = false;
    }
}

public class WordDictionary {
    /* We need a root to manipulate the whole tree */
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    /* Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        int pos;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            /* Put offset in the array */
            pos = wordArray[i] - 'a';
            if (cur.children[pos] == null) {
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos]; /* Go deeper */
        }    
        cur.hasWord = true;
    }

    /* 
        Has been modified comparing to the original template since we have to
        care about the regex thing.
    */
    public boolean find(String word, int index, TrieNode cur) {
        if (index == word.length()) {
            return cur.hasWord;
        }
        Character c = word.charAt(index);
        if (c == '.') { /* Only go to the children where they are not null */
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    if (find(word, index + 1, cur.children[i])){
                        return true;
                    }
                }
            }
            return false;
        } else if (cur.children[c - 'a'] != null) { /* Go deeper */
            return find(word, index + 1, cur.children[c - 'a']);
        } else {
            /* cur.children[c - 'a'] == null */
            return false;
        }
        
        
    }
    /* 
        Returns if the word is in the data structure. A word could contain the
        dot character '.' to represent any one letter. 
     */
    public boolean search(String word) {
        /* Search from the root */
        return find(word, 0, root);
    }
}

