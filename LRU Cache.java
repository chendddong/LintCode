// Design and implement a data structure for Least Recently Used (LRU) cache. 
// It should support the following operations: get and set.

// get(key) - Get the value (will always be positive) of the key 
// if the key exists in the cache, otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. 
// When the cache reached its capacity, it should invalidate the least 
// recently used item before inserting a new item.

// Solution by jiuzhang
public class Solution {
    
	public class Node {
		Node prev;
		Node next;
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}

	// Outside the method
	private int capacity;
	private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);

    // @param capacity, an integer
    public Solution(int capacity) {
    	this.capacity = capacity;
    	tail.prev = head;
    	head.next = tail;
    }

	// Newest node append to tail.
 	// Eldest node remove from head.
    public int get(int key) {
    	if (!hs.containsKey(key)) {
    		return -1;
    	}

    	// remove current
    	Node current = hs.get(key);
    	current.prev.next = current.next;
    	current.next.prev = current.prev;

    	// move current to tail
    	move_to_tail(current);

    	return hs.get(key).value;

    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
    	// this internal 'get' method would update the key's 
    	// positon int the linked list
    	if (get(key) != -1) {
    		hs.get(key).value = value;
    		return;
    	}

    	if (hs.size() == capacity) {
    		hs.remove(head.next.key);
    		head.next = head.next.next;
    		head.next.prev = head;
    	}

    	Node insert = new Node(key, value);
    	hs.put(key, insert);
    	move_to_tail(insert);


    }

    // Nice usage of head and tail
    private void move_to_tail(Node current) {
    	current.prev = tail.prev;
    	tail.prev = current;
    	current.prev.next =  current;
    	current.next = tail;
    }
}

/*
Because we are creating the data struture, so we would prefer
to contstruct the things outside the main method

Think this through and must go over this.

The head and tail are pretty good in this problem since creating
two variables skips lots of logics
*/