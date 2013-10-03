// Problem: Steps
// Status: AC

import java.util.Scanner;

public class Main_6_8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            System.out.println(solve(in.nextInt(), in.nextInt()));
        }
    }

    static long solve(int x, int y) {
        int n = y - x;
        if (n <= 2) {
            return n;
        }
        long sum = 2, step = 2, count = 2;
        while ((n - sum) > step * 2) {
            sum += 2 * step;
            step++;
            count += 2;
        }
        if ((n - sum) >= step + 1) {
            return count + 2;
        }
        return count + 1;
    }

}
