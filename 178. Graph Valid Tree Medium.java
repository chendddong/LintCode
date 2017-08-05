/*
    Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
    edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

    For example:

    Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

    Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

    Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

    -- Leet 261
    -- Lint 178
    -- TreeDemo 28    

 */

/*
    e.g. 1:

    3 - 0 - 1 - 4
        |
        2

    e.g. 2:
             4   
             |
         0 - 1 - 2 - 3
             |-------|   
 */

/////////
// BFS //
/////////

public class Solution {
    /* Intuitive BFS solution */
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }

        /* !!!What makes a tree!!! */
        if (edges.length != n - 1) {
            return false;
        }

        /* There are no duplicates so we can use a Set */
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);

        /* BFS */
        ArrayDeque<Integer> q = new ArrayDeque<>();

        /* For checking as well as speeding the algorithm */
        Set<Integer> hash = new HashSet<>();

        q.offer(0);
        hash.add(0);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (Integer connectedNode : graph.get(node)) {
                if (hash.contains(connectedNode)) {
                    continue;
                }
                hash.add(connectedNode);
                q.offer(connectedNode);
            }
        }

        return hash.size() == n;

    }

    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>()); /* Put index and an empty set first
            */
        }

        /* Actually getting the graph */
        for (int[] a : edges) {
            int first = a[0];
            int second = a[1];
            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        return graph;
    }
}

////////////////
// Union Find //
////////////////

public class Solution {
    int[] father = null;
    class UnionFind {
        UnionFind(int n) {
            father = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                father[i] = i;
            }    
        }
        int find(int a) {
            if (father[a] == a) {
                return a;
            }
            father[a] = find(father[a]);
            return father[a];
        }
        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                father[rootA] = father[rootB];
            }
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // if (n <= 0) {
        //     return false;
        // }

        if (edges.length != n - 1) {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
                
        for (int[] arr : edges) {
            if (uf.find(arr[0]) != uf.find(arr[1])) {
                n--;
                uf.union(arr[0], arr[1]);
            }

            /* Or we can check the father first without connecting everyone */
            // if (uf.find(arr[0]) == uf.find(arr[1])) {
            //     return false;
            // }
            // n--;
            // uf.union(arr[0], arr[1]);            
        }
        
        return n == 1;
    }
}



