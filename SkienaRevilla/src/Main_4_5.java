//Status: WA

import java.util.*;

public class Main_4_5 {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			solve();
			System.out.println();
		}
	}
	
	static void solve() {
		int n = in.nextInt();
		List<Num> nums = new ArrayList<Num>();
		for (int i = 0; i < n; i++) {
			nums.add(new Num(in.nextInt(), in.nextInt(), i+1));
		}
		Collections.sort(nums);
		System.out.println(nums.toString().replaceAll("[\\[\\],]",  ""));
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
			if(r > obj.r) return -1;
			if(r < obj.r) return 1;
			if(index < obj.index) return -1;
			return 1;
		}
		
		public String toString() {
			return String.valueOf(index);
		}
	}
}
