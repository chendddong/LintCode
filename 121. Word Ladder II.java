public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {

    	List<List<String>> ladders = new ArrayList<List<String>>();
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	Map<String, Integer> distance = new HashMap<String, Integer>();

    	dict.add(start);
    	dict.add(end); 

    	bfs(map, distance, start, end, dict);

    	List<String> path = new ArrayList<String>();

    	dfs(ladders, path, end, start, distance, map);

    	return ladders;
    }
    /* start = "hit"
	   end = "cog"
       dict = ["hot","dot","dog","lot","log"]
	    [
	    	["hit","hot","dot","dog","cog"],
	    	["hit","hot","lot","log","cog"]
	  	]
    */
    void bfs(Map<String, List<String>> map,
    				 Map<String, Integer> distance,
    				 String start,
    				 String end,
    				 Set<String> dict) {

    	Queue<String> queue = new LinkedList<String>();
    	queue.offer(start);
    	distance.put(start, 0);
    	// dict = ["hot","dot","dog","lot","log", "hit", "cog"]
    	// distance --> <"hit", 0>

    	for (String s : dict) {
        	// map---->
    		// <"hot", []>, <"dot", []> ...
    		map.put(s, new ArrayList<String>());
    	}

    	while (!queue.isEmpty()) {
    		// crt == "hit"
    		String crt = queue.poll();

    		List<String> nextList = expand(crt, dict);
    		// nextList = ["hot"]
    		for (String next : nextList) {
    			//map --> <"hot", hit>
    			map.get(next).add(crt);
    			if (!distance.containsKey(next)) {
    				distance.put(next, distance.get(crt) + 1);
    				// distance --> <"hit", 0>, <"hot", 1>
    				queue.offer(next);
    			}
    		}
    	}

    }

    // crt == "hit"
    // dict = ["hot","dot","dog","lot","log", "hit", "cog"]
    List<String> expand(String crt, Set<String> dict) {
    	List<String> expansion = new ArrayList<String>();

    	for (int i = 0; i < crt.length(); i++) {
    		for (char ch = 'a'; ch <= 'z'; ch++) {
    			if (ch != crt.charAt(i)) {
    				//"Hello".substring(2, 4) == "ll" 
    				//"Hello".substring(1) == ello
    				// change one letter at a time
    				// ait, bit, ... zit
    				// hat, hbt, ... hzt
    				// hia, hib, ... hiz
    				String expanded = crt.substring(0, i) + ch
    					+ crt.substring(i + 1);
    				if (dict.contains(expanded)) {
    					expansion.add(expanded);
    				}
    			}
    		}
    	}
    	return expansion;
    }

    void dfs(List<List<String>> ladders,
    		    List<String> path,
    		    String crt,
    		    String start,
    		    Map<String, Integer> distance,
    		    Map<String, List<String>> map) {
    	path.add(crt);

    	// weird situation
    	if (crt.equals(start)) {
            // dfs是从end搜到start的，所以搜到的路径是反着的，因此在找到答案的时候，需要reverse，添加完答案后，应该reverse回去
    		Collections.reverse(path);
    		ladders.add(new ArrayList<String>(path));
    		Collections.reverse(path);
    	} else {
    		for (String next : map.get(crt)) {
    			if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
    				dfs(ladders, path, next, start, distance, map);
    			}
    		}
    	}
    	path.remove(path.size() - 1);
    }
}