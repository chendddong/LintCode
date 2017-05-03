/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
    	Map<Integer, Double> answer = new HashMap<Integer, Double>();
    	Map<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>>();

    	for (Record r : results) {
    		// if the student id is not the hash map,
    		// we are gonna put the id into the hash and also
    		// create a LinkedList to store the marks
    		if (!hash.containsKey(r.id)) {
    			hash.put(r.id, new ArrayList<Integer>());
    		}

    		if (hash.get(r.id).size() < 5) {
    			hash.get(r.id).add(r.score);
    		} else {
    			int index = 0;
    			// find the smallest element in the ArrayList
    			for (int i = 1; i < 5; i++) {
    				if (hash.get(r.id).get(i) < hash.get(r.id).get(index)) {
    					index = i;
    				}
    			}
    			// substitute
    			if (hash.get(r.id).get(index) < r.score) {
    				hash.get(r.id).set(index, r.score);
    			}
    		}
    	}

    	
    	for (Map.Entry<Integer, List<Integer>> entry : hash.entrySet()) {
    		int id = entry.getKey();
    		List<Integer> scores = entry.getValue();
    		double average = 0;
    		for (int i = 0; i < 5; i++) {
    			average += scores.get(i);
    		}
    		average /= 5.0;
    		answer.put(id, average);
    	} 

    	return answer;
    }
}


/*
1. The way to acheive is a bit complicated but not hard.
2. It's like a map reduce, we are gonna merge those id(s) and put those records under the 
   same key.
3. find the smallest element index in the ArrayList O(1 * 5)
	int index = 0;
	for (int i = 1; i < 5; i++) {
		if (hash.get(r.id).get(i) < hash.get(r.id).get(index)) {
			index = i;
		}
	}
4. how to get every entry of the map, this seems like an iterator thing.
   for (Map.Entry<Integer, List<Integer>> entry : hash.entrySet()) {
	
   }
*/