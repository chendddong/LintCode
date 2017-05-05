// Given an integer array, find the top k largest numbers in it.

// [3,2,6,1,5,8] -> k = 3 -> [8, 6, 5];
// [] || null || k > length -> []

// inputs : int[] array, int k
// outputs : int[] result

// way to approach use priorityQueue
// traverse all the number in the nums
// return the k largest
//      6
//  2       3
class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return new int[0];
        }
        
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer left, Integer right) {
                // return left.compareTo(right);
                if(left > right) {
                    return 1;
                } else if(left < right) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        int[] result = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, comparator);
        for (Integer num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }  
        }
        // yeap we have to pull it out
        for (int i = 0; i < result.length; i++) {
             result[k - i - 1] = pq.poll();
        }
        return result;
    }
}

/* 
1.  The reason to use minHeap
2.  The comparator
3.  The minHeap can't auto delete or test the capacity, we have to do it
manually.
        for (Integer num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }  
        }
4. Use for to traverse at last for every index.
*/