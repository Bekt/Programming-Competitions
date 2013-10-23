import java.util.Scanner;

public class Main_7_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt(), m = in.nextInt();
            System.out.println(
                    m +
                    (solve(n, m) ? " divides " : " does not divide ")
                    + n + "!");
        }
    }

    static boolean solve(int n, int m) {
        return factorialMod(n, m) == 0;
    }

    static long factorialMod(long n, long mod) {
        long fact = 1, i = 2;
        while (i <= n) {
            fact = (fact % mod) * (i++ % mod) % mod;
        }
        return fact;
    }
}
