import java.util.*;

import static java.lang.Math.sqrt;

public class Main_2 {

    static Map<Integer, Boolean> cache = new HashMap<Integer, Boolean>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int i = in.nextInt(), j = in.nextInt();
            System.out.println(i < j ? solve(i, j) : solve(j, i));
        }
    }

    static int solve (int i, int j) {
        int count = 0;
        for (; i <= j; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        double sq = sqrt(n);
        for (int i = 2; i <= sq; i++) {
            if ((n % i) == 0) {
                cache.put(n, false);
                return false;
            }
        }
        cache.put(n, true);
        return true;
    }

}
