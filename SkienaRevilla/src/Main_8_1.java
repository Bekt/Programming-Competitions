// Problem: Little Bishops
// Status: AC

import java.util.Scanner;

public class Main_8_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, k;
        while ((n = in.nextInt()) + (k = in.nextInt()) > 0) {
            int[] r1 = new int[n + 1];
            int[] r2 = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                r1[i] = i % 2 == 1 ? r2[i - 1] + 1 : r1[i - 1];
                r2[i] = i % 2 == 1 ? r1[i] + 1 : r2[i - 1];
            }
            long count = 0;
            for (int i = 0; i <= k; i++) {
                count += (solve(n, i, r1) * solve(n - 1, k - i, r2));
            }
            System.out.println(count);
        }
    }

    static long solve(int row, int col, int[] r) {
        if (row >= 0 && col == 0) {
            return 1;
        }
        if (row == 0 && col > 0) {
            return 0;
        }
        long down = solve(row - 1, col, r);
        long diag = solve(row - 1, col - 1, r);
        return down + diag * (r[row] - col + 1);
    }

}
