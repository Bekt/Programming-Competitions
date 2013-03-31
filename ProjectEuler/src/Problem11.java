import java.io.File;
import java.util.Scanner;
import static java.lang.Math.*;

public class Problem11 {
	static Scanner in;
	int[][] table = new int[20][20];

	public static void main(String[] args) throws Exception {
		in = new Scanner(new File("problem11.txt"));
		new Problem11().run();
	}
	
	void run() {
		init();
		System.out.println(solve());
	}
	
	int solve() {
		int product = 0;
		for (int i = 0; i < table.length-4; i++) {
			for (int j = 0; j < table.length-4; j++) {
				//Right
				product = max(product, table[i][j] * table[i][j+1] * table[i][j+2] * table[i][j+3]);

				//Down
				product = max(product, table[i][j] * table[i+1][j] * table[i+2][j] * table[i+3][j]);
				
				//Diagonals
				try {
					product = max(product, table[i][j] * table[i+1][j+1] * table[i+2][j+2] * table[i+3][j+3]);
					product = max(product, table[i][j] * table[i+1][j-1] * table[i+2][j-2] * table[i+3][j-3]);
				}
				catch (Exception e) {
					//LOL
				}
			}
		}
		return product;
	}
	
	void init() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				table[i][j] = in.nextInt();
			}
		}
	}
}
