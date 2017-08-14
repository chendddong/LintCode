/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        int m = nodes.size();
        // this is a marker if the node is visited
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        
        // mark all the nodes
        for (UndirectedGraphNode node : nodes) {
            visited.put(node, false);
        }
        List<List<Integer>> result = new ArrayList<>();
        
        // bfs every conponet
        for (UndirectedGraphNode node : nodes) {
            if (visited.get(node) == false) {
                bfs(node, visited, result);
            }
        }
        
        return result;
        
    }
    
    public void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean>
                    visited, List<List<Integer>> result) {
        List<Integer> row = new ArrayList<>();
        Queue<UndirectedGraphNode> queue =  new LinkedList<>();
        // mark it as true before put it into the queue.
        visited.put(node, true);
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode u = queue.poll();
            row.add(u.label);
            for (UndirectedGraphNode v : u.neighbors) {
                if (visited.get(v) == false) {
                    visited.put(v, true);
                    queue.offer(v);
                }
            }
        }
        // as required, we have to sort this before adding this to the queue.
        Collections.sort(row);
        result.add(row);
    }
}