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
    ArrayDeque<Integer> deque;
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        deque = new ArrayDeque<>();
        
        if (nums.length == 0) return res; /* Edge */

        /* Put first k - 1 number in the deque */
        for (int i = 0; i < k - 1; i++) {
            addToDeque(nums[i]);
        }
        
        for (int i = k - 1; i < nums.length; i++) {
            addToDeque(nums[i]);
            res.add(deque.peekFirst());
            removeFromDeque(nums[i - k + 1]);
        }
        
        return res;    
    }
    /* Always put the largest number at the front of the deque */    
    private void addToDeque(int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offer(num);
    }
    /* 
        Poll the first number of the window if the peekFirst() is equal to the
        last number of the window. 
     */    
    private void removeFromDeque(int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }
}
