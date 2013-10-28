// Problem: Edit Step Ladders
// Status: TLE

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Main_9_5 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<char[]> dictionary = new ArrayList<char[]>();
        String line;
        while ((line = in.readLine()) != null) {
            dictionary.add(line.toCharArray());
        }
        System.out.println(solve(dictionary));
    }

    static int solve(List<char[]> dictionary) {
        int n = dictionary.size();
        int[] counts = new int[n];
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            char[] curr = dictionary.get(i);
            for (int j = i + 1; j < n; j++) {
                if (isEditable(curr, dictionary.get(j))) {
                    counts[j] = max(counts[j], counts[i] + 1);
                    max = max(max, counts[j]);
                }
            }
        }
        return max == 0 ? 0 : max + 1;
    }

    static boolean isEditable(char[] ca, char[] cb) {
        if (abs(ca.length - cb.length) > 1) {
            return false;
        }
        if (ca.length == cb.length) {
            boolean flag = false;
            for (int i = 0; i < ca.length; i++) {
                if (ca[i] != cb[i] && flag) {
                    return false;
                }
                if (ca[i] != cb[i]) {
                    flag = true;
                }
            }
            return true;
        }

        if (cb.length < ca.length) {
            char[] temp = cb;
            cb = ca;
            ca = temp;
        }
        int i = 0, j = 0;
        boolean flag = false;
        while (i < ca.length && j < ca.length) {
            if (ca[i] != cb[i] && flag) {
                return false;
            }
            if (ca[i] != cb[i]) {
                flag = true;
                j++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}
