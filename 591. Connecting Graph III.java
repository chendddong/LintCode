/**
 * Given n nodes in a graph labeled from 1 to n. There is no edges in the graph
 * at beginning.
 */

/*
    You need to support the following method:
    1. connect(a, b), an edge to connect node a and node b
    2. query(), Returns the number of connected component in the graph

    Have you met this question in a real interview? Yes
    Example
    5 // n = 5
    query() return 5
    connect(1, 2)
    query() return 4
    connect(2, 4)
    query() return 3
    connect(1, 4)
    query() return 3
 */


public class ConnectingGraph3 {
    /*
        We will just add another variable CountBlock
            When connecting two nodes, just let CountBlock decrement;
        
        What can UF do
            3.  What are the total connecting block 
            
        Summary:
        
            Generic:
                1. Union
                2. Find
            Evolution:
                1. Checking the number of element in a set for a given element
                2. Checking the number of sets
     */
    
    private int[] father = null;
    private int countSet;
    public ConnectingGraph3(int n) {
        father = new int[n + 1];
        countSet = n;
        for (int i = 1; i < n + 1; ++i) {
            father[i] = i;
        }
    }

    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }

    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
            countSet--;
        }
    }
        
    public int query() {
        return countSet;
    }
}