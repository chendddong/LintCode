

public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    int HUMAN = 0;
    int ZOMBIE = 1;
    int BARRIER = 2;
    int n, m; // the matrix
    
    int[] coorX = {1, 0, 0, -1};
    int[] coorY = {0, 1, -1, 0};
    
    public int zombie(int[][] grid) {
        // get all the numbers of the H,Z,B
        // corner cases
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        n = grid.length;
        m = grid[0].length;
        
        int h = 0; // number of human
        int days = 0;
        
        Queue<Coordinate> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == HUMAN) {
                    h++;
                } else if (grid[i][j] == ZOMBIE) {
                    q.offer(new Coordinate(i,j));
                }
            }
        }
        
        // no human from the start
        if (h == 0) {
            return 0;
        }

        while (!q.isEmpty()) {
            days++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Coordinate z = q.poll();
                for (int j = 0; j < 4; j++) {
                    Coordinate nextZ = new Coordinate(coorX[j] + z.x, coorY[j] + z.y);
                    
                    if (!inBound(nextZ, grid)) {
                        continue;
                    }
                    
                    grid[nextZ.x][nextZ.y] = ZOMBIE;
                    h--;
                    
                    if (h == 0) {
                        return days;
                    }

                    q.offer(nextZ);
                }
                
                 
            }
            
            
        }
        
        if (h == 0) {
            return days;
        }
        
        return -1;
    }
    
    public boolean inBound(Coordinate nextZ, int[][] grid) {
        return nextZ.x >= 0 && nextZ.x < n && nextZ.y >= 0 && nextZ.y < m &&
               (grid[nextZ.x][nextZ.y] == HUMAN);
    }
    
    public class Coordinate {
    int x;
    int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
    }
    }
}