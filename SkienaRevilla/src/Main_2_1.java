//Status: AC
//http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=979

import java.util.Scanner;
import static java.lang.Math.abs;

public class Main_2_1 {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		while (in.hasNext()) {
			System.out.println(solve(in.nextInt()));
		}
	}

	static String solve(int n) {
		if(n == 1) {
			in.nextInt();
			return "Jolly";
		}
		
		boolean[] values = new boolean[n];
		int f, s = in.nextInt();
		
		for(int i=1; i<n; i++) {
			f = s;
			s = in.nextInt();
			int diff = abs(s - f);
			values[diff > values.length-1 ? 0 : diff] = true;
		}
		
		for(int i=1; i<n; i++) {
			if(!values[i]) {
				return "Not jolly";
			}
		}			
		return "Jolly";
	}	
}