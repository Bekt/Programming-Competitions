
public class Problem7 {
	public static void main(String[] args) {
		int n = 3, count = 2;
		while(count < 10001) {
			n += 2;
			if(isPrime(n))
				count++;
		}
		System.out.println(n);
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
