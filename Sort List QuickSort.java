// Quick Sort version

public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
     *   	            using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
    	if (head == null || head.next == null) {
    		return head;
    	}

    	ListNode mid = findMedian(head); // O(n)
    	
    	ListNode leftDummy = new ListNode(0);
    	ListNode leftTail = leftDummy;
    	ListNode rightDummy = new ListNode(0);
    	ListNode rightTail = rightDummy;
    	ListNode middleDummy = new ListNode(0);
    	ListNode middleTail = middleDummy;

    	while (head != null) {
    		if (head.val < mid.val) {
    			leftTail.next = head;
    			leftTail = head;
    		} else if (head.val > mid.val) {
    			rightTail.next = head;
    			rightTail = head;
    		} else {
    			middleTail.next = head;
    			middleTail = head;
    		}
    		head = head.next;
    	}

    	leftTail.next = null;
    	middleTail.next = null;
    	rightTail.next = null;

    	ListNode left = sortList(leftDummy.next);
    	ListNode right = sortList(rightDummy.next);

    	return concat(left, middleDummy.next, right);
    }

    private ListNode findMedian(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head.next;

    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }

    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
    	ListNode dummy = new ListNode(0);
    	ListNode tail = dummy;

    	tail.next = left; tail = getTail(tail);
    	tail.next = middle; tail = getTail(tail);
    	tail.next = right; tail = getTail(tail);
    	return dummy.next;
    }

    private ListNode getTail(ListNode head) {
    	if (head == null) {
    		return null;
    	}

    	while (head.next != null) {
    		head = head.next;
    	}
    	return head;
    }

}
