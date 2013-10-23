import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import static java.lang.Math.sqrt;

public class Main_7_5 {

    static Set<Integer> primes = new HashSet<Integer>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        calcPrimes(10000000);
        while (in.hasNext()) {
            solve(in.nextInt());
        }
    }

    static void solve(int n) {
        int sum = n % 2 == 0 ? 4 : 5;
        for (int i : primes) {
            if (primes.contains(n - (sum + i))) {
                System.out.print((n - (sum + i)) + " " + i + " ");
                System.out.println(2 + " " + (n % 2 == 0 ? 2 : 3));
                return;
            }
        }
        System.out.println("Impossible.");
    }

    static void calcPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        double sq = sqrt(isPrime.length);
        for (int i = 2; i <= sq; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        primes.add(2);
        for (int i = 3; i < isPrime.length; i += 2) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }

}
