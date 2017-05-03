// Implement a data structure, provide two interfaces:

// add(number). Add a new number in the data structure.
// topk(). Return the top k largest numbers in this data 
// structure. k is given when we create the data structure.

// How to use the priority Queue.

public class Solution {
	private int maxSize;
	private Queue<Integer> minheap;

    public Solution(int k) {
    	minheap = new PriorityQueue<>();
    	maxSize = k;
    }

    public void add(int num) {
    	if (minheap.size() < maxSize) {
    		minheap.offer(num);
    		return;
    	}

    	if (num > minheap.peek()) {
    		minheap.poll();
    		minheap.offer(num);
    	}
    }

    public List<Integer> topk() {
        Iterator it = minheap.iterator();
        List<Integer> result = new ArrayList<Integer>();
        while (it.hasNext()) {
        	result.add((Integer) it.next());
        }

        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
};

/* 
When we want to implement a data structure, we always wanna to 
put the things we are gonna use outside those funcitons. For this case
we put PQ outside.

1. when we add that number, we have to consider the size the  priority queue
	if less, add it directly
	else, just compare with the smallest element which is peek(), and if larger then add it

2. the use of the Iterator
	Create : Iteratro it = minheap.iterator();
			// Here dont forget to convert the type of the value
			while (it.hasNext()) {
				result.add((Integer) it.next());
			}
3. Since it's a min heap, we are gonna reverse the whole ArrayList
   with the decending order

   Collections.sort(result, Collections.reverseOrder());
*/ 