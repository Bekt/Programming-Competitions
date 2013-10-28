// Problem: The Tourist Guide
// Status: WA

import java.awt.*;
import java.util.*;
import java.util.List;
import static java.lang.Math.*;

public class Main_9_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int scenario = 1;
        int n, r;
        while (in.hasNext() && (n = in.nextInt()) + (r = in.nextInt()) > 0) {
            List<List<Point>> graph = new ArrayList<List<Point>>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<Point>());
            }
            for (int i = 0; i < r; i++) {
                int c1 = in.nextInt(), c2 = in.nextInt(), d = in.nextInt();
                List<Point> edge = graph.get(c1);
                edge.add(new Point(c2, d));
                edge = graph.get(c2);
                edge.add(new Point(c1, d));
            }
            int s = in.nextInt(), t = in.nextInt(), c = in.nextInt();
            System.out.println("Scenario #" + scenario++);
            System.out.println("Minimum Number of Trips = " + solve(graph, s, t, c));
            System.out.println();
        }
    }

    static int solve(List<List<Point>> graph, int source, int target, int size) {
        if (source == target) {
            return 0;
        }
        Map<Integer, Node> queued = new HashMap<Integer, Node>();
        Queue<Node> queue = new PriorityQueue<Node>();

        Node n = new Node(source, Integer.MIN_VALUE, -1);
        queued.put(source, n);
        queue.add(n);

        List<Point> s = graph.get(source);
        for (Point p : s) {
            n = new Node(p.x, p.y, source);
            queued.put(p.x, n);
            queue.add(n);
        }

        n = queue.poll();
        while (n.id != target) {
            for (Point p : graph.get(n.id)) {
                Node node = queued.get(p.x);
                if (node != null) {
                    if (node.prev == n.id) {
                        continue;
                    }
                    node.capacity = min(n.capacity, p.y);
                    // Update keys
                    Node temp = queue.poll();
                    queue.add(temp);
                } else {
                    node = new Node(p.x, min(n.capacity, p.y), n.id);
                    queued.put(p.x, node);
                    queue.add(node);
                }
            }
            n = queue.poll();
        }
        return (int) ceil((double) size / (n.capacity - 1));
    }

    static class Node implements Comparable<Node> {
        int id, capacity, prev;
        public Node(int id, int capacity, int prev) { this.id = id; this.capacity = capacity; this.prev = prev; }
        @Override
        public int compareTo(Node o) { return Integer.compare(o.capacity, capacity); }
        @Override
        public boolean equals(Object o) { return id == ((Node) o).capacity; }
    }
}
