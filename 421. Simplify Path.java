/*
Given an absolute path for a file (Unix-style),
simplify it. For example, path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c" click to show corner 
cases. Corner Cases: Did you consider the case where 
path = "/../"? In this case, you should return "/". 
Another corner case is the path might contain multiple 
slashes '/' together, such as "/home//foo/". 
In this case, you should ignore redundant slashes 
and return "/home/foo".
*/
public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
    	String result = "/";
    	String[] stubs = path.split("/+");
    	ArrayList<String> paths = new ArrayList<String>();
    	for (String s : stubs) {
    		if (s.equals("..")) {
    			if (paths.size() > 0) {
    				paths.remove(paths.size() - 1);
    			}
    		} else if (!s.equals(".") && !s.equals("")) {
    			paths.add(s);
    		}
    	}

    	for (String s : paths) {
    		result += s + "/";
    	}

    	if (result.length() > 1) {
    		result = result.substring(0, result.length() - 1);
    	}
    	return result;
    }
}