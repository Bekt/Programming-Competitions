// Problem: Weights and Measures
// Status: AC

import java.awt.Point;
import java.util.*;
import static java.lang.Math.*;

public class Main_11_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Point> turtles = new ArrayList<Point>();
        while (in.hasNext()) {
            turtles.add(new Point(in.nextInt(), in.nextInt()));
        }
        System.out.println(solve(turtles));
    }

    static int solve(List<Point> turtles) {
        int ans = 0;
        int n = turtles.size();
        int[][] memo = new int[n + 1][n + 1];
        sort(turtles);
        int limit = Integer.MAX_VALUE / 2;
        for (int i = 0; i <= n; Arrays.fill(memo[i++], limit));
        for (int i = 0; i < n; memo[i][1] = turtles.get(i++).x);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                memo[i][j] = memo[i - 1][j];
                Point turtle = turtles.get(i - 1);
                if (memo[i - 1][j - 1] + turtle.x <= turtle.y) {
                    memo[i][j] = min(memo[i][j], memo[i - 1][j - 1] + turtle.x);
                }
                ans = memo[i][j] == limit ? ans : max(ans, j);
            }
        }
        return ans;
    }

    static void sort(List<Point> stuff) {
        Collections.sort(stuff, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.y, o2.y);
            }
        });
    }
}
