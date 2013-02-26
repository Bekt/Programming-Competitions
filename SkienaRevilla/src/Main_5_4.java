import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;


public class Main_5_4 {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Main_5_4().run();
	}

	void run() {
		char[] data = new char[1000000];
		Arrays.fill(data, '1');
		String ones = String.valueOf(data);
		
		for(int j=3; j<10000; j++) {
			if((j % 2) == 0 || (j % 5) == 0)
				continue;
			
			BigInteger n = BigInteger.valueOf(j);
			BigInteger m;
			BigInteger zero = BigInteger.ZERO;

			for(int i=String.valueOf(n).length()+1; i<data.length; i++) {
				m = new BigInteger(ones.substring(0, i));
				if((m.mod(n).equals(zero))) {
					System.out.println(j + ": " + i);
					break;
				}
			}			
		}
		
	}
}
