// Design and implement a TwoSum class. It should support the following operations: add and find.
// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.

// Example
// add(1); add(3); add(5);
// find(4) // return true
// find(7) // return false

// Solution #0 first glance since the add is dynamic, we'd better use some data structure which is dynamic
// Here I decide to use ArrayList and the add time is O(1) and the find time is O(n)
public class TwoSum {
	private ArrayList<Integer> data;
	private HashMap<Integer, Integer> map;

    // Add the number to an internal data structure.
    public void add(int number) {
    	if (data == null) {
    		data = new ArrayList<Integer>();
    	}
    	data.add(number);
    }
    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
    	if (data.size() < 2 || data == null) {
    		return false;
    	}
    	map = new HashMap<Integer, Integer>();
        for (int i = 0; i < data.size(); i++) {
            if (map.get(data.get(i)) != null) {
            	return true;
            }
            map.put(value - data.get(i), i);
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
/* 
This is almost the same as the two pointer without the return value.

So the crucial part is to use hash map to detect whether there are two numbers that can sum up to value.
1. create hash
2. for loop the data structure size
3. put the difference and the index into the map
4. If map.get(data.get(i)) != null means that there are two numbers that can be added up to the sum
*/

// Solution #1 by jiuzhang

public class TwoSum {

    private List<Integer> list = null;
    private Map<Integer, Integer> map = null;


    public TwoSum() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
            list.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for (int i = 0; i < list.size(); i++) {
            int num1 = list.get(i), num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) || 
                (num1 != num2 && map.containsKey(num2))) 
                return true;
        }
        return false;
    }
}

/* 
1. Always istantiate data structures first before the method.
*/