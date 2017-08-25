/*
    You have a number of envelopes with widths and heights given as a pair of
    integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

    What is the maximum number of envelopes can you Russian doll? (put one inside other)
 */

/*
    Example
    Given envelopes = [[5,4],[6,4],[6,7],[2,3]], 
    the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */


/////////////////////////
// Try the brute force //               TLE
/////////////////////////


public class Solution {
    /*
        Time : O(n ^ 2)
        Space : O(n) for dp array
     */
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point a, Point b) {
            if (a.y == b.y && a.x != b.x) {
                return a.x - b.x; /* Ascending */
            } else if (a.y != b.y && a.x == b.x) {
                return a.y - b.y; /* Ascending */
            } else if (a.y == b.y && a.x == b.x){
                return -1;
            } else {
                return a.x - b.x;
            }
        }
    }    

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0; 
        
        /* Sort nlogn Heap */
        PriorityQueue<Point> pq = new PriorityQueue(1, new PointComparator());
        for (int[] envelope : envelopes) {
            Point newPoint = new Point(envelope[0], envelope[1]);
            pq.offer(newPoint);
        }
        
        HashMap<Integer, Point> map = new HashMap<>();
        for (int i = 0; i < envelopes.length; i++) {
            map.put(i, (Point) pq.poll());
        }
        
        /* State : dp[i] is the bigest number of envelopes that we can get */
        int[] dp = new int[envelopes.length];
        
        /* Init */
        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < envelopes.length; i++) {
            Point big = map.get(i);
            for (int j = i - 1; j >= 0 ; j--) {
                Point small = map.get(j);
                if (small.x < big.x && small.y < big.y) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }            
        }
        int max = 0;
        for (int i = 0; i < envelopes.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;

        // 0-> [2,3]    dp:[1]
        // 1-> [5,4]       [2]
        // 2-> [6,4]       [2]
        // 3-> [6,7]       [3]
        
    }
}

/////////////////////
// DP optimization //
/////////////////////

public class Solution {
    /*
        Sort the array. Ascend on width and descend on height if width are
        same.Find the longest increasing subsequence based on height. Since the
        width is increasing, we only need to consider height.

        About sorting:
        [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]       

        The index manipulation is very smart; 

        Time : O(nlogn) for sorting 
        Space : O(n)
     */
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || 
          envelopes[0] == null || envelopes[0].length != 2) return 0;

        /* How to sort is the Key to this problem*/
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
           } 
        });
        // [[2,3]           3
        //  [5,4],          4
        //  [6,7],          7
        //  [6,4],]         0
        int dp[] = new int[envelopes.length];
        int len = 0;

        for(int[] envelope : envelopes){
            /* 
                How to use Binary search function:
                1. array
                2. start
                3. end
                4. target
                Note that Arrays.binarySearch(...)
                Returns:
                    index of the search key, if it is contained in the array within the specified range; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element in the range greater than the key, or toIndex if all elements in the range are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.                    
            */

            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = - (index + 1);
            dp[index] = envelope[1];

            if(index == len) /* The situation we can fill the doll */
                len++;

        }
        return len;
    }
}
