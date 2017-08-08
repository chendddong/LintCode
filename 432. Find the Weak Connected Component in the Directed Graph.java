/*
    Find the number Weak Connected Component in the directed graph. Each node in
    the graph contains a label and a list of its neighbors. (a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)
 */

/*
    Sort the element in the set in increasing order

    Example
    Given graph:

    A----->B  C
     \     |  | 
      \    |  |
       \   |  |
        \  v  v
         ->D  E <- F
    Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}
 */


/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /* Template except the constructor */
    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap<>();
        UnionFind(HashSet<Integer> hashSet) { /* Assure No duplicates */
            for (Integer now : hashSet) {
                father.put(now, now); /* Fathers are themselves at first */
            }
        }
        int find(int x) { /* Normal find */
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }
        int compressedFind(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            
            int temp = -1;
            int fa = father.get(x);
            
            while (fa != father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }
            return parent;
        }
        void union(int x, int y) {
            int faX = find(x);
            int faY = find(y);
            
            if (faX != faY) {
                father.put(faX, faY);
            }
        }
    }
    
    private List<List<Integer>>  print(HashSet<Integer> hashSet, UnionFind uf) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        
        for (int i : hashSet) {
            
            int fa = uf.find(i);

            /* The map dose not have key fa */
            if (!hashMap.containsKey(fa)) {
                hashMap.put(fa, new ArrayList<Integer>());
            }
            
            /* Get all the children for a single father; update if needed */
            List<Integer> now = hashMap.get(fa);
            now.add(i);
            hashMap.put(fa, now);
        }
        
        /* All the values are just the weak connected component */
        for (List<Integer> now : hashMap.values()) {
            Collections.sort(now);
            ans.add(now);
        }
        
        return ans;
    }

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        
        /* Put every Node in a HashSet and use it to create the UF */
        HashSet<Integer> hashSet = new HashSet<>();
        for (DirectedGraphNode now : nodes) {
            hashSet.add(now.label);
            for (DirectedGraphNode neighbor : now.neighbors) {
                hashSet.add(neighbor.label);
            }
        }
        UnionFind uf = new UnionFind(hashSet);
        
        /* Union those nodes whose father are not the same */
        for (DirectedGraphNode now : nodes) {
            for (DirectedGraphNode neighbor : now.neighbors) {
                int fnow = uf.find(now.label);
                int fneighbor = uf.find(neighbor.label);
                
                if (fnow != fneighbor) {
                    uf.union(now.label, neighbor.label);
                }
            }
        }
        
        /* Get the result */
        return print(hashSet, uf);
    }
}