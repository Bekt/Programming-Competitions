import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Decimal\t Hex \t\tBinary");
		System.out.println("-------\t------\t\t-----");

		for(int i=-256; i<257; i++) {
			System.out.print(i + "\t");
			System.out.print(Integer.toHexString(i) + "\t");
			System.out.println(Integer.toBinaryString(i));
		}
	}
}
