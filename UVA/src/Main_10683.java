//Problem: 10683 - The decadary watch http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1624
//Status: WA

import java.util.Scanner;

public class Main_10683 {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Main_10683().run();
	}
	
	void run() {
		double ratio = 1.157407407407407;
		
		while(in.hasNext()) {
			String line = in.nextLine();
			int h = Integer.valueOf(line.substring(0, 2)),
				m = Integer.valueOf(line.substring(2, 4)),
				s = Integer.valueOf(line.substring(4, 6)),
				c = Integer.valueOf(line.substring(6, 8));
			
			int adjusted = (int) (calc(h, m, s, c) * ratio);
			System.out.printf("%07d%n", adjusted);
		}
	}

	int calc(int h, int m, int s, int c) {
		return (h * 60 * 60 * 100) + (m * 60 * 100) + (s * 100) + c;
	}
}
