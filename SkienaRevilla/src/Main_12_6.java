// Problem: (2/3/4)-D Sqr/Rects/Cubes/Boxes?
// Status:

import java.util.Scanner;
import static java.lang.Math.pow;

public class Main_12_6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = 101;
        long[] s2 = new long[H], s3 = new long[H], s4 = new long[H];
        long[] r2 = new long[H], r3 = new long[H], r4 = new long[H];
        for (int i = 1; i < H; ++i) {
            s2[i] = s2[i - 1] + (i * i);
            s3[i] = s3[i - 1] + (i * i * i);
            s4[i] = s4[i - 1] + (i * i * i * i);
            r2[i] = r2[i - 1] + (i * i * (i - 1));
            r3[i] = (long) (pow((i * (i + 1)) / 2, 3)) - s3[i];
            r4[i] = (long) (pow((i * (i + 1)) / 2, 4)) - s4[i];
        }
        while (in.hasNext()) {
            int n = in.nextInt();
            System.out.printf("%d %d %d %d %d %d%n", s2[n], r2[n], s3[n], r3[n], s4[n], r4[n]);
        }
    }

}
