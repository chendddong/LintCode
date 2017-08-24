/*
    Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as
    barrier) with a source position, find the shortest path to a destination position, return the length of the route. 
    Return -1 if knight can not reached.
 */

/*
     Notice

    source and destination must be empty.
    Knight can not enter the barrier.

    Clarification
    If the knight is at (x, y), he can get to the following positions in one step:

    (x + 1, y + 2)
    (x + 1, y - 2)
    (x - 1, y + 2)
    (x - 1, y - 2)
    (x + 2, y + 1)
    (x + 2, y - 1)
    (x - 2, y + 1)
    (x - 2, y - 1)
    Example
    [[0,0,0],
     [0,0,0],
     [0,0,0]]
    source = [2, 0] destination = [2, 2] return 2

    [[0,1,0],
     [0,0,0],
     [0,0,0]]
    source = [2, 0] destination = [2, 2] return 6

    [[0,1,0],
     [0,0,1],
     [0,0,0]]
    source = [2, 0] destination = [2, 2] return -1

 */

//////////
// BFS  //
//////////

public class Solution {
    /* Note that the class Point is given */
    int n, m; /* size of the chessboard */
    
    int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
    int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        /* Edge */
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1; 
        }

        n = grid.length;
        m = grid[0].length;

        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.offer(source);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                /* Stopping point */
                if (point.x == destination.x && point.y == destination.y) {
                    return steps;
                }

                for (int direction = 0; direction < 8; direction++) {
                    Point nextPoint = new Point(deltaX[direction] + point.x,
                                                deltaY[direction] + point.y);

                    if (!inBound(nextPoint, grid)) { /* Not in bound */
                        continue;
                    }
                    queue.offer(nextPoint);
                    grid[nextPoint.x][nextPoint.y] = true; /* travel once */ 
                }
            }
            steps++; /* Steps increment after the each level */
        }

        return -1;
    }

    public boolean inBound(Point nextPoint, boolean[][] grid) {
        return nextPoint.x >= 0 && nextPoint.x < n && nextPoint.y >= 0 && nextPoint.y
        < m && (grid[nextPoint.x][nextPoint.y] == false);
    }
}
