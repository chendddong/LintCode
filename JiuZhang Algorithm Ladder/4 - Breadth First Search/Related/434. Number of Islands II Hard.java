/*
    Given a n,m which means the row and column of the 2D matrix and an array of
    pair A( size k). Originally, the 2D matrix is all 0 which means there is only sea in the matrix. The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid matrix[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after each operator.

     Notice

    0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

    Example
    Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].

    return [1,1,2,2].
 */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

///////////////
// UnionFind //
///////////////

public class Solution {
    /*  
        Example:

        Given m = 3, n = 3, operations = [(0,0), (0,1), (1,2), (2,1)]
        Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

        0 0 0
        0 0 0
        0 0 0
        Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

        1 0 0
        0 0 0   Number of islands = 1
        0 0 0
        Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

        1 1 0
        0 0 0   Number of islands = 1
        0 0 0
        Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

        1 1 0
        0 0 1   Number of islands = 2
        0 0 0
        Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

        1 1 0
        0 0 1   Number of islands = 3
        0 1 0
        We return the result as an array: [1, 1, 2, 3]
        
        Other approaches are:

        BFS 
            1. traversal
                2. BFS
        
        DFS
            1. traversal
                2. DFS
                    
    ---------------------------------------------------------------------------    
    
        Actually, we need the number of the connecting block which is the
        UnionFind III template.
                
        Time after using the UF O(k) +  O(n * m)
        Why 1D array. Easy to use !!!

        Note that:

        We can't use UF when there is a deleting because there is information
        lost during the process.
        
    ---------------------------------------------------------------------------            
        When to use UF:
            1. About Union Set
            2. If in the Same Set.
    
        VERY VERY VERY IMPORTANT

        Dive deeply after and draw those things
        
    ---------------------------------------------------------------------------                
     */
    
    /* Convert 2D point to 1D Key-Value map */
    int convertToId(int x, int y, int m) {
        return x * m + y; /* x: row index , y: col index, m: # in one row. */
    }

    /*--- HashMap UnionFind ---*/
    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        UnionFind(int n, int m) { 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int id = convertToId(i, j, m);
                    father.put(id, id);
                }
            }
        }
        int compressedFind(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            /*--- Compressed Finding ---*/            
            int temp = -1; /* Or the MIN_VALUE */
            int fa = x;
            while (fa != father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }
            /*--- Compressed Finding ---*/            
            return parent;
        }
        void union(int x, int y) {
            int parentX = compressedFind(x);
            int parentY = compressedFind(y);
            if (parentX != parentY) {
                father.put(parentX, parentY);
            }
        }
    }
    /*--- HashMap UnionFind ---*/

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<>();
        if (operators == null) {
            return result;
        }           

        /* Initializing */
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int[][] island = new int[n][m];
        UnionFind uf = new UnionFind(n, m);
        int count = 0;

        /* Traverse the operators */
        for (int i = 0; i < operators.length; i++) {
            int x = operators[i].x;
            int y = operators[i].y;

            /* The point is 0 */
            if (island[x][y] != 1) {
                count++;
                island[x][y] = 1;
                int id = convertToId(x, y, m);
                /* 4 adjacent points; Looking up to dx[] and dy[] */
                for (int j = 0; j < 4; j++) {
                    int adjX = x + dx[j];
                    int adjY = y + dy[j];
                    /* See if the point is valid and 1 too */
                    if (0 <= adjX && adjX < n &&
                        0 <= adjY && adjY < m &&
                        island[adjX][adjY] == 1) {
                        int adjID = convertToId(adjX, adjY, m);

                        /* Query */
                        int idFather = uf.compressedFind(id);
                        int adjIDfather = uf.compressedFind(adjID);
                        if (idFather != adjIDfather) {
                            count--;
                            uf.union(id, adjID);
                        }

                    }
                }
            }
            result.add(count);
        }
        return result;
    }
}