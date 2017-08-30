/**
 * Given a string s and a dictionary of words dict, determine if s can be break
 * into a space-separated sequence of one or more dictionary words.
 */

/*
    Example
    Given s = "lintcode", dict = ["lint", "code"].

    Return true because "lintcode" can be break as "lint code".
 */

////////////////////
// DP Brute Force //                MLE
////////////////////

public class Solution {
    /*
        MLE because the length of the word could just be around 6. So here we
        have done some redundant work of finding a word which is not quite
        possible.
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        /* State: */
        boolean[] dp = new boolean[n + 1];

        /* Init */
        dp[0] = true; 

        /*  
            Function: 
            s = "abcde"
            from a, ab, ... , abcde
        */
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                String sub = s.substring(j, i);
                if (dict.contains(sub)) {
                    dp[i] = true; /* OR{f[i]} */
                    break;
                }
            }
        }

        return dp[n];
    }
}

/////////////////////
// DP Optimization //       Restrain the max word length and min word length
/////////////////////

public class Solution {

    public boolean wordBreak(String s, Set<String> wordDict) {
        int maxLen = Integer.MIN_VALUE;
        int minLen = Integer.MAX_VALUE;
        for (String str : wordDict) {
            maxLen = Math.max(maxLen, str.length());
            minLen = Math.min(minLen, str.length());
        }
        /* State: dp[i] means if 0th to ith position can be perfectly cut */  
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = minLen; i <= s.length(); i++) {
            /* Two restrictions */
            for (int j = minLen; j <= maxLen && j <= i; j++) { 
                if (!dp[i - j]) continue;
                String tmp = s.substring(i - j, i); /* O(L) */
                if (wordDict.contains(tmp)) { /* O(L) */
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
   
}


///////////////////////////
// Brute Force Recursion //                     TLE
///////////////////////////

/*
    The naive approach to solve this problem is to use recursion and backtracking. For finding the solution, we check every possible prefix of that string in the dictionary of words, if it is found in the dictionary, then the recursive function is called for the remaining portion of that string. And, if in some function call it is found that the complete string is in dictionary, then it will return true.

    Time : O(n^n)
    Space : O(n)
 */

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        return word_Break(s, wordDict, 0);
    }
    
    public boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }
}

/////////////////////////////////
// Recursion with memorization //           Runtime error String too long..
/////////////////////////////////

/*
    In the previous approach we can see that many subproblems were redundant, i.e we were calling the recursive function multiple times for a particular string. To avoid this we can use memorization method, where an array memo is used to store the result of the subproblems. Now, when the function is called again for a particular string, value will be fetched and returned using the memo array, if its value has been already evaluated.

    With memorization many redundant subproblems are avoided and recursion tree is pruned and thus it reduces the time complexity by a large factor.    

    Time complexity : O(n^2) 
    Space complexity : Size of recursion tree can go up to O(n^2)

 */

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) { /* The Boolean[] default is null */
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}

//////////////////////////
// Breadth-First-Search //              STILL TLE
//////////////////////////

/*
    Another approach is to use Breadth-First-Search. Visualize the string as a tree where each node represents the prefix upto index end. Two nodes are connected only if the substring between the indices linked with those nodes is also a valid string which is present in the dictionary. In order to form such a tree, we start with the first character of the given string (say s) which acts as the root of the tree being formed and find every possible substring starting with that character which is a part of the dictionary. Further, the ending index (say ii) of every such substring is pushed at the back of a queue which will be used for Breadth First Search. Now, we pop an element out from the front of the queue and perform the same process considering the string s(i+1,end)s(i+1,end) to be the original string and the popped node as the root of the tree this time. This process is continued, for all the nodes appended in the queue during the course of the process. If we are able to obtain the last element of the given string as a node (leaf) of the tree, this implies that the given string can be partitioned into substrings which are all a part of the given dictionary.

    We could treat this as a problem of two pointers. 
    The first pointer comes from index 0, and the second one is one more of the
    first pointer, and we move the second pointer all the way to the end.
    During the process, if we can find the index where the substring from start
    to end can be found in the dictionary, then we add the index to the queue
    for the next polling.

    Time complexity : O(n^2) For every starting index, the search can continue till the end of the given string.

    Space complexity : O(n). Queue of at most n size is needed.

 */

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.equals("")) return true;
        Deque<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start] == 0) {

                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDict.contains(s.substring(start, end))) {
                        queue.offer(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }

                visited[start] = 1;
            }
        }

        return false;
    }
}
