// Problem: Hartals
// Status: AC

import java.util.Scanner;

public class Main_2_3 {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(solve(in.nextInt(), in.nextInt()));
        }
    }
	
	static int solve(int n, int p) {
        int[] h = new int[p];
        int hartals = 0;

        for (int i = 0; i < p; h[i++] = in.nextInt());

        for (int i = 1; i <= n; i++) {
            if ((i + 1) % 7 == 0) {
                i++;
                continue;
            }
            for (int j = 0; j < p; j++) {
                if (i % h[j] == 0) {
                    hartals++;
                    break;
                }
            }
        }
        return hartals;
    }
}
