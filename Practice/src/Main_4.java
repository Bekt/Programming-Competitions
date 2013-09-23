import java.math.BigInteger;
import java.util.Scanner;

public class Main_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while ((n = in.nextInt()) != 0) {
            System.out.println(isCarmichael(n)
                    ? (n + " is normal.")
                    : ("The number " + n + " is a Carmichael number."));
        }
    }

    static boolean isCarmichael(int n) {
        for (int a = 2; a < n; a++) {
            long sum = 1;
            for (int i = 0; i < n; i++) {
                sum *= ((a % n) * (a % n));
                sum %= n;
            }
            if (sum != a) {
                return false;
            }
        }
        return true;
    }

}
