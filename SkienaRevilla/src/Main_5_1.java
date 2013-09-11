// Problem: Primary Arithmetic
// Status: AC

import java.util.Scanner;

public class Main_5_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x, y;
        while ((x = in.nextLong()) + (y = in.nextLong()) > 0) {
            int count = getCount(x, y);
            System.out.println(count == 0
                    ? "No carry operation."
                    : count == 1
                        ? "1 carry operation."
                        : count + " carry operations.");
        }
    }

    static int getCount(long x, long y) {
        int count = 0;
        boolean isCarry = false;
        while (x > 0 || y > 0) {
            long n = (x % 10) + (y % 10) + (isCarry ? 1 : 0);
            isCarry = n > 9;
            count += isCarry ? 1 : 0;
            x /= 10;
            y /= 10;
        }
        return count;
    }

}
