public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int count = 0, candidate = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            } else if (candidate == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}


public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int n = nums.size();
        int line = n / 2;
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < n; i++) {
            if (hash.containsKey(nums.get(i))) {
                hash.put(nums.get(i), hash.get(nums.get(i)) + 1);
                continue;
            }
            hash.put(nums.get(i), 1);
        }
        
        Iterator it = hash.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if ((int)pair.getValue() > line) {
                return (int)pair.getKey();
            }
            
            it.remove(); 
        }
        
        return 0;
    }
}

// [1,2,3,4,5,1,1,1,1] size 9 there are 5 1s in the array this will return 
/*
The use of iterator and the use of hashtable;
*/
