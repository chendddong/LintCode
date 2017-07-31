/**
 * Implement a trie with insert, search, and startsWith methods.
 */

/*
    You may assume that all inputs are consist of lowercase letters a-z.

    Example:

    insert("lintcode")
    search("code")
    >>> false
    startsWith("lint")
    >>> true
    startsWith("linterror")
    >>> false
    insert("linterror")
    search("lintcode)
    >>> true
    startsWith("linterror")
    >>> true
 */

///////////////////////
// Array of TrieNode //
///////////////////////

    /*  
        What can Trie do:
            1. Did the entire word there?
            2. Did the prefix there?

        -----------------------------------------------------------------------
        Comparing Hash and Trie: 

        1. Space complexity Trie is smaller Hash:
            Example : ['a', 'aa', 'aaa', 'aaaa']
        2. Time complexity is actually the same. O(k) where k is the length of
        the string. 
        3. Actions:
            Trie can deal with not only the entire word but also the prefix.
            But Trie is not easy to implement. And we must complete this within
            15 minutes in the interview.
        -----------------------------------------------------------------------                    
     */  

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */

/* 1. TrieNode */
class TrieNode {
    public boolean hasWord;
    private TrieNode[] children;
    
    /* Constructor */
    public TrieNode() {
        children = new TrieNode[26];
        hasWord = false;
    }
    /* Insert */    
    public void insert(String word, int index) {
        if (index == word.length()) {
            this.hasWord = true;
            return;
        }
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index + 1);
    }
    /* Find */    
    public TrieNode find(String word, int index) {
        if (index == word.length()) {
            return this;
        }
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            return null;
        }
        return children[pos].find(word, index + 1);
    }
}

/* 2. Trie class */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        return node != null && node.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix, 0);
        return node != null;
    }
}
