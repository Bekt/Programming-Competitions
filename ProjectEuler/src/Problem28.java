public class Problem28 {
	public static void main(String[] args) {
		int sum = 1, ne = 1;
		for (int i = 1; i < 501; i++) {
			ne += (i * 8);
			int nw = ne - (i * 2),
				sw = ne - (i * 4),
				se = ne - (i * 6);
			sum += (ne + nw + sw + se);
		}
		System.out.println(sum);
	}
}
