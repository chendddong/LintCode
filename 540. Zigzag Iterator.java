// Given two 1d vectors, implement an iterator to return their elements alternately.

// Example
// Given two 1d vectors:

// v1 = [1, 2]
// v2 = [3, 4, 5, 6]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

public class ZigzagIterator {
    /**
     * @param v1 v2 two 1d vectors
     */

    Queue<Integer> queueV1;
    Queue<Integer> queueV2;
    int swing;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // initialize your data structure here.
        queueV1 = new LinkedList<Integer>();
        queueV2 = new LinkedList<Integer>();
        int swing = 0;
        for (Integer int1 : v1) {
            queueV1.offer(int1);
        }

        for (Integer int2 : v2) {
            queueV2.offer(int2);
        }
    }

    public int next() { 
        int ans;
        if (swing % 2 == 0) {
            if (!queueV1.isEmpty()) {
                ans = queueV1.poll();
                swing++;                 
            } else {
                ans = queueV2.poll();
            }
        } else {
            
            if (!queueV2.isEmpty()) {
                ans = queueV2.poll();
                swing++;                
                
            } else {
                ans = queueV1.poll();
            }
        }
        return ans;
    }

    public boolean hasNext() {
        if (!queueV1.isEmpty() || !queueV2.isEmpty()) {
            return true;
        }
        
        return false;
        
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */



// Use Iterator Version
public class ZigzagIterator {
    public Iterator<Integer> it1;
    public Iterator<Integer> it2;
    public int turns;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.it1 = v1.iterator();
        this.it2 = v2.iterator();
        turns = 0;
    }

    public int next() {
        turns++;
        if ((turns % 2 == 1 && it1.hasNext()) || (!it2.hasNext())) {
            return it1.next();
        } else if ((turns % 2 == 0 && it2.hasNext()) || (!it.hashNext())) {
            return it2.next();
        }

        return -1;
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }
}

/*
The iterator version is way much cleaner than the one by using queue.
*/


