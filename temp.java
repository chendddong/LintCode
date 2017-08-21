Approach #1 Jarvis Algorithm [Accepted]

Algorithm

The idea behind Jarvis Algorithm is really simple. We start with the leftmost point among the given set of points and try to wrap up all the given points considering the boundary points in counterclockwise direction.

This means that for every point pp considered, we try to find out a point qq, such that this point qq is the most counterclockwise relative to pp than all the other points. For checking this, we make use of orientation() function in the current implementation. This function takes three arguments pp, the current point added in the hull; qq, the next point being considered to be added in the hull; rr, any other point in the given point space. This function returns a negative value if the point qq is more counterclockwise to pp than the point rr.

The following figure shows the concept. The point qq is more counterclockwise to pp than the point rr.

Erect_Fence

From the above figure, we can observe that in order for the points pp, qq and rr need to be traversed in the same order in a counterclockwise direction, the cross product of the vectors \vec{pq}
​pq
​⃗
​​  and \vec{qr}
​qr
​⃗
​​  should be in a direction out of the plane of the screen i.e. it should be positive.

\vec{pq}
​pq
​⃗
​​ x \vec{qr} > 0
​qr
​⃗
​​ >0

\begin{vmatrix} (q_x-p_x) & (q_y-p_y) \\ (r_x-q_x) & (r_y-p_y) \end{vmatrix} > 0
​∣
​∣
​∣
​∣
​​ 
​(q
​x
​​ −p
​x
​​ )
​(r
​x
​​ −q
​x
​​ )
​​ 
​(q
​y
​​ −p
​y
​​ )
​(r
​y
​​ −p
​y
​​ )
​​ 
​∣
​∣
​∣
​∣
​​ >0

(q_x - p_x)*(r_y - q_y) - (q_y - p_y)*(r_x - q_x) > 0(q
​x
​​ −p
​x
​​ )∗(r
​y
​​ −q
​y
​​ )−(q
​y
​​ −p
​y
​​ )∗(r
​x
​​ −q
​x
​​ )>0

(q_y - p_y)*(r_x - q_x) - (r_y - q_y)*(q_x - p_x) < 0(q
​y
​​ −p
​y
​​ )∗(r
​x
​​ −q
​x
​​ )−(r
​y
​​ −q
​y
​​ )∗(q
​x
​​ −p
​x
​​ )<0

The above result is being calculated by the orientation() function.

Thus, we scan over all the points rr and find out the point qq which is the most counterclockwise relative to pp and add it to the convex hull. Further, if there exist two points(say ii and jj) with the same relative orientation to pp, i.e. if the points ii and jj are collinear relative to pp, we need to consider the point ii which lies in between the two points pp and jj. For considering such a situation, we've made use of a function inBetween() in the current implementation. Even after finding out a point qq, we need to consider all the other points which are collinear to qq relative to pp so as to be able to consider all the points lying on the boundary.

Thus, we keep on including the points in the hull till we reach the beginning point.

The following animation depicts the process for a clearer understanding.

1 / 40
Java

public class Solution {
    public int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }
    public boolean inBetween(Point p, Point i, Point q) {
        boolean a = i.x >= p.x && i.x <= q.x || i.x <= p.x && i.x >= q.x;
        boolean b = i.y >= p.y && i.y <= q.y || i.y <= p.y && i.y >= q.y;
        return a && b;
    }
    public List < Point > outerTrees(Point[] points) {
        HashSet < Point > hull = new HashSet < > ();
        if (points.length < 4) {
            for (Point p: points)
                hull.add(p);
            return new ArrayList<Point>(hull);
        }
        int left_most = 0;
        for (int i = 0; i < points.length; i++)
            if (points[i].x < points[left_most].x)
                left_most = i;
        int p = left_most;
        do {
            int q = (p + 1) % points.length;
            for (int i = 0; i < points.length; i++) {
                if (orientation(points[p], points[i], points[q]) < 0) {
                    q = i;
                }
            }
            for (int i = 0; i < points.length; i++) {
                if (i != p && i != q && orientation(points[p], points[i], points[q]) == 0 && inBetween(points[p], points[i], points[q])) {
                    hull.add(points[i]);
                }
            }
            hull.add(points[q]);
            p = q;
        }
        while (p != left_most);
        return new ArrayList<Point>(hull);
    }
}
