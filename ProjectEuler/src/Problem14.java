//NOTE: Incomplete

import static java.lang.Math.*;

public class Problem14 {
	public static void main(String[] args) {
		int max = 0;
		for (int i = 10; i < 1000000; i++) {
			max = max(max, getCount(i));
		}
		System.out.println(max);
	}
	
	static int getCount(int n) {
		int count = 1, k = n;
		while(n != 1) {
			count++;
			n = n % 2 == 0 ? n / 2 : 3 * n + 1;
		}
		return count;
	}
}
