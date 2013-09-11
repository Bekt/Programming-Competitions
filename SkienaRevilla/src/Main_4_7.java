// Problem: Shell Sort
// Status: TLE
// Note: Scanner is too slow for this problem (like 7x times)

import java.io.*;
import java.util.*;

public class Main_4_7 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(in.readLine());
        for (int i = 0; i < t; i++) {
            List<String> original = new ArrayList<String>();
            List<String> desired = new ArrayList<String>();
            Map<String, Integer> desiredMap = new HashMap<String, Integer>();
            List<Integer> unsorted = new ArrayList<Integer>();
            int n = Integer.valueOf(in.readLine());
            for (int j = 0; j < n; j++) {
                original.add(in.readLine());
            }
            for (int j = 0; j < n; j++) {
                String name = in.readLine();
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
        int inPlace = -1, notInPlace = -1;
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            if (val > inPlace) {
                inPlace = val;
            } else if (val > notInPlace) {
                notInPlace = val;
            }
        }

        while (notInPlace >= 0) {
            System.out.println(names.get(notInPlace--));
        }
    }
}