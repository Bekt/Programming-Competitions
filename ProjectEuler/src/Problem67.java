import java.io.File;
import java.util.Scanner;


public class Problem67 {
	static Scanner in;
	
	public static void main(String[] args) throws Exception {
		in = new Scanner(new File("triangle.txt"));
		new Problem67().run();
	}
	
	int[][] table = new int[100][100];
	
	void run() {
		init();
		solve();
	}
	
	void init() {
		for(int i=0; i<100; i++) {
			for(int j=0; j<=i; j++) {
				table[i][j] = in.nextInt();
			}
		}		
	}
	
	void solve() {
		long sum = 0;
	}
}
