// Problem: Reverse and Add
// Status: AC

import java.util.Scanner;

public class Main_5_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            solve(in.nextLong());
        }
    }

    static void solve(long n) {
        int iterations = 0;
        while (iterations++ <= 1000 && (n += reverse(n)) != reverse(n));
        System.out.println(iterations + " " + n);
    }

    static long reverse(long n) {
        long sum = 0;
        while (n > 0) {
            sum = sum * 10 + n % 10;
            n /= 10;
        }
        return sum;
    }
}
