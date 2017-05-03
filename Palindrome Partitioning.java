public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
        	return results;
        }
        List<String> partition = new ArrayList<String>();
        int startIndex = 0;
        helper(s, startIndex, partition, results);

        return results;
    }

    public void helper(String s, int startIndex, List<String> partition, List<List<String>> results) {
    	// we partitioned all the character
    	if (startIndex == s.length()) {
    		results.add(new ArrayList<String>(partition));
    		return;
    	}

    	for (int i = startIndex; i < s.length(); i++) {
    		// cut to a substring
     		String subString = s.substring(startIndex, i + 1);
     		// important part
     		if (!isPalindrome(subString)) {
     			continue;
     		}
     		partition.add(subString);
     		helper(s, i + 1, partition, results);
     		partition.remove(partition.size() - 1);
    	}
    }

    //  isPalindrome
    private boolean isPalindrome(String s) {
    	for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
    		if (s.charAt(i) != s.charAt(j)) {
    			return false;
    		}
    	}
    	return true;
    }

}