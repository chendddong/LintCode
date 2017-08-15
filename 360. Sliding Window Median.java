/*
    Given an array of n integer, and a moving window(size k), move the window
    at each iteration from the start of the array, find the median of the element inside the window at each moving. (If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )
 */

/*
    Example
    For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]

    At first the window is at the start of the array like this

    [ | 1,2,7 | ,8,5] , return the median 2;

    then the window move one step forward.

    [1, | 2,7,8 | ,5], return the median 7;

    then the window move one step forward again.

    [1,2, | 7,8,5 | ], return the median 7;
 */

/*
    There is a remove method for Priority Queue in java, the time
    complexity for that remove is O(n). Whereas, We could use TreeSet to do
    the work and the complexity of the remove method in TreeSet is O(log n) 
    
///////////////////////////////////////////////////////////////////////////////
/// This problem is the fusion of Comparator, TreeSet(Heap), Sliding Window ///
///////////////////////////////////////////////////////////////////////////////

*/

/////////////
// TreeSet //           AC
/////////////

/* This is new class implements Comparable */
class Node implements Comparable<Node> {
    int id;
    int val;
    Node (int ID, int VAL) {
        id = ID;
        val = VAL;
    }
    public int compareTo(Node other) {
        Node a = (Node) other; /* Cast */
        if (this.val == a.val) {
            return this.id - a.id;
        }
        return this.val - a.val;
    }
}
public class Solution {
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k == 0) return result; /* Edge */

        int n = nums.length;
        TreeSet<Node> minHeap = new TreeSet<>();
        TreeSet<Node> maxHeap = new TreeSet<>();

        /* Algorithm walk through */
        // For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]
        // 
        // 
        //          /////////////////  minHeap:  ///////////////////////////
        //          //        (0, 1)<remove>      (1, 2)          (1, 2)  //
        //          //        /      ->>           /      ->>     /       //
        //          //    (1, 2)               (3, 8)         (2, 7)      //
        //          /////////////////  minHeap:  ///////////////////////////
        //                        
        //          /////////////////  maxHeap:  /////////////////  
        //          //        (2, 7)<swap>     (3, 8)           //
        //          //               ->>                        //
        //          /////////////////  maxHeap:  /////////////////          
        // mid = 2;

        int mid = (k + 1) / 2; 
        for (int i = 0; i < k - 1; i++) { /* Add the first k nodes */
            add(minHeap, maxHeap, mid, new Node(i, nums[i]));
        }

        for (int i = k - 1; i < n; i++) { /* Add node, add result, remove */
            add(minHeap, maxHeap, mid, new Node(i, nums[i]));
            result.add(minHeap.last().val);
            /* The index is the key */
            remove(minHeap, maxHeap, new Node(i - k + 1, nums[i - k + 1]));
        }
        return result;
    }
    private void add(TreeSet<Node> minHeap, TreeSet<Node> maxHeap, int size,
        Node node) {
        /* Fill the minHeap first, then the maxHeap */
        if (minHeap.size() < size) {
            minHeap.add(node);
        } else {
            maxHeap.add(node);
        }
        /* Swap Nodes between minHeap & maxHeap */
        if (minHeap.size() == size) {
            if (maxHeap.size() > 0 && minHeap.last().val > maxHeap.first().val) {
                Node s = minHeap.last();
                Node b = maxHeap.first();
                minHeap.remove(s);
                maxHeap.remove(b);
                minHeap.add(b);
                maxHeap.add(s);
            }
        }
    }
    private void remove(TreeSet<Node> minHeap, TreeSet<Node> maxHeap, Node node)
    {
        /* 
            Delete either either of the Heap and the complexity of remove nodes
            in the treeSet is log(n) 
         */
        if (minHeap.contains(node)) {
            minHeap.remove(node);
        } else {
            maxHeap.remove(node);
        }
    }
}

//////////////////
// Normal Heaps //               TLE !!!
//////////////////

public class Solution {
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        /* The Edge will always be associated with the k if there is a k */
        if (nums == null || nums.length < k) return result;

        /* Two Heaps */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1,
            Collections.reverseOrder());

        /* First median */
        int median = nums[0];
        if (k == 1) result.add(median);

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > median) minHeap.offer(nums[i]);
            else maxHeap.offer(nums[i]);

            if (i > k - 1) {
                if (nums[j] > median) minHeap.remove(nums[j]);
                else if (nums[j] < median) maxHeap.remove(nums[j]);
                else median = Integer.MIN_VALUE;
                j++;
            }

            if (medain == Integer.MIN_VALUE) {
                median = minHeap.size() > maxHeap.size() 
                       ? minHeap.poll() : maxHeap.poll();
            } else {
                while (minHeap.size() >= maxHeap.size() + 2) {
                    maxHeap.offer(medain);
                    medain = minHeap.poll();
                }

                while (maxHeap.size() >= minHeap.size() + 1) {
                    minHeap.offer(median);
                    median = maxHeap.poll();
                }
            }

            if (i >= k - 1) {
                result.add(median);
            }
        }
        return result;
    }
}

////////////////////////////////
// Simply sort O(n * k log k) //            TLE
////////////////////////////////

public class Solution {
    public List<Integer> medianSlidingWindow(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        /* Parallel pointers */
        int i = 0, j = k - 1;
        while (i <= nums.length - k && j <= nums.length - 1) {
            int[] window = copyArray(i, k, nums); /* Copy target window */
            Arrays.sort(window);
            if (k % 2 == 1)
                res.add(window[k / 2]);
            else 
                res.add(window[k / 2 - 1]);
            i++;
            j++;
        }        
        return res;
    }
    private int[] copyArray(int l, int k, int[] nums) {
        int[] arr = new int[k];
        int index = 0;
        for (int i = 0; i < k; i++) {
            arr[index++] = nums[l++];
        }
        return arr;
    }
}
