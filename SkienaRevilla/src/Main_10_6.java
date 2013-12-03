// Problem: Tourist Guide (10199)
// Status: AC

import java.util.*;
import static java.lang.Math.min;

public class Main_10_6 {

    static int DISTANCE;

    static class Node implements Comparable<Node> {
        int distance, low;
        boolean visited;
        String name;
        Node prev;
        List<Node> adj = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return name.compareTo(o.name);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 1, n = in.nextInt();
        in.nextLine();
        while (true) {
            DISTANCE = 0;
            Map<String, Node> vertices = new HashMap<String, Node>();
            for (int i = 0; i < n; i++) {
                String name = in.nextLine();
                vertices.put(name, new Node(name));
            }
            int r = in.nextInt();
            in.nextLine();
            for (int i = 0; i < r; i++) {
                String[] sp = in.nextLine().split(" ");
                Node v1 = vertices.get(sp[0]);
                Node v2 = vertices.get(sp[1]);
                v1.adj.add(v2);
                v2.adj.add(v1);
            }
            Set<Node> ap = new TreeSet<Node>();
            for (Node vertex : vertices.values()) {
                if (!vertex.visited) {
                    dfs(vertex, ap);
                }
            }
            System.out.printf("City map #%d: %d camera(s) found%n", count++, ap.size());
            for (Node point : ap) {
                System.out.println(point.name);
            }

            n = in.nextInt();
            in.nextLine();
            if (n == 0) {
                break;
            } else {
                System.out.println();
            }
        }
    }

    static void dfs(Node u, Set<Node> ap) {
        DISTANCE++;
        u.visited = true;
        u.distance = DISTANCE;
        u.low = DISTANCE;

        int neighbors = 0;
        for (Node v : u.adj) {
            if (!v.visited) {
                neighbors++;
                v.prev = u;

                dfs(v, ap);
                u.low = min(u.low, v.low);

                if ((u.prev == null && neighbors >= 2) || (u.prev != null && u.distance <= v.low)) {
                    ap.add(u);
                }
            } else if (v != u.prev) {
                u.low = min(u.low, v.distance);
            }
        }
    }
}
