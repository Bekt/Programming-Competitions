//Status: RE

import java.util.Scanner;

public class Main_7_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			int n = in.nextInt();
			if(n == 0) break;
			System.out.println(getState(n) ? "yes" : "no");
		}
	}
	
	static boolean getState(int n) {
		int i = 1;
		boolean flag = false;
		while(i <= n) {
			if(n % i == 0) {
				flag = !flag;
			}
			i++;
		}
		return flag;
	}
	
}
