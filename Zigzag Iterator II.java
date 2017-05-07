// Follow up Zigzag Iterator: What if you are given k 1d vectors? How well can your code be extended to such cases? The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".

// Example
// Given k = 3 1d vectors:

// [1,2,3]
// [4,5,6,7]
// [8,9]
// Return [1,4,8,2,5,9,3,6,7].


public class ZigzagIterator2 {

    public List<Iterator<Integer>> its;
    public int turns;

    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        this.its = new ArrayList<Iterator<Integer>>();
        for (List<Integer> vec : vecs) {
            if (vec.size() > 0) {
                its.add(vec.iterator());
            }
            turns = 0;
        }
    }

    public int next() {
        int elem = its.get(turns).next();
        if (its.get(turns).hasNext()) {
            turns = (turns + 1) % its.size();
        } else {
            its.remove(turns);
            if (its.size() > 0) {
                turns %= its.size();
            }
        }
        return elem;
    }

    public boolean hasNext() {
        return its.size() > 0;
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */


/*
Sclable is extremely important
*/