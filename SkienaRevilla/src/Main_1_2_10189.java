// Problem: Minesweeper
// Status: AC

import java.util.Scanner;

public class Main_1_2_10189 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), counter = 1;
        while (n != 0 && m != 0) {
            in.nextLine();
            System.out.printf("Field #%d:%n", counter++);
            StringBuilder flatBoard = new StringBuilder();
            for (int i = 0; i++ < n; flatBoard.append(in.nextLine()));
            solve(flatBoard.toString().toCharArray(), n, m);
            if ((n = in.nextInt()) != 0 && (m = in.nextInt()) != 0) {
                System.out.println();
            }
        }
    }

    static void solve(char[] board, int n, int m) {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '*') {
                System.out.print(board[i]);
            } else if (board[i] == '.') {
                int count = 0;
                count += check(board, i + m) ? 1 : 0;
                count += check(board, i - m) ? 1 : 0;
                if (m > 1 && ((i + 1) % m == 0 || i % m != 0)) {
                    count += check(board, i - 1) ? 1 : 0;
                    count += check(board, i - m - 1) ? 1 : 0;
                    count += check(board, i + m - 1) ? 1 : 0;
                }
                if (m > 1 && (i % m == 0 || (i + 1) % m != 0)) {
                    count += check(board, i + 1) ? 1 : 0;
                    count += check(board, i - m + 1) ? 1 : 0;
                    count += check(board, i + m + 1) ? 1 : 0;
                }
                System.out.print(count);
            }
            if ((i + 1) % m == 0) {
                System.out.println();
            }
        }
    }

    static boolean check(char[] c, int ind) {
        return ind < 0 || ind >= c.length ? false : c[ind] == '*';
    }
}
