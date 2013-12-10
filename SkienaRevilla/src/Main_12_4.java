// Problem: Bee Maja
// Status:

import java.util.Scanner;

public class Main_12_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            solve(in.nextInt() - 1);
        }
    }

    static void solve(int n) {
        int i = 6, k = 1;
        while (n - i > 0) {
            n -= i;
            i += 6;
            k++;
        }
        int pos = 0;
        while (n - k > 0) {
            n -= k;
            pos++;
        }
        int x, y;
        if (pos == 0) {
            x = n == 0 ? n : k - n;
            y = n;
        } else if (pos == 1) {
            x = -n;
            y = k;
        } else if (pos == 2) {
            x = -k;
            y = k - n;
        } else if (pos == 3) {
            x = -k + n;
            y = -n;
        } else if (pos == 4) {
            x = n;
            y = -k;
        } else {
            x = k;
            y = -k + n;
        }
        System.out.println(x + " " + y);
    }

}
