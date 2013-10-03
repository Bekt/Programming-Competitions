// Problem: How Many Pieces of Land?
// Status: AC

import java.math.BigInteger;
import java.util.Scanner;

public class Main_6_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(solve(in.nextInt()));
        }
    }

    static String solve(int n) {
        return BigInteger.ONE.add(nChooseK(n, 2)).add(nChooseK(n, 4)).toString();
    }

    static BigInteger nChooseK(int n, int k) {
        return k == 0 ? BigInteger.ONE : (BigInteger.valueOf(n).multiply(nChooseK(n - 1, k - 1)).divide(BigInteger.valueOf(k)));
    }

}
