// Problem: Ones
// Status: AC

import java.util.Scanner;

public class Main_5_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            System.out.println(getCount(in.nextInt()));
        }
    }

    static int getCount(int n) {
        int curr = 1, count = 1;
        while ((curr % n) != 0) {
            curr = (curr * 10 + 1) % n;
            count++;
        }
        return count;
    }
}
