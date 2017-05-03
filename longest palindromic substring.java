public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // one way to slove this O(n^2)
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return "";
        }
        int best = 0;
        String result  = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    String sub = helper(i, j, s);
                    if (sub.length() >= best) {
                        best = sub.length();
                        result = sub;
                    }
                }
                
            }
        }
        
        
        return result;
        
    }
    
    public String helper(int start, int end, String s) {
        String sub = s.substring(start, end + 1);
    	// we have to split the string first and use the regex
    	String[] words = sub.toLowerCase().split("[ \n\t\r.,;:!?(){]");
    	StringBuilder sb = new StringBuilder();
    	for (String word : words) {
    		sb.append(word);
    	}
    	String cleanS = sb.toString();

    	int i = 0;
    	int j = cleanS.length() - 1;

    	while (i <= j) {
    		if (cleanS.charAt(i) != cleanS.charAt(j)) {
    			return "";
    		}
    		i++;
    		j--;
    	}

    	return sub;

    }
}

// easy to think

 
 


public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int length = s.length();    
        int max = 0;
        String result = "";

        for(int i = 1; i <= 2 * length - 1; i++){
            int count = 1;
            while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
                count++;
            }
            count--; // there will be one extra count for the outbound #
            if(count > max) {
                result = s.substring((i - count) / 2, (i + count) / 2);
                max = count;
            }
        }
        
        return result;
    }
    
    private char get(String s, int i) {
        if(i % 2 == 0)
            return '#';
        else 
            return s.charAt(i / 2);
    }
}

// less code
 
