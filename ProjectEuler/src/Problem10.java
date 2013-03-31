
public class Problem10 {
	public static void main(String[] args) {
		long sum = 2;
		for (int i = 3; i < 2000000; i += 2) {
			sum += isPrime(i) ? i : 0;
		}
		System.out.println(sum);
	}
	
	static boolean isPrime(int n) {
		if(n == 2 || n == 3)
			return true;
		if(n % 2 == 0 || n % 3 == 0)
			return false;
		
		int i = 5, w = 2;
		while(i * i <= n) {
			if(n % i == 0) {
				return false;
			}
			i += w;
			w = 6 - w;
		}
		return true;
	}	
}
