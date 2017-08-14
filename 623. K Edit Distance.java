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
// Trie + DP //         Comeback later
///////////////

class TrieNode {
    // Initialize your data structure here.
    public TrieNode[] children;
    public boolean hasWord;
    public String str;
    
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        for (int i = 0; i < 26; ++i)
            children[i] = null;
        hasWord = false;
    }

    // Adds a word into the data structure.
    static public void addWord(TrieNode root, String word) {
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode();
            }
            now = now.children[c - 'a'];
        }
        now.str = word;
        now.hasWord = true;
    }
}

public class Solution {

    public List<String> kDistance(String[] words, String target, int k) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++)
            TrieNode.addWord(root, words[i]);

        List<String> result = new ArrayList<String>();

        int n = target.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i)
            dp[i] = i;

        find(root, result, k, target, dp);
        return result;
    }

    public void find(TrieNode node, List<String> result, int k, String target, int[] dp) {
        int n = target.length();

        // dp[i] 表示从Trie的root节点走到当前node节点，形成的Prefix
        // 和 target的前i个字符的最小编辑距离
        if (node.hasWord && dp[n] <= k) {
            result.add(node.str);
        }
        int[] next = new int[n + 1];
        for (int i = 0; i <= n; ++i)
            next[i] = 0;

        for (int i = 0; i < 26; ++i)
            if (node.children[i] != null) {
                next[0] = dp[0] + 1;
                for (int j = 1; j <= n; j++) {
                    if (target.charAt(j - 1) - 'a' == i) {
                        next[j] = Math.min(dp[j - 1], Math.min(next[j - 1] + 1, dp[j] + 1));
                    } else {
                        next[j] = Math.min(dp[j - 1] + 1, Math.min(next[j - 1] + 1, dp[j] + 1));
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



