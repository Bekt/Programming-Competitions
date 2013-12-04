// Problem: War
// Status: AC

import java.util.Scanner;

public class Main_10_5 {

    static int[] roots;
    static int[] orig;
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        orig = new int[2 * n];
        roots = new int[2 * n];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
            orig[i] = 1;
        }
        int c, x, y;
        while (((c = in.nextInt()) + (x = in.nextInt()) + (y = in.nextInt())) > 0) {
            if (c == 1 && !setFriends(x, y)) {
                System.out.println(-1);
            } else if (c == 2 && !setEnemies(x, y)) {
                System.out.println(-1);
            } else if (c == 3) {
                System.out.println(areFriends(x, y) ? 1 : 0);
            } else if (c == 4) {
                System.out.println(areEnemies(x, y) ? 1 : 0);
            }
        }
    }

    static int find(int x) {
        return x == roots[x] ? x : find(roots[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            if (orig[rootX] < orig[rootY]) {
                roots[rootX] = rootY;
                orig[rootY] += orig[rootX];
            } else {
                roots[rootY] = rootX;
                orig[rootX] += orig[rootY];
            }
        }
    }

    static boolean setFriends(int x, int y) {
        if (areEnemies(x, y)) {
            return false;
        }
        union(x, y);
        union(x + n, y + n);
        return true;
    }

    static boolean setEnemies(int x, int y) {
        if (areFriends(x, y)) {
            return false;
        }
        union(x, y + n);
        union(y, x + n);
        return true;
    }

    static boolean areFriends(int x, int y) {
        return find(x) == find(y) || find(x + n) == find(y + n);
    }

    static boolean areEnemies(int x, int y) {
        return find(x) == find(y + n) || find(y) == find(x + n);
    }

}
