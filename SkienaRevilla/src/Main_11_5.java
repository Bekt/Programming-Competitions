// Problem: Cutting Sticks
// Status: AC

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.min;

public class Main_11_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s;
        while ((s = in.nextInt()) != 0) {
            int n = in.nextInt();
            int[] cuts = new int[n + 2];
            int[][] memo = new int[n + 2][n + 2];
            for (int i = 1; i <= n; cuts[i++] = in.nextInt());
            for (int i = 0; i < memo.length; Arrays.fill(memo[i++], Integer.MAX_VALUE));
            cuts[n + 1] = s;
            System.out.println("The minimum cutting is " + solve(cuts, memo, 0, n + 1) + ".");
        }
    }

    static int solve(int[] cuts, int[][] memo, int left, int right) {
        if (right - left < 2) {
            return memo[left][right] = 0;
        }
        if (memo[left][right] == Integer.MAX_VALUE) {
            for (int i = left + 1; i < right; i++) {
                int cost = cuts[right] - cuts[left]
                        + solve(cuts, memo, left, i) + solve(cuts, memo, i, right);
                memo[left][right] = min(memo[left][right], cost);
            }
        }
        return memo[left][right];
    }

}
