// Problem: Counting
// Statis:

import java.math.BigInteger;
import java.util.*;

public class Main_6_3 {

    static List<BigInteger> cache = new ArrayList<BigInteger>() {{
        add(BigInteger.valueOf(0));
        add(BigInteger.valueOf(2));
        add(BigInteger.valueOf(5));
        add(BigInteger.valueOf(13));
    }};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(solve(in.nextInt()).toString());
        }
    }

    static BigInteger solve(int n) {
        if (n < cache.size()) {
            return cache.get(n);
        }
        // result = 2 * solve(n - 1) + solve(n - 2) + solve(n - 3)
        BigInteger res = BigInteger.valueOf(2).multiply(solve(n - 1)).add(solve(n - 2)).add(solve(n - 3));
        cache.add(res);
        return res;
    }
}
