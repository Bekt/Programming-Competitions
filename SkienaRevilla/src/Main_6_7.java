// Problem: Self-describing Sequence
// Status: AC

import java.util.*;

public class Main_6_7 {

    static int[] range = new int[673400];

    public static void main(String[] args) {
        init();
        Scanner in = new Scanner(System.in);
        int n;
        while ((n = in.nextInt()) != 0) {
            System.out.println(getN(n));
        }
    }

    static void init() {
        range[1] = 0;
        range[2] = 2;
        range[3] = 4;
        range[4] = 6;
        range[5] = 9;
        int key = 5, index = 9;
        while (index < 2000000001) {
            index += getN(key);
            range[++key] = index;
        }
    }

    static int getN(int fn) {
        int index = -1, size = range.length;
        for (int i = 0; i < size; i++) {
            if (range[i] > fn) {
                return i - 1;
            }
        }
        return index;
    }
}
