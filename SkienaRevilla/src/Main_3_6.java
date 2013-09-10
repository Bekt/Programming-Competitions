// Problem: File Fragmentation
// Status: AC

import java.util.*;
import static java.lang.Math.*;

public class Main_3_6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String line = in.nextLine();
        in.nextLine();

        for (int i = 0; i < t; i++) {
            Main_3_6 main = new Main_3_6();
            while (in.hasNext() && !(line = in.nextLine()).isEmpty()) {
                main.fragments.add(line);
            }
            System.out.println(main.solve());
            if (i < t - 1) {
                System.out.println();
            }
        }
    }

    List<String> fragments = new ArrayList<String>();
    Map<Integer, List<String>> sizeToFragment = new HashMap<Integer, List<String>>();
    Map<String, Integer> candidates = new HashMap<String, Integer>();
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    String solve() {
        setup();

        for (String frag : fragments) {
            List<String> parts = sizeToFragment.get(max + min - frag.length());
            for (String part : parts) {
                if (part != frag) { // By reference, not value
                    String full = frag + part;
                    Integer value = candidates.get(full);
                    value = value == null ? 1 : value + 1;
                    candidates.put(full, value);
                }
            }
        }

        int maxValue = 0;
        String ans = null;
        Set<String> keySet = candidates.keySet();
        for (String key : keySet) {
            int value = candidates.get(key);
            if (value > maxValue) {
                maxValue = value;
                ans = key;
            }
        }
        return ans;
    }

    void setup() {
        for (String f : fragments) {
            int size = f.length();
            min = min(min, size);
            max = max(max, size);
            List<String> list = sizeToFragment.get(size);
            if (list == null) {
                list = new ArrayList<String>();
                sizeToFragment.put(size, list);
            }
            list.add(f);
        }
    }
}