// Problem: The Knights Of The Round Table
// Status: AC

import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Main_13_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double a = in.nextDouble(), b = in.nextDouble(), c = in.nextDouble();
            double p = (a + b + c) / 2;
            double r = (a == 0 || b == 0 || c == 0) ? 0 : sqrt((p - a) * (p - b) * (p - c) / p);
            System.out.printf("The radius of the round table is: %.3f\n", r);
        }
    }

}
