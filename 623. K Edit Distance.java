/*
    Given a set of strings which just has lower case letters and a target
    string, output all the strings for each the edit distance with the target no greater than k.
 */

/*
    You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character


    Example
    Given words = ["abc", "abd", "abcd", "adc"] and target = "ac", k = 1
    Return ["abc", "adc"]
 */

/* All the possible k are k, k - 1, ..., 0; */

///////////////
// Trie + DP //         Walkthrough later
///////////////

class TrieNode {
    /* Attributes in Trie */
    public TrieNode[] children;
    public boolean hasWord;
    public String str;
    
    /* Initialize the children and the hasWord */
    public TrieNode() {
        children = new TrieNode[26];
        for (int i = 0; i < 26; ++i)
            children[i] = null;
        hasWord = false;
    }

    /* Adds a word into the data structure. */
    static public void addWord(TrieNode root, String word) {
        TrieNode now = root; /* Traverse pointer */

        for(int i = 0; i < word.length(); i++) { /* traverse every char */
            Character c = word.charAt(i);
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode(); /* Create new child */
            }
            now = now.children[c - 'a']; /* Or get the child */
        }
        now.str = word; /* The whole word */
        now.hasWord = true; /* Mark the word */
    }
}

public class Solution {

    public List<String> kDistance(String[] words, String target, int k) {

        TrieNode root = new TrieNode(); /* Need a virtual root */
        for (int i = 0; i < words.length; i++)
            TrieNode.addWord(root, words[i]); /* Add words to the Trie */

        List<String> result = new ArrayList<String>();

        int n = target.length();

        /* 
            State: dp[i] means walking down the trie from the virtual root to
            the current node, the min edit distance between the formed prefix
            and the target's 0 to ith characters.
         */
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i)
            dp[i] = i;

        find(root, result, k, target, dp);
        return result;
    }

    public void find(TrieNode node, List<String> result, int k, String target, int[] dp) {

        int n = target.length();

        if (node.hasWord && dp[n] <= k) { /* Where the answer satisfies */
            result.add(node.str);
        }

        /* Each search we need to create a new dp */
        int[] next = new int[n + 1]; 
        for (int i = 0; i <= n; ++i)
            next[i] = 0;

        for (int i = 0; i < 26; ++i) /* 26 Characters */
            if (node.children[i] != null) {
                next[0] = dp[0] + 1; /* Init */
                for (int j = 1; j <= n; j++) {
                    if (target.charAt(j - 1) - 'a' == i) { /* Matches */
                        next[j] = Math.min(dp[j - 1], Math.min(next[j - 1] + 1,
                            dp[j] + 1)); /* Check two j - 1 check one dp j */
                    } else { /* Does not match */
                        next[j] = Math.min(dp[j - 1] + 1, Math.min(next[j - 1] + 1, dp[j] + 1)); 
                        /* Check two j - 1 check one dp j */
                    }
                }
                find(node.children[i], result, k, target, next);
            }
    }
}

/////////////////
// Brute force //       /* Comeback to this later */
/////////////////

public class Solution {

    public List<String> kDistance(String[] words, String target, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;

        for (String word : words) {
            for (int i = 0; i <= k; i++) {
                if (exist(word, i, target)) {
                    res.add(word);
                }
            }
        }

        return res;
    }
    private boolean exist(String word, int dist, String target) {

    }
}



