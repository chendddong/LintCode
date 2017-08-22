/**
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 */

/*
    Return all possible palindrome partitioning of s.

    Example
    Given s = "aab", return:

    [
      ["aa","b"],
      ["a","a","b"]
    ]

    Good practice 
 */


/////////
// DFS //
/////////

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }

        List<String> partition = new ArrayList<>();
        
        partitionHelper(s, 0, partition, results);

        return results;
    }

    /* 
        the definition of the recursion:
        -- put palindrome string start from startIndex to the results
     */
    public void partitionHelper(String s,
                       int startIndex,
                       List<String> partition,
                       List<List<String>> results) {
        /* 
            exit of the recursion 
            partitioned all the character of the s
        */
        if (startIndex == s.length()) { /* Reaching to the last index */
            /* deep copy */
            results.add(new ArrayList<String>(partition));
            return;
        }

        for (int i = startIndex; i < s.length(); ++i) {
            /* substring */
            String subString = s.substring(startIndex, i + 1);
            if (!isPalindrome(subString)) {
                continue;
            }
            partition.add(subString);
            partitionHelper(s, i + 1, partition, results);
            partition.remove(partition.size() - 1);
        }
    }
    /* Two pointer squeeze in the middle; i < j*/
    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

/////////////////
// Solution DP //               Not fully understand though
/////////////////

public class Solution {

    List<List<String>> results;
    boolean[][] isPalindrome;

    public List<List<String>> partition(String s) {
        results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }

        getIsPalindrome(s);
        helper(s, 0, new ArrayList<Integer>());
        
        return results;
    }

    private void getIsPalindrome(String s) {
        int n = s.length();
        isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                isPalindrome[i][j] = (isPalindrome[i + 1][j - 1]) && 
                (s.charAt(i) == s.charAt(j));
            }
        }
    }

    private void helper(String s, int startIndex, List<Integer> partition) {
        if (startIndex == s.length()) {
            addResult(s, partition);
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (!isPalindrome[startIndex][i]) {
                continue;
            }
            partition.add(i);
            helper(s, i + 1, partition);
            partition.remove(partition.size() - 1);
        }
    }

    private void addResult(String s, List<Integer> partition) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < partition.size(); i++) {
            result.add(s.substring(startIndex, partition.get(i) + 1));
            startIndex = partition.get(i) + 1;
        }
        results.add(result);
    }
}
