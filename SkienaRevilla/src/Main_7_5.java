// Problem: Summation of Four Primes
// Status: AC

import java.util.Scanner;

public class Main_7_5 {

    static boolean[] notPrime = calcPrimes(10000000);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            solve(in.nextInt());
        }
    }

    static void solve(int n) {
        if (n < 8) {
            System.out.println("Impossible.");
        } else {
            System.out.print("2 " + (n % 2 == 0 ? "2 " : "3 "));
            n -= (4 + (n % 2));
            for (int i = 2; n -i >= 2; i++) {
                if (!notPrime[i] && !notPrime[n - i]) {
                    System.out.println(i + " " + (n - i));
                    return;
                }
            }
        }
    }

    static boolean[] calcPrimes(int n) {
        boolean[] notPrime = new boolean[n + 1];
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 4; i <= n; i += 2) {
            notPrime[i] = true;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (!notPrime[i]) {
                for (int j = i * i; j <=n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        return notPrime;
    }

}
