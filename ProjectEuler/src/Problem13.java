import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class Problem13 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("problem13.txt"));
		BigInteger sum = BigInteger.ZERO;		
		for(int i=0; i<100; sum = sum.add(new BigInteger(in.nextLine())), i++);
		System.out.println(sum.toString().substring(0, 10));
	}
}
