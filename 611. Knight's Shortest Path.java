// public class Point {
// 	public int x, y;
// 	public Point() { x = 0; y = 0; }
// 	public Point(int a, int b) { x = a; y = b; }
// }

public class Solution {
	int n, m; // size of the chessboard
	// just draw the thing in the chessboard and we could easily figure that out.
	int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
	int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};

	public int shortestPath(boolean[][] grid, Point source, Point destination) {
		// first to nail some corner cases
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1; 
		}

		n = grid.length;
		m = grid[0].length;

		Queue<Point> queue = new LinkedList<>();
		queue.offer(source);

		int steps = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point point = queue.poll();
				if (point.x == destination.x && point.y == destination.y) {
					return steps;
				}

				for (int direction = 0; direction < 8; direction++) {
					Point nextPoint = new Point(deltaX[direction] + point.x,
						  						deltaY[direction] + point.y);
				// very import to see if the new next point is inbond
				// if there are offer them to the queue
				// if not just coninue; after the offer we are gonna mark that point to
				// barrier

				if (!inBound(nextPoint, grid)) {
					continue;
				}

				queue.offer(nextPoint);
				grid[nextPoint.x][nextPoint.y] = true;				
				}


			}
			steps++;
		}

		return -1;
	}

	public boolean inBound(Point nextPoint, boolean[][] grid) {
		return nextPoint.x >= 0 && nextPoint.x < n && nextPoint.y >= 0 && nextPoint.y
		< m && (grid[nextPoint.x][nextPoint.y] == false);
	}


}