// Problem: Stacks of Flapjacks
// Status: AC

import java.util.*;

public class Main_4_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int[] pancakes = getInput(in.nextLine());
            System.out.println(Arrays.toString(pancakes).replaceAll("[\\[\\],]", ""));
            solve(pancakes);
        }
    }

    static void solve(int[] pancakes) {
        int n = pancakes.length;
        int[] copy = Arrays.copyOf(pancakes, n);
        Arrays.sort(copy);
        int ind = n - 1;
        while (ind > 0) {
            if (pancakes[ind] == copy[ind]) {
                ind--;
                continue;
            }
            int pos = getIndex(pancakes, copy[ind]);
            flip(pancakes, pos);
            flip(pancakes, ind);

            if (pos != 0) {
                System.out.print((n - pos) + " ");
            }
            System.out.print((n - ind--) + " ");
        }
        System.out.println("0");
    }

    static int[] getInput(String line) {
        String[] sp = line.split(" ");
        int[] arr = new int[sp.length];
        for (int i = 0; i < sp.length; i++) {
            arr[i] = Integer.valueOf(sp[i]);
        }
        return arr;
    }

    static int getIndex(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    static void flip(int[] arr, int pos) {
        for (int i = 0; i < pos; i++) {
            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos--] = temp;
        }
    }
}
