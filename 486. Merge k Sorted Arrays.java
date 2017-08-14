// clarification

// [1,3,5]
// [2,4,6]
// [0, 8, 9, 10]

// [0,1,2,3,4,5,6,8,9,10]

// inputs int[][]
// outputs int[]

// edge cases
// null -- []
// arrays.length == 0 || arrays[0].length == 0  -- [];

// regular cases
// [1,3,5]
// [2,4,6]
// [0, 8, 9, 10]

// brain -- heap , add k elements in it and then pop() the smallest to the 
// result array
// runtime O(n * m)  space = O(m * n)

class Element {
    public int row, col, val;
    Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    private Comparator<Element> comparator = new Comparator<Element>() {
        public int compare(Element a, Element b) {
            return a.val - b.val;
        }        
    };

    public List<Integer> mergekSortedArrays(int[][] arrays) {
        if (arrays == null) {
            return new ArrayList();
        }
        

        int n = arrays.length;
        int m = arrays[0].length;
        int k = n;
        Queue<Element> pq = new PriorityQueue<Element>(k, comparator);
        List<Integer> result = new ArrayList<Integer>();
        
        // add first 3k elements in the pq
        for (int i = 0 ; i < k ; ++i) {
            if (arrays[i].length > 0) {
                Element element = new Element(i, 0, arrays[i][0]);
                pq.add(element);
            }
        }
        
        while (!pq.isEmpty()) {
            Element element = pq.poll();
            result.add(element.val);
            if (element.col + 1 < arrays[element.row].length) {
                element.col += 1;
                element.val = arrays[element.row][element.col];
                pq.add(element);
            }
            
        }
        
        return result;
        
    }
    
    
}


 
/* 
1.  We need to construct an Element data strucure in order to access every col
and row of the data in the array;

2.  How to write the comparator:
    *Not for this one, we can also override the compare method to fulfill our
    needs.*
    private Comparator<Element> comparator = new Comparator<Element>() {
        public int compare(Element a, Element b) {
            return a.val - b.val;
        }        
    };

3.  We need two arguments for the PriorityQueue <size of the heap, how to store
the heap -- AKA minHeap or MaxHeap>
    Queue<Element> pq = new PriorityQueue<Element>(k, comparator);

4.  How to see if the array is not empty and can still add element to the Heap.
    element.col + 1 < arrays[element.row].length
*/

