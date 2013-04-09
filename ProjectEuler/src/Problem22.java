import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Problem22 {
	static Scanner in;
	String[] names;
	
	public static void main(String[] args) throws Exception {
		in = new Scanner(new File("problem22.txt"));
		new Problem22().run();
	}
	
	void run() {
		init();
		solve();
	}
	
	void solve() {
		Arrays.sort(names);
		long sum = 0;
		for (int i = 1; i <= names.length; i++) {
			sum += (i * getWorth(names[i-1]));
		}
		System.out.println(sum);
	}
	
	int getWorth(String val) {
		int count = 0;
		for (int i = 0; i < val.length(); i++) {
			count += (val.charAt(i) - 'A' + 1);
		}
		return count;
	}
	
	void init() {
		String line = in.nextLine();
		line = line.substring(1);
		line = line.substring(0, line.length()-1);		
		names = line.split("\",\"");		
	}
}
