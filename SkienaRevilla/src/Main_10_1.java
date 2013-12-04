// Problem: Freckles
// Status: WA

import java.util.*;
import static java.lang.Math.*;

public class Main_10_1 {

    static class Point implements Comparable<Point> {
        double x, y, distance;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
            this.distance = Double.MAX_VALUE;
        }

        @Override
        public int compareTo(Point o) {
            return Double.compare(distance, o.distance);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            Point[] points = new Point[in.nextInt()];
            for (int j = 0; j < points.length; j++) {
                points[j] = new Point(in.nextDouble(), in.nextDouble());
            }
            System.out.printf("%.2f%n", solve(points));
            if (i < t - 1) {
                System.out.println();
            }
        }
    }

    static double solve(Point[] points) {
        Queue<Point> queue = new PriorityQueue<Point>();
        Set<Point> visited = new HashSet<Point>();
        double sum = 0;
        points[0].distance = 0;
        queue.add(points[0]);

        while (!queue.isEmpty()) {
            Point u = queue.poll();
            if (visited.contains(u)) {
                continue;
            }
            sum += u.distance;
            visited.add(u);
            for (Point v : points) {
                if (!visited.contains(v)) {
                    double dist = sqrt(pow(u.x - v.x, 2) + pow(u.y - v.y, 2));
                    if (dist < v.distance) {
                        v.distance = dist;
                        queue.add(v);
                    }
                }
            }
        }
        return sum;
    }

}
