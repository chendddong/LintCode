public class Solution {
    /**
     * longer but faster
     * @param s: A string
     * @return: A list of lists of string
     * not fully understand the void getIsPalindrome function
     */
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