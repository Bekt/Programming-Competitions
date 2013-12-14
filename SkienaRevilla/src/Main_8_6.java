// Problem: Garden of Eden
// Status: AC
// Note: System.out.println() on every case is too slow

import java.util.Scanner;

public class Main_8_6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            int id = in.nextInt(), n = in.nextInt();
            String str = in.nextLine();
            boolean[] c = new boolean[str.length()-1];
            for (int i = 1; i < str.length(); c[i-1] = str.charAt(i++) == '1');
            int[] p = new int[n + 1];
            sb.append(solve(0, n, id, c, p) ? "REACHABLE\n" : "GARDEN OF EDEN\n");
        }
        System.out.print(sb);
    }

    static boolean solve(int i, int n, int id, boolean[] c, int[] p) {
        if (i == n) {
            if ((cell(id, p[i - 2], p[i - 1], p[0]) != c[i - 1])
                    || (cell(id, p[i - 1], p[0], p[1]) != c[0])) {
                return false;
            }
            return true;
        }
        boolean flag = false;
        for (int j = 0; j < 2; j++) {
            p[i] = j;
            if (i > 1 && cell(id, p[i - 2], p[i - 1], p[i]) != c[i - 1]) {
                continue;
            }
            if(solve(i + 1, n, id, c, p)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    static boolean cell(int id, int lo, int mi, int hi) {
        return (id & (1 << ((lo << 2) | (mi << 1) | hi))) != 0;
    }

}
