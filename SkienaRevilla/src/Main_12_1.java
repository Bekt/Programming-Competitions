// Problem: Ant on a Chessboard
// Status: AC

import java.util.Scanner;
import static java.lang.Math.*;

public class Main_12_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while ((n = in.nextInt()) != 0) {
            int sq = (int) ceil(sqrt(n));
            int coord = sq * sq - sq + 1;
            int y = n > coord ? sq - n + coord : sq;
            int x = n > coord ? sq : sq - coord + n;
            System.out.println(sq % 2 == 0 ? (x + " " + y) : (y + " " + x));
        }
    }

}