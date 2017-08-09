/*
    Find the number connected component in the undirected graph. Each node in
    the graph contains a label and a list of its neighbors. (a connected
    component (or just component) of an undirected graph is a subgraph in which
    any two vertices are connected to each other by paths, and which is
    connected to no additional vertices in the super graph.)
 */

/*
    Notice

    Each connected component should sort by label.

    Example
    Given graph:

    A------B  C
     \     |  | 
      \    |  |
       \   |  |
        \  |  |
          D   E
    Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}
 */
 
 /**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    HashMap<Integer, Integer> father;
    class UnionFind {
        UnionFind(HashSet<Integer> hashSet) {
            father = new HashMap<>();
            for (int val : hashSet) {
                father.put(val, val);
            }
        }
        int find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }

            int temp = -1;
            int fa = father.get(x);

            while (fa != father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent); /* We updated the latest parent */
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
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        /* Get all the nodes and put them into a HashSet */
        HashSet<Integer> hash = new HashSet<>();
        for (UndirectedGraphNode now : nodes) {
            hash.add(now.label);
            for (UndirectedGraphNode neighbor : now.neighbors) {
                hash.add(neighbor.label);
            }
        }

        /* Use the hashSet to get a UF */
        UnionFind uf = new UnionFind(hash);

        /* Connecting the map */
        for (UndirectedGraphNode node : nodes) {
            for (UndirectedGraphNode neighbor : node.neighbors) {
                int fnode = father.get(node.label);
                int fneighbor = father.get(neighbor.label);
                if (fnode != fneighbor) {
                    uf.union(node.label, neighbor.label);
                }
            }
        }
        return printResult(uf, hash);
    }

    public List<List<Integer>> printResult(UnionFind uf, HashSet<Integer> hash)
    {
        List<List<Integer>> ans = new ArrayList<>();

        HashMap<Integer, List<Integer>> map = new HashMap<>(); /* Fa->child */ 
        for (int node : hash) {
            int fa = uf.find(node);

            if (!map.containsKey(fa)) {
                map.put(fa, new ArrayList<Integer>());
            }
            List<Integer> now = map.get(fa);
            now.add(node);
            map.put(fa, now);
        }

        /* Get those connecting ones and print them out with order */
        for (List<Integer> connecting : map.values()) {
            Collections.sort(connecting);
            ans.add(connecting);
        }

        return ans;
    }
}