// Problem: Bicoloring
// Status: AC

import java.util.*;

public class Main_9_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while ((n = in.nextInt()) != 0) {
            List<List<Integer>> graph = new ArrayList<List<Integer>>();
            int edges = in.nextInt();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < edges; i++) {
                int n1 = in.nextInt(), n2 = in.nextInt();
                List<Integer> node = graph.get(n1);
                node.add(n2);
                node = graph.get(n2);
                node.add(n1);
            }
            System.out.println(solve(graph) ? "BICOLORABLE." : "NOT BICOLORABLE.");
        }
    }

    static boolean solve(List<List<Integer>> graph) {
        Map<Integer, Boolean> colored = new HashMap<Integer, Boolean>();
        colored.put(0, true);
        for (int i = 0; i < graph.size(); i++) {
            Boolean color = colored.get(i);
            if (color == null) {
                continue;
            }
            List<Integer> node = graph.get(i);
            for (Integer neighbor : node) {
                Boolean neighborColor = colored.get(neighbor);
                if (neighborColor != null && neighborColor == color) {
                    return false;
                }
                colored.put(neighbor, !color);
            }
        }
        return true;
    }
}
