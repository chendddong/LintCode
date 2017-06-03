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

//////////////////////////////////////////
// Solution 0 Using temp Running window //
//////////////////////////////////////////

/* 
   this one is O(n) for the array traversal;
   but the sorting taking like O(nlogn); 
*/

public class Solution {
    ArrayList<Integer> medianA = new ArrayList<>();
    ArrayList<Integer> slideA = new ArrayList<>();
    public int[] medianII(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        
        for (int i = 0; i < nums.length; i++) {
            slideA.add(nums[i]);
            medianA.add(getMedian(slideA));
        }
        return copyArray(medianA);
    }
    private int getMedian(ArrayList<Integer> slideA) {
        Collections.sort(slideA);
        return slideA.get((slideA.size() - 1) / 2);
    }
    /* Convert ArrayList to array*/
    private int[] copyArray(ArrayList<Integer> medianA) {
        int[] result = new int[medianA.size()];
        int index = 0;
        for (Integer m : medianA) {
            result[index++] = m;
        }
        return result;
    }
}

/* 
    Just can't pass the test. Blah
*/


////////////////////////////////////
// Solution 1 A tale of Two Heaps //
////////////////////////////////////


/* 
    Also, we can use the double heap -- minHeap and maxHeap;
    the time is O(n) for the traversal and O(log n) for the add.
    But pop only takes O(1). That been said, this is the best way to approach this 
*/

public class Solution {
    private PriorityQueue<Integer> maxHeap, minHeap;
    private int numOfElements = 0;

    public int[] medianII(int[] nums) {
        Comparator<Integer> revCmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer left, Integer right) {
                return right.compareTo(left);
            }
        };

        int cnt = nums.length;
        maxHeap = new PriorityQueue(cnt, revCmp);
        minHeap = new PriorityQueue(cnt);

        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; ++i) {
            addNumber(nums[i]);
            ans[i] = getMedian();
        }
        return ans;
    }

    private void addNumber(int value) {
        maxHeap.add(value);
        if (numOfElements % 2 == 0) {

            if (minHeap.isEmpty()) {
                numOfElements++;
                return;
            }
            else if (maxHeap.peek() > minHeap.peek()) {
                Integer maxHeapRoot = maxHeap.poll();
                Integer minHeapRoot = minHeap.poll();
                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
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

/* 
1.  The same comparator with the reverse order
2.  Priority Queue can take ONE or TWO arguments 
        maxHeap = new PriorityQueue(cnt, revCmp);
        minHeap = new PriorityQueue(cnt);
3.  Just draw it and analyze the situations
    -1. always add to max, always return to the max heap
    -2. has something to do with the numberOfElements
4.  Don't forget the getMedian();
*/

//////////////////////////////
// Solution 3 from JiuZhang //
//////////////////////////////

public class Solution {

    public int[] medianII(int[] nums) {
        if (nums == null) {
            return new int[0];
        }
        
        int[] res = new int[nums.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        /* This should become standard Comparator writing */
        //////////////////////////////////////////////////////////////////
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer> (1, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return y - x;    
            }
        });
        //////////////////////////////////////////////////////////////////
        res[0] = nums[0];
        maxHeap.add(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            int peek = maxHeap.peek();
            if (peek >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            res[i] = maxHeap.peek();
        }
        
        return res;
    }
}

/*
    Solution 3 is more intuitively easy to understand

        /* 
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
        */
 */