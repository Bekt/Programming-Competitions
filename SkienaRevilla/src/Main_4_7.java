// Problem: Shell Sort
// Status: TLE

// Solution:
// 1) Treat the original ordering as unsorted list
// 2) Treat the desired ordering as sorted list
// 3) Sort the unsorted list:
//      - start from the beginning
//      - if current number > previous number: move the current number to position 0
// 4) Repeat step 3 until the list is sorted

import java.util.*;

public class Main_4_7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            List<String> original = new ArrayList<String>();
            List<String> desired = new ArrayList<String>();
            Map<String, Integer> desiredMap = new HashMap<String, Integer>();
            List<Integer> unsorted = new LinkedList<Integer>();
            int n = in.nextInt();
            in.nextLine();
            for (int j = 0; j < n; j++) {
                original.add(in.nextLine());
            }
            for (int j = 0; j < n; j++) {
                String name = in.nextLine();
                desiredMap.put(name, j);
                desired.add(name);
            }
            for (int j = 0; j < n; j++) {
                unsorted.add(desiredMap.get(original.get(j)));
            }
            sort(unsorted, desired);
            System.out.println();
        }
    }

    static void sort(List<Integer> list, List<String> names) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(i - 1)) {
                    int temp = list.get(i);
                    list.remove(i);
                    list.add(0, temp);
                    sorted = false;
                    System.out.println(names.get(temp));
                }
            }
        }
    }
}
