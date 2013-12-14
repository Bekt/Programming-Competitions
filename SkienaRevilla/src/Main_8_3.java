// Problem: Queue
// Status: AC

import java.util.*;

public class Main_8_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long[][][] memo = new long[15][15][15];
            for (int j = 0; j < 15; j++) {
                for (int k = 0; k < 15; k++) {
                    Arrays.fill(memo[j][k], -1);
                }
            }
            long ans = solve(in.nextInt(), in.nextInt(), in.nextInt(), memo);
            System.out.println(ans);
        }
    }

    static long solve(int n, int left, int right, long[][][] memo) {
        if (memo[n][left][right] != -1) {
            return memo[n][left][right];
        }
        long val = 0;
        if (n * left * right == 1) {
            val = 1;
        } else if (n * left * right > 1) {
            val = solve(n - 1, left, right, memo) * (n - 2);
            val += solve(n - 1, left - 1, right, memo);
            val += solve(n - 1, left, right - 1, memo);
        }
        memo[n][left][right] = val;
        return val;
    }

}
