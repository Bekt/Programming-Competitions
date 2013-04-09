import java.math.BigInteger;

public class Problem16 {
	public static void main(String[] args) {
		char[] big = new BigInteger("2").pow(1000).toString().toCharArray();
		int sum = 0;
		for (char c : big) {
			sum += c - '0';
		}
		System.out.println(sum);
	}
}
