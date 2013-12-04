// Status: WA

import java.util.*;

public class Main_10_5 {

    static int[] roots;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        roots = new int[2 * in.nextInt() + 1];
        for (int i = 0; i < roots.length; roots[i] = i++);
        int c, x, y;
        while ((c = in.nextInt()) > 0 && ((x = 2 * in.nextInt() + 1) + (y = 2 * in.nextInt() + 1)) > 0) {
            if (c == 1 && !setFriends(x, y)) {
                System.out.println(-1);
            } else if (c == 2 && !setEnemies(x, y)) {
                System.out.println(-1);
            } else if (c == 3) {
                System.out.println(areFriends(x, y) ? 1 : 0);
            } else {
                System.out.println(areEnemies(x, y) ? 1 : 0);
            }
        }
    }

    static int find(int x) {
        if (roots[x] == x) {
            return x;
        }
        roots[x] = find(roots[x]);
        return roots[x];
    }

    static void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        roots[rootX] = rootY;
    }

    static int half(int x) {
        return (x % 2) == 0 ? x + 1 : x - 1;
    }

    static boolean setFriends(int x, int y) {
        if (areEnemies(x, y)) {
            return false;
        }
        union(x, y);
        union(half(x), half(y));
        return true;
    }

    static boolean setEnemies(int x, int y) {
        if (areFriends(x, y)) {
            return false;
        }
        union(x, half(y));
        union(y, half(x));
        return true;
    }

    static boolean areFriends(int x, int y) {
        return find(x) == find(y) || find(half(x)) == find(half(y));
    }

    static boolean areEnemies(int x, int y) {
        return find(x) == find(half(y)) || find(y) == find(half(x));
    }

}
