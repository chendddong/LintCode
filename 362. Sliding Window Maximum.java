/**
 * Given an array of n integer with duplicate number, and a moving window(size
 * k), move the window at each iteration from the start of the array, find the 
 * maximum number inside the window at each moving.
 */

/*
    Example
    For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]

    At first the window is at the start of the array like this

    [|1, 2, 7| ,7, 8] , return the maximum 7;

    then the window move one step forward.

    [1, |2, 7 ,7|, 8], return the maximum 7;

    then the window move one step forward again.

    [1, 2, |7, 7, 8|], return the maximum 8;
 */


////////////////////////
// ArrayDeque Version //        AC
////////////////////////

/*
    The time complexity for this version is just O(n)
    And the space complexity is O(k)
    
    It's sort like a decreasing stack because we are getting the max number of
    the window. The element in the array just go in and out of the deque once no matter what. So the worst case time complexity is O(2N)
 */
public class Solution {

    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        if (nums.length == 0) return ans; /* Edge */

        /* Put first k - 1 number in the deque */
        for (int i = 0; i < k - 1; i++) {
            putNumberInDeque(deque, nums[i]);
        }

        for (int i = k - 1; i < nums.length; i++) {
            putNumberInDeque(deque, nums[i]);
            ans.add(deque.peekFirst());
            getNumberOutDeque(deque, nums[i - k + 1]);
        }

        return ans;
    }

    /* Walkthrough */

    // [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]
    // 
    // ans = [7, 7, 8] 
    // 
    //                   deque:
    //                   
    //          |     1  2  7  7  8  | 
    //                x  x  x  x  
    //                
    //      first(front)         last(end)     
                                                        
    /* Always put the largest number at the front of the deque */
    private void putNumberInDeque(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offer(num);
    }
    /* 
        Poll the first number of the window if the peekFirst() is equal to the
        last number of the window. 
     */
    private void getNumberOutDeque(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }    
}

////////////////////////////////////////
// Sliding and Sort window O(n*klogk) //      91% TLE
////////////////////////////////////////

public class Solution {

    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < k || nums.length == 0) return res;

        int i; 
        for (i = 0; i <= nums.length - k; i++) {
            int max = getMax(nums, i, i + k - 1);
            res.add(max);
        } 

        return res;
    }
    private int getMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }
}

/////////////////////
// TreeSet version //           AC
/////////////////////


/*
    We could use the heap to do the work, but the running time for the remove is
    not good(O(n)) as the TreeSet(O(log n)). We can use Node data structure to avoid the duplicates in the array.
    
    We will rewrite the comparator to compare the value of the Node, if they are equal, just compare them with the id.
    
    The total time is O(n log k)
 */
 
class Node implements Comparable<Node> {
    int id;
    int val;
    Node(int ID, int VAL) {
        id = ID;
        val = VAL;
    }
    public int compareTo(Node other) {
        Node a = (Node) other;
        if (this.val == a.val) {
            return this.id - a.id;
        }
        return this.val - a.val;
    }
}

public class Solution {

    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res =  new ArrayList<>();
        if (k == 0 || nums.length == 0 || nums == null) return res;

        int n = nums.length;
        TreeSet<Node> maxHeap = new TreeSet<>();

        for (int i = 0; i < k - 1; i++) {
            maxHeap.add(new Node(i, nums[i]));
        }

        for (int i = k - 1; i < n; i++) {
            maxHeap.add(new Node(i, nums[i]));
            res.add(maxHeap.last().val);
            maxHeap.remove(new Node(i - k + 1, nums[i - k + 1]));
        }

        return res;
    }
}
