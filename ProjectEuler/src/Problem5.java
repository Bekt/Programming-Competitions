public class Problem5 {
	public static void main(String[] args) {
		long n = 1000000;
		while(!divBy(n += 20));
		System.out.println(n);
	}

	static boolean divBy(long n) {
		for(int i=20; i>= 1; i--) {
			if(n % i != 0)
				return false;
		}
		return true;
	}
}
