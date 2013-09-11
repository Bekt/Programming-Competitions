// Problem: Shoemaker's problem
// Status: AC

import java.util.*;

public class Main_4_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            List<Num> nums = new ArrayList<Num>();
            for (int j = 1; j <= n; j++) {
                nums.add(new Num(in.nextInt(), in.nextInt(), j));
            }
            Collections.sort(nums);
            System.out.println(nums.toString().replaceAll("[\\[\\],]", ""));

            if (i < t - 1) {
                System.out.println();
            }
        }
    }

    static class Num implements Comparable<Num> {
        int index;
        double r;

        public Num(int t, int s, int index) {
            this.index = index;
            this.r = (double) s / t;
        }

        @Override
        public int compareTo(Num obj) {
            if (r > obj.r) return -1;
            if (r < obj.r) return 1;
            if (index < obj.index) return -1;
            return 1;
        }

        public String toString() {
            return String.valueOf(index);
        }
    }
}
