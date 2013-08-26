// Problem: The 3n+1 Problem
// Status: AC

import java.util.Scanner;
import static java.lang.Math.max;

public class Main_1_1_100 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int i = in.nextInt(), j = in.nextInt();
            int ans = i < j ? solve(i, j) : solve(j, i);
            System.out.printf("%d %d %d%n", i, j, ans);
        }
    }

    static int solve(int a, int b) {
        int max = 0;
        for (; a <= b; a++) {
            max = max(max, getCount(a));
        }
        return max;
    }

    static int getCount(int n) {
        int count = 1;
        while (n != 1) {
            n = n % 2 == 0 ? n / 2 : n * 3 + 1;
            count++;
        }
        return count;
    }
}
