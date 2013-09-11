// Problem: Vito's Family
// Status: AC

import java.util.*;
import static java.lang.Math.abs;

public class Main_4_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int r = in.nextInt();
            List<Integer> relatives = new ArrayList<Integer>();
            for (int j = 0; j < r; j++) {
                relatives.add(in.nextInt());
            }
            System.out.println(solve(relatives));
        }
    }

    static int solve(List<Integer> relatives) {
        int median = getMedian(relatives), diff = 0;
        for (int i : relatives) {
            diff += abs(median - i);
        }
        return diff;
    }

    static int getMedian(List<Integer> numbers) {
        Collections.sort(numbers);
        int size = numbers.size();
        return size % 2 == 0 ? numbers.get(size / 2 - 1) : numbers.get(size / 2);
    }
}
