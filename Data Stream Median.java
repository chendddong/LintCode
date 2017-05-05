
// [1,2,3] -- > ArrayList temp

// have a global variable to store the results which was the final return value;

// first temp = [1] put this temp and the in a fuction and it will return the
// meadian;

// now meadian = 1
// results = [1];
// temp = [1,2]; -- > results = [1,1];

// how to get the median of an array? we could just sort the array and find the [(n - 1) / 2]

// inputs : int[] nums
// outputs : int[], we will convert the ArrayList to int[] afterwards

// run time is O(n ^ 2) for the first round traversal

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    ArrayList<Integer> results = new ArrayList<Integer>();
    // test1 [1, 2, 3, 4, 5]
    public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        } 

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                temp.add(nums[j]);
            }
            int median = getMedian(temp);
            results.add(median);
        }

        int total_size = results.size();
        int[] ans = new int[total_size];
        int index = 0;
        for (Integer num : results) {
            ans[index++] = num;
        }
        return ans;
    }

    private int getMedian(ArrayList<Integer> temp) {
        Collections.sort(temp);
        int size = temp.size();
        // [(n - 1) / 2]
        int median = temp.get((size - 1) / 2);
        return median;
    }
}


/* this one is O(n) for the array traversal;
   but the sorting taking like O(nlogn); 
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    ArrayList<Integer> results = new ArrayList<Integer>();
    ArrayList<Integer> temp = new ArrayList<Integer>();

    // test1 [1, 2, 3, 4, 5]
    public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        } 

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            temp.add(nums[i]);
            int median = getMedian(temp);
            results.add(median);
        }

        int total_size = results.size();
        int[] ans = new int[total_size];
        int index = 0;
        for (Integer num : results) {
            ans[index++] = num;
        }
        return ans;
    }

    private int getMedian(ArrayList<Integer> temp) {
        Collections.sort(temp);
        int size = temp.size();
        // [(n - 1) / 2]
        int median = temp.get((size - 1) / 2);
        return median;
    }
}

/* 
Also, we can use the double heap -- minHeap and maxHeap;
the time is O(n) for the traversal and O(logn) for the add.
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
3.  Just draw it and analyse the situations
    -1. always add to max, always return to the max heap
    -2. has something to do with the numberOfElements
4.  Don't forget the getMedian();
*/