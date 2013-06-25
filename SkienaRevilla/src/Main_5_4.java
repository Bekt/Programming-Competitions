//Status: AC

import java.util.Scanner;

public class Main_5_4 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] data = new int[10001];
		
		for (int i = 1; i < data.length; i++) {
			if((i % 2) == 0 || (i % 5) == 0) continue;
			data[i] = getCount(i);
		}
		
		while(in.hasNextInt()) {
			System.out.println(data[in.nextInt()]);
		}
	}
	
	static int getCount(int n) {
		int curr = 1, count = 1;
		while((curr % n) != 0) {
			curr = (curr * 10 + 1) % n;
			count++;
		}
		return count;
	}
}
