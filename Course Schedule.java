// There are a total of n courses you have to take, labeled from 0 to n - 1.
// Some courses may have prerequisites, for example to take course 0 you have to
// first take course 1,   which is expressed as a pair: [0,1]

// Given the total number of courses and a list of prerequisite pairs, return
// the   ordering of courses you should take to finish all courses.

// There may be multiple correct orders, you just need to return one of them. If
// it is impossible to finish all courses, return an empty array.




public class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List[] edges = new ArrayList[numCourses];
		int[] degrees = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			edges[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < prerequisites.length; i++) {
			degrees[prerequisites[i][0]]++;
			edges[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		

		Queue queue = new LinkedList();
		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] == 0) {
				// offer i
				queue.offer(i);
			}
		}
		// bfs
		int count = 0;
		int[] order = new int[numCourses];
		while (!queue.isEmpty) {
			int course = (int) queue.poll();
			order[count] = course;
			count++;

			// for the connected next courses
			int n = edges[course].size();
			for (int i = 0; i < n; i++) {
				int pointer = (int) edges[course].get(i);
				degrees[pointer]--;
				if (degrees[pointer] == 0) {
					queue.offer(pointer);
				}
			}
		}

		if (count == numCourses) {
			return order;
		}

		return new int[0];
	}
}