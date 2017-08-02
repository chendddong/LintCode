/*
    Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as
    the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

    Find the number of islands.

    Have you met this question in a real interview? Yes
    Example
    Given graph:

    [
      [1, 1, 0, 0, 0],
      [0, 1, 0, 0, 1],
      [0, 0, 0, 1, 1],
      [0, 0, 0, 0, 0],
      [0, 0, 0, 0, 1]
    ]

    -- LeetCode 200
    -- LintCode 433    
 */

/*
    ® Skill Set: How to convert a 2D point to 1D point

                        mx + y 
        (x, y)  ---------------------> id

                    x = id / m;
                    y = id % m;
        (x, y)  <--------------------- id
        
        m is the total number in a row;
        x is the index of a row, y is the index of a column;

        [
            0 0 0 0                       +++++++++++++++++++++++++++
            0 0 0 0          =======>     |0|1|2|3|4|5|6|7|8|9|10|11|
            0 0 0 0                       |0|0|0|0|0|0|0|0|0|0|0 |0 |
        ]                                 +++++++++++++++++++++++++++
        
 */


/////////
// BFS //
/////////

/* Access the 2D matrix easier */
class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /* The runtime for this is O(m*n)*/
    public int numIslands(boolean[][] grid) {
        /* Edge */
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length; /* # of rows */
        int n = grid[0].length; /* # of columns */
        int islands = 0;

        /* Traverse the entire matrix */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    BFS(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void BFS(boolean[][] grid, int x, int y) {
        /* 
            Because we are accessing four directions of a query point 
                -
              - + -   up left down right 
                -            
         */
        int[] directionX = {0, -1, 0, 1};
        int[] directionY = {1, 0, -1, 0};

        /* BFS */
        ArrayDeque<Coordinate> q = new ArrayDeque<>();
        q.offer(new Coordinate(x, y)); /* Starting point */
        grid[x][y] = false; /* Set the visited point to false */

        while (!q.isEmpty()) {
            Coordinate coor = q.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(coor.x + directionX[i],
                                                coor.y + directionY[i]);
                /* Check whether the newly created point is  */
                if (!isInBound(adj, grid)) {
                    continue;
                }
                if (grid[adj.x][adj.y]) {
                    grid[adj.x][adj.y] = false;
                    q.offer(adj);
                }
            }
        }
    }
    private boolean isInBound(Coordinate adj, boolean[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return  adj.x >= 0 && adj.x < m && adj.y >= 0 && adj.y < n;
    }
}

////////////////
// Union Find //
////////////////

/* Wrap it up in class and use it accordingly; Connecting Graph III */
class UnionFind {
    private int[] father = null;
    private int count;

    /* Initialization */
    public UnionFind(int n) {
        father = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            father[i] = i;
        }
    }
    /* Actions */
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            count--; /* Decrement count for each connection */
        }
    }
    public int query() { /* Since the count is private */
        return count;
    }
    public void set_count(int total) { /* Since the count is private */
        count = total;
    }
    
}

public class Solution {
    public int numIslands(boolean[][] grid) {
        /* Edge */
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }

        /* Get a UnionFind instance*/
        UnionFind uf = new UnionFind(n * m);

        /* Traversal the matrix and find 1 then set total count for UF */
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    count++;
                }
            }
        }
        uf.set_count(count);

        /* 
            Traverse the matrix again and connecting those 1's with adjacent
            node. It's union find so we don't need to care about the duplicates.
            Just convert the 2D to 1D for the use of UnionFind.
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    if (i > 0 && grid[i - 1][j]) {
                        uf.union(i * m + j, (i - 1) * m + j);
                    }
                    if (i < n - 1 && grid[i + 1][j]) {
                        uf.union(i * m + j, (i + 1) * m + j);
                    }
                    if (j > 0 && grid[i][j - 1]) {
                        uf.union(i * m + j, i * m + (j - 1));
                    }
                    if (j < m - 1 && grid[i][j + 1]) {
                        uf.union(i * m + j, i * m + (j + 1));
                    }
                }
            }
        }

        return uf.query();
    }
}

/////////
// DFS //
/////////

public class Solution {
    /* It's much more concise when using DFS */
    private int m; /* Rows */
    private int n; /* Cols */   
    public int numIslands(boolean[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        if (n == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!grid[i][j]) {
                    continue;
                }
                result++;
                DFS(grid, i, j);
            }
        }
        return result;
    }
    private void DFS(boolean[][] grid, int i, int j) {
        /* Base */
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        /* 
            If the point is 1, recursively find it's adjacent 4 point and set
            them to false .
         */
        if (grid[i][j]) {
            grid[i][j] = false;
            DFS(grid, i - 1, j);
            DFS(grid, i + 1, j);
            DFS(grid, i, j - 1);
            DFS(grid, i, j + 1);
        }
    }
}



