/*
    Numbers keep coming, return the median of numbers at every time a new number
    added.

    What's the definition of Median?
    - Median is the number that in the middle of a sorted array. If there are n
    numbers  in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=
    [1,2,3], median is 2. If A=[1,19], median is 1.

    Example
    For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

    For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

    For numbers coming list: [2, 20, 100], return [2, 2, 20].
 */

/* 
    Thoughts
    [1,2,3] -- > ArrayList temp

    have a global variable to store the results which was the final return value;

    first temp = [1] put this temp and the in a function and it will return the
    median;

    now median = 1
    results = [1];
    temp = [1,2]; -- > results = [1,1];

    how to get the median of an array? we could just sort the array and find the [(n - 1) / 2]

    inputs : int[] nums
    outputs : int[], we will convert the ArrayList to int[] afterwards

    run time is O(n ^ 2) for the first round traversal
*/

//////////////////////////////
// Add + Collections.Sort() //
//////////////////////////////

public class Solution {
    List<Integer> median;
    List<Integer> slide;
    public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        median = new ArrayList<>();
        slide  = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            slide.add(nums[i]);
            median.add(getMedian(slide));
        }
        return copyArray(median);
    }
    private int getMedian(List<Integer> slide) {
        Collections.sort(slide);
        return slide.get((slide.size() - 1) / 2);
    }
    /* Convert ArrayList to array*/
    private int[] copyArray(List<Integer> median) {
        int[] res = new int[median.size()];
        for (int i = 0; i < median.size(); i++) {
            res[i] = median.get(i);
        }
        return res;
    }
}

///////////////////////////
// Two Heaps Intuitively //
///////////////////////////

public class Solution {

    public int[] medianII(int[] nums) {
        if (nums == null) return new int[0];
        
        int[] res = new int[nums.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return y - x; // y.compareTo(x);
            }
        });
        
        /* First element */
        res[0] = nums[0];
        maxHeap.add(nums[0]);

        for (int i = 1; i < nums.length; ++i) { /* Starting from index 1 */
            int peek = maxHeap.peek();
            
            if (peek >= nums[i]) 
                maxHeap.add(nums[i]);
            else
                minHeap.add(nums[i]);
                
            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());
            else if (maxHeap.size() < minHeap.size())
                maxHeap.add(minHeap.poll());
            
            /* 
                maxHeap.size() == minHeap.size() || 
                maxHeap.size() - 1 == minHeap.size();
            */ 
           
            res[i] = maxHeap.peek();
        }
        
        return res;
    }
}

/*
    Solution 3 is more intuitively easy to understand

    Steps:

    0. Don't forget add initial value: first result and first in maxHeap
    1. traverse the array peek from the max maxHeap
    2. if num <= peek : add number to max
       else add number to min
    3. if maxHeap.size() > minHeap.size() + 1
            maxPoll
       else if maxHeap.size() < minHeap
            minPoll
    4. result is always from the maxHeap

    Algorithm walk through:
    
        nums = [4, 5, 1, 3, 2, 6, 0]
        res =  [4, 4, 4, 3, 3, 3, 3]

        maxHeap : (Store the median and the value that is smaller than the m)
            3
           / \
          1   2
         /
        0
        minHeap : (Store value that is larger than the current median)
            4
           / \
          5   6    
 */

/////////////////////////
// A tale of Two Heaps //
/////////////////////////


/* 
    Also, we can use the double heap -- minHeap and maxHeap;
    the time is O(n) for the traversal and O(log n) for the add.
    But pop only takes O(1). That been said, this is the best way to approach this. 

    1.  The same comparator with the reverse order
    2.  PriorityQueue can take ZERO or ONE or TWO arguments 
            maxHeap = new PriorityQueue(cnt, revCmp);
            minHeap = new PriorityQueue(cnt);
            minHeap = new PriorityQueue();        
    3.  Just draw it and analyze the situations
        -1. always add to max, always return to the max heap
        -2. has something to do with the numberOfElements
    4.  Don't forget the getMedian();    
*/

public class Solution {
    private PriorityQueue<Integer> maxHeap, minHeap;
    private int numOfElements = 0;
    class reverseComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer left, Integer right) {
            return right - left; // right.compareTo(left);
        }
    }
    public int[] medianII(int[] nums) {
        int cnt = nums.length;
        maxHeap = new PriorityQueue(cnt, new reverseComparator());
        minHeap = new PriorityQueue();
        
        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; ++i) {
            addNumber(nums[i]);
            ans[i] = getMedian();
        }
        return ans;
    }
    private void addNumber(int value) {
        maxHeap.offer(value);
        if (numOfElements % 2 == 0) {
            if (minHeap.isEmpty()) {
                numOfElements++;
                return;
            } else if (maxHeap.peek() > minHeap.peek()) {
                Integer maxHeapRoot = maxHeap.poll();
                Integer minHeapRoot = minHeap.poll();
                maxHeap.offer(minHeapRoot);
                minHeap.offer(maxHeapRoot);
            }
        } else {
            minHeap.add(maxHeap.poll());
        }
        numOfElements++;
    }
    private int getMedian() {
        return maxHeap.peek();
    }
}