//Chapter 4: 4.6.1 Vito’s Family
//Status: WA

import java.util.*;
import static java.lang.Math.*;

public class Main_4_1 {
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			solve();
		}
	}
	
	static void solve() {
		int r = in.nextInt();
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0, counter = 0, diff = 0;
		for (int i = 0; i < r; i++) {
			int s = in.nextInt();
			if(!set.contains(s)) {
				set.add(s);
				sum += s;
				counter++;
			}
		}
		int median = (int) ((double)sum / counter + 0.5);
		
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			diff += abs(median - iter.next());
		}
		System.out.println(diff);
	}
}
