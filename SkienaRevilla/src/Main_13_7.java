// Problem: Is This Integration?
// Status: AC
// Note: System.out.printf() on each case is too expensive

import java.util.Scanner;
import static java.lang.Math.*;

public class Main_13_7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        double sqrtTh = sqrt(3), piByTh = PI / 3;
        while (in.hasNext()) {
            double r = in.nextDouble();
            r *= r;
            double a = r * (1 - sqrtTh + piByTh);
            double b = r * (2 * sqrtTh + piByTh - 4);
            double c = r * (4 - sqrtTh + piByTh * -2);
            out.append(String.format("%.3f %.3f %.3f\n", a, b, c));
        }
        System.out.println(out);
    }

}
