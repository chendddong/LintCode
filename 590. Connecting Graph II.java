

/**
 * Given n nodes in a graph labeled from 1 to n. There is no edges in the graph
 * at beginning.
 */

/*
    You need to support the following method:
    1. connect(a, b), an edge to connect node a and node b
    2. query(a), Returns the number of connected component nodes which include node a.

    Have you met this question in a real interview? Yes
    Example
    5 // n = 5
    query(1) return 1
    connect(1, 2)
    query(1) return 2
    connect(2, 4)
    query(1) return 3
    connect(1, 4)
    query(1) return 3
 */



public class ConnectingGraph2 {
    /*
        father [1,2,3,4,5]
               [1,2,3,4,5]
               
        size  [1,2,3,4,5]
              [1,1,1,1,1]
              
        updated father as well as the size (just updated the father's size)
        for example connecting 2 to 1.
        
        
        When querying the size. Find the father and return the father's size
        
        What can UF do:
            2. find a node's number of connecting block
     */
    


    private int[] father = null;
    private int[] size = null;

    public ConnectingGraph2(int n) {

        /* Re-initialize the array */
        father = new int[n + 1];
        size = new int[n + 1];
        /* 
            Assign the numbers themselves as their father the first time and
            the size just be 1 for each initially 
         */
        for (int i = 1; i < n + 1; ++i) {
            father[i] = i;
            size[i] = 1;
        }
    }
    /* Find */
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }     
    /* Union */
    public void connect(int a, int b) {
        int root_a = find(a); 
        int root_b = find(b); 
        if (root_a != root_b) {
            father[root_a] = root_b;
            /* Only Update the size of the father */
            size[root_b] += size[root_a];
        }
    }    
    /* Search */
    public int query(int a) {
        int root_a = find(a);
        return size[root_a];
    }
}