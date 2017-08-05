/*
        Given a 2D board containing 'X' and 'O', capture all regions surrounded by
        'X'.

        A region is captured by flipping all 'O''s into 'X''s in that surrounded region.
 */

/*
    Example
    X X X X
    X O O X
    X X O X
    X O X X
    After capture all regions surrounded by 'X', the board should be:

    X X X X
    X X X X
    X X X X
    X O X X

    0, 1, 2, 3
    4, 5, 6, 7     
    8, 9, 10,11
    12,13,14,15
 */

/*
        Given a 2D board containing 'X' and 'O', capture all regions surrounded by
        'X'.

        A region is captured by flipping all 'O''s into 'X''s in that surrounded region.
 */

/*
    Example
    X X X X
    X O O X
    X X O X
    X O X X
    After capture all regions surrounded by 'X', the board should be:

    X X X X
    X X X X
    X X X X
    X O X X
 */






/*
    Algorithm:

    If a 'O' is surrounded by the 'X', that means the 'O' cannot connect to the
    outside layer of the graph(matrix). So what we need to do is to surround the
    original matrix with a layer of 'O' and then set all father of the these
    layer the same value. Then we need to traverse the all 'O' in the matrix,
    and we need to find the 'O' whose father is not the same as the outside
    layer father value. At last we modify them to 'X';       


    //////////////////////////////////////////////////////////////////////////
    No idea why this won't work, come back later for this problem.
    //////////////////////////////////////////////////////////////////////////

 */
// public class Solution {
//     HashMap<Integer, Integer> father;
//     int m, n; /* For row & col */
//     class UnionFind {
//         UnionFind() {
//             father = new HashMap<>();
            
//         }
//         int find(int x) {
//             int parent = father.get(x);
//             if (parent == -1) {
//                 return -1;
//             }
//             while (parent != father.get(parent)) {
//                 parent = father.get(parent);
//             }
//             int fa = x;
//             int temp = Integer.MIN_VALUE;
//             while (fa != father.get(fa)) {
//                 temp = father.get(fa);
//                 father.put(fa, parent);
//                 fa = temp;
//             }
//             return parent;
//         }
//         void union(int x, int y) {
//             int rootX = find(x);
//             int rootY = find(y);
//             if (rootX != rootY) {
//                 father.put(rootX, rootY);
//             }
//         }
//     }

//     public void surroundedRegions(char[][] board) {
//         /* Edge */
//         if (board == null || board.length == 0 || board[0].length == 0) {
//             return;
//         } 

//         /* Initialization */
//         m = board.length;
//         n = board[0].length;        
//         UnionFind uf = new UnionFind();
//         int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (board[i][j] == 'X') {
//                     continue;
//                 }
//                 for (int[] dir : dirs) {
//                     int x = i + dir[0];
//                     int y = j + dir[1];
//                     int id = i * n + j;
//                     int newId = x * n + y;

//                     if (x < 0 || x == m || y < 0 || y == n) {
//                         uf.union(id, newId);
//                     } else if (board[x][y] == 'O') {
//                         uf.union(newId, id);
//                     }
//                 }
//             }
//         }

//         for (int i = 0; i < m; ++i) {
//             for (int j = 0; j < n; ++j) {
//                 if (board[i][j] == 'O' && uf.find(i * n + j) != -1) {
//                     board[i][j] = 'X';
//                 }
//             }
//         }

//     }
// }

//////////////////////////////////////////////////////////////////////////
// No idea why this won't work, come back later for this problem /////////
//////////////////////////////////////////////////////////////////////////

/////////
// BFS //
/////////

public class Solution {
    static final int[] directionX = {1, -1, 0, 0};
    static final int[] directionY = {0, 0, 1, -1};

    static final char FREE = 'F';
    static final char TRAVELED = 'T';

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void surroundedRegions(char[][] board) {
        if (board.length == 0) {
            return;
        }

        int row = board.length;
        int col = board[0].length;

        /* Traverse the boarders and set those 'O' to FREE */ 
        for (int i = 0; i < row; i++) {
            bfs(board, i, 0);
            bfs(board, i, col - 1);
        }
        for (int j = 1; j < col - 1; j++) {
            bfs(board, 0, j);
            bfs(board, row - 1, j);
        }

        /* Setting up the values */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                switch(board[i][j]) {
                    case 'O': /* Set the 'O' to 'X' */
                        board[i][j] = 'X';
                        break;
                    /* Keep those 'O's who can reach out the boarders */
                    case 'F':
                        board[i][j] = 'O'; 
                }
            }
        }
    }

    public void bfs(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(i, j));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            board[cur.x][cur.y] = FREE;
            /* For every neighbor, we choose the right ones to expand */
            for (Node node : expand(board, cur)) {
                q.offer(node);
            }
        }
    }

    private List<Node> expand(char[][] board, Node node) {
        List<Node> expansion = new ArrayList<>();

        for (int i = 0; i < directionX.length; i++) {
            int x = node.x + directionX[i];
            int y = node.y + directionY[i];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                && board[x][y] == 'O') {
                board[x][y] = TRAVELED;
                expansion.add(new Node(x, y));
            }
        }

        return expansion;
    }
}
