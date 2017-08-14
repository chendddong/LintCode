/*
Given a string s and a dictionary of words dict,
add spaces in s to construct a sentence where each word is a valid dictionary 
word. Return all such possible sentences. For example, given s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"]. A solution is ["cats and dog", 
"cat sand dog"].
*/
// the recursive version
public class Solution {
    /**
     * @param s a string
     * @param wordDict a set of words
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
    	Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    	return wordBreakHelper(s, wordDict, map);
    }

    public ArrayList<String> wordBreakHelper(String s, Set<String> wordDict, 
    										 Map<String, ArrayList<String>> memo) {
    	if (memo.containsKey(s)) {
    		return memo.get(s);
    	}

    	ArrayList<String> result = new ArrayList<String>();
    	int n = s.length();
    	if (n <= 0) {
    		return result;
    	}

    	for (int len = 1; len <= n; ++len) {
    		String subfix = s.substring(0, len);
    		if (wordDict.contains(subfix)) {
    			if (len == n) {
    				result.add(subfix);
    			} else {
    				String prefix = s.substring(len);
    				ArrayList<String> tmp = wordBreakHelper(prefix, wordDict, memo);
    				for (String item : tmp) {
    					item = subfix + " " + item;
    					result.add(item);
    				}
    			}
    		}
    	}

    	memo.put(s, result);

    	return result;

    }
}