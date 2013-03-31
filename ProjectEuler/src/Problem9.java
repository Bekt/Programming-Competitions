// Don't care about efficiency because of 500 * 500

public class Problem9 {
	public static void main(String[] args) {
		for (int a = 2; a < 500; a++) {
			for (int b = a+1; b < 500; b++) {
				int c = 1000 - a - b;
				if(c * c == (a * a + b * b)) {
					System.out.println(a * b * c);
					return;
				}
			}
		}
	}
}
