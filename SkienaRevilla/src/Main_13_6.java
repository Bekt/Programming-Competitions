// Problem: The Largest/Smallest Box...
// Status: AC

import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Main_13_6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double l = in.nextDouble(), w = in.nextDouble();
            double a = (l + w - sqrt((w * w) + (l * l) - (w * l))) / 6.0;
            double b = w < l ? w / 2.0 : l / 2.0;
            System.out.printf("%.3f 0.000 %.3f%n", a, b);
        }
    }

}