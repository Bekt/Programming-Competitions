import java.util.Scanner;

public class Main_11_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            char[] x = in.nextLine().toCharArray();
            char[] z = in.nextLine().toCharArray();
            System.out.println(solve(x, z));
        }
    }

    static int solve(char[] x, char[] z) {
        int[][] memo = new int[z.length + 1][x.length + 1];
        for (int i = z.length - 1; i >= 0; i--) {
            for (int j = x.length - 1; j >= 0; j--) {
                int r = z.length - i, c = x.length - j;
                memo[r][c] = memo[r][c - 1];
                if (z[i] == x[j]) {
                    memo[r][c] = r == 1 ? memo[r][c - 1] + 1 : memo[r][c] + memo[r - 1][c];
                }
                System.out.print(memo[r][c] + " ");
            }
            System.out.println();
        }
        return memo[z.length][x.length];
    }

}
