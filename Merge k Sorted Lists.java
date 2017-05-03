// Merge k sorted linked lists and return it as one sorted list.
// Analyze and describe its complexity.

// Example
// Given lists:

// [
//   2->4->null,
//   null,
//   -1->null
// ],

// return -1->2->4->null.

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 

// Solution #0 Use the heap data structure.

public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */


    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
    	public int compare(ListNode left, ListNode right) {
    		return left.val - right.val;
    	}
    };

    public ListNode mergeKLists(List<ListNode> lists) {  
    	if (lists == null || lists.size() == 0) {
    		return null;
    	}
    	// PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
    	Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
    	// adding the HEADs to the heap
    	for (int i = 0; i < lists.size(); i++) {
    		if (lists.get(i) != null) {
    			heap.add(lists.get(i));
    		}
    	}

    	ListNode dummy = new ListNode(0);
    	// pointer
    	ListNode tail = dummy;
    	while (!heap.isEmpty()) {
    		ListNode head = heap.poll();
    		tail.next = head;
    		tail = head;
    		if (head.next != null) {
    			heap.add(head.next);
    		}
    	}

    	return dummy.next;
    }
}

/* 
Very important ! How to write the comparator and the HEAP
// construct the comparator
// we must use for loop since there could be null
// add all the list to the heap
// compare and add the next to the heap
*/


// Solution #1 Recursive method
public class Solution {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() == 0) {
			return null;
		}
		return mergeHelper(lists, 0, lists.size() - 1);
	}

	private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
		// end of recursion
		if (start == end) {
			return lists.get(start);
		}

		int mid = start + (end - start) / 2;
		ListNode left = mergeHelper(lists, start, mid);
		ListNode right = mergeHelper(lists, mid + 1, end);
		return mergeTwoLists(left, right);
	}

	private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				tail.next = list1;
				tail = list1;
				list1 = list1.next;
			} else {
				tail.next = list2;
				tail = list2;
				list2 = list2.next;
			}
		}

		if (list1 != null) {
			tail.next = list1;
		} else {
			tail.next = list2;
		}

		return dummy.next;
	}
}

/* 
classic recursion steps and the way to merge sorted lists
Very Very Very important
*/
public class Solution {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		while (lists.size() > 1) {
			// for the results
			List<ListNode> new_lists = new ArrayList<ListNode>();
			for (int i = 0; i + 1 < lists.size(); i += 2) {
				ListNode merged_list = merge(lists.get(i), lists.get(i + 1));
				new_lists.add(merged_list)
			}

			if (lists.size() % 2 == 1) {
				new_lists.add(lists.get(lists.size() - 1));
			}
			lists = new_lists;
		}

		return lists.get(0);
	}

	private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        
        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }
        
        return dummy.next;
    }


}

/* 
This is to handle the K lists into half so the runtime should
be NlogK

O - O\
O /   \
	   O
O \   /
O - O/

*/

