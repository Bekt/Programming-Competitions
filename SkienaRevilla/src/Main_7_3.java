// Problem: Euclid Problem
// Status: Incomplete

import java.util.Scanner;
import java.awt.Point;
import static java.lang.Math.*;

public class Main_7_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            solve(in.nextInt(), in.nextInt());
        }
    }

    static void solve(int a, int b) {
        Point g = new Point();
        long d = gcd(a, b, g);
        System.out.println(min(g.x, g.y) + " " + max(g.x, g.y) + " " + d);
    }

    static long gcd(int a, int b, Point xy) {
        if (b > a) {
            return gcd(b, a, xy);
        }
        if (b == 0) {
            xy.x = 1;
            xy.y = 0;
            return a;
        }
        Point temp = new Point();
        long g = gcd(b, a % b, temp);
        xy.x = temp.y;
        xy.y = temp.x - (int) (floor(a / (double) b) * temp.y);

        return g;
    }

}
