// Problem: Light, more light
// Status: AC

import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Main_7_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n;
        while ((n = sqrt(in.nextLong())) != 0) {
            System.out.println(n == (int) n ? "yes" : "no");
        }
    }
}
