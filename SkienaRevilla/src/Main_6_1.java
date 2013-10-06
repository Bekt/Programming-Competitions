// Problem: How Many Fibs?
// Status: AC

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_6_1 {
    static Scanner in = new Scanner(System.in);
    static List<BigInteger> data = new ArrayList<BigInteger>();

    public static void main(String[] args) {
        init();

        while (true) {
            String a = in.next(), b = in.next().trim();
            if(a.equals("0") && b.equals("0")) {
                break;
            }
            System.out.println(solve(a, b));
        }
    }

    static void init() {
        int index = 0;

        data.add(BigInteger.valueOf(index++));
        data.add(BigInteger.valueOf(index++));
        data.add(BigInteger.valueOf(index++));

        while(true) {
            BigInteger prev1 = data.get(index-2);
            BigInteger prev2 = data.get(index-1);
            BigInteger curr = prev1.add(prev2);

            if(curr.toString().length() > 101) {
                break;
            }

            data.add(curr);
            index++;
        }
    }

    static int solve(String a, String b) {
        BigInteger n = new BigInteger(a);
        BigInteger m = new BigInteger(b);
        int count = 0;

        for (int i = 1; i < data.size(); i++) {
            BigInteger curr = data.get(i);

            if(curr.compareTo(m) > 0) {
                break;
            }
            if(curr.compareTo(n) >= 0) {
                count++;
            }
        }
        return count;
    }
}