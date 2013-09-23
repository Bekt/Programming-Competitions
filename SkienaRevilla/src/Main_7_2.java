// Problem: Carmichael Numbers
// Status: AC

import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Main_7_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while ((n = in.nextInt()) != 0) {
            System.out.println(isCarmichael(n)
                    ? ("The number " + n + " is a Carmichael number.")
                    : (n + " is normal."));
        }
    }

    static boolean isCarmichael(int n) {
        if (isPrime(n)) {
            return false;
        }
        for (int a = 2; a < n; a++) {
            if (a != powMod(a, n, n)) {
                return false;
            }
        }
        return true;
    }

    static long powMod(int base, int exp, int mod) {
        if (exp == 1) {
            return base;
        }
        long half = powMod(base, exp / 2, mod);
        return (exp % 2) == 0 ? (half * half) % mod : (half * half * base) % mod;
    }

    static boolean isPrime(int n) {
        double sq = sqrt(n);
        for (int i = 2; i <= sq; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }
}