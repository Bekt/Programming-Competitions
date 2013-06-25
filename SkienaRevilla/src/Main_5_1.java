// Status: AC

import java.util.Scanner;

public class Main_5_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long x, y;
		while ((x = in.nextLong()) + (y = in.nextLong()) > 0) {
			int count = getCount(x, y);
			String output;
			switch (count) {
				case 0:
					output = "No carry operation.";
					break;
				case 1:
					output = count + " carry operation.";
					break;
				default:
					output = count + " carry operations.";
					break;
			}
			System.out.println(output);
		}
	}

	static int getCount(long x, long y) {
		int count = 0;
		boolean isCarry = false;
		while (x > 0 || y > 0) {
			long n = (x % 10) + (y % 10) + (isCarry ? 1 : 0);
			isCarry = n > 9;
			count += isCarry ? 1 : 0;
			x /= 10;
			y /= 10;
		}
		return count;
	}

}
