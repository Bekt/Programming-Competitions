// Problem: Unidirectional TSP
// Status: AC

import java.util.Scanner;

public class Main_11_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt(), m = in.nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            solve(matrix, n, m);
        }
    }

    static void solve(int[][] matrix, int n, int m) {
        int[][] memo = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];
        int minVal = Integer.MAX_VALUE, minInd = Integer.MAX_VALUE;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j <= n; j++) {
                int val = matrix[j - 1][i];
                memo[j][i] = val + memo[j][i + 1];
                path[j][i] = j - 1;
                if (j == 1 && val + memo[n][i + 1] < memo[j][i]) {
                    memo[j][i] = val + memo[n][i + 1];
                    path[j][i] = n - 1;
                }
                if (j != 1 && val + memo[j - 1][i + 1] <= memo[j][i]) {
                    memo[j][i] = val + memo[j - 1][i + 1];
                    path[j][i] = j - 1 - 1;
                }
                if (j == n && val + memo[1][i + 1] <= memo[j][i]) {
                    memo[j][i] = val + memo[1][i + 1];
                    path[j][i] = 1 - 1;
                }
                if (j != n && val + memo[j + 1][i + 1] <= memo[j][i]) {
                    if (val + memo[j + 1][i + 1] < memo[j][i]) {
                        path[j][i] = j + 1 - 1;
                    }
                    memo[j][i] = val + memo[j + 1][i + 1];
                }
                if (i == 0 && memo[j][i] < minVal) {
                    minVal = memo[j][i];
                    minInd = j;
                }
            }
        }
        int prev = minInd;
        System.out.print(minInd);
        for (int i = 0; i < m - 1; i++) {
            int p = path[prev][i] + 1;
            System.out.print(" " + p);
            prev = p;
        }
        System.out.println();
        System.out.println(minVal);
    }

}
