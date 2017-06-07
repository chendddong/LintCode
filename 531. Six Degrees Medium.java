/**
 * Six degrees of separation is the theory that everyone and everything is six or fewer 
 * steps away, by way of introduction, from any other person in the world, so that a 
 * chain of "a friend of a friend" statements can be made to connect any two people in 
 * a maximum of six steps.
 */

/*
    Given a friendship relations, find the degrees of two people, return -1 if
    they can not been connected by friends of friends.

    Example
    Given a graph:

    1------2-----4
     \          /
      \        /
       \--3--/
    {1,2,3#2,1,4#3,1,4#4,2,3} and s = 1, t = 4 return 2

    Given a graph:

    1      2-----4
                 /
               /
              3
    {1#2,4#3,4#4,2,3} and s = 1, t = 4 return -1
 */
/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        /* corner case */
        if (s == t) {
            return 0;
        }
        /* traverse neighbors of s */
        int degree = 0;
        ArrayDeque<UndirectedGraphNode> queue = new ArrayDeque<>();
        /* We have to record whether the node has been visited coz it's UndirectedGraphNode*/
        HashMap<UndirectedGraphNode, Integer> visited = new HashMap<>();
        queue.offer(s);
        visited.put(s,0);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            /* Get the step of the s line */          
            int step = visited.get(node);
            for (int i = 0; i < node.neighbors.size(); i++) {
                /* Do not visit the node that has been visited already */
                if (visited.containsKey(node.neighbors.get(i))) {
                    continue;
                }   
                visited.put(node.neighbors.get(i), step + 1);
                queue.offer(node.neighbors.get(i));
                /* Found it */
                if (node.neighbors.get(i) == t) {
                    return step + 1;
                }
            }
            
        }
        return -1;
    }
}

/*
    Classic BFS on a <Undirected≥ graph. 
    Always remember to use a Hash map to keep track of the nodes
 */