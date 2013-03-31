//NOTE: Incorrect

public class Problem27 {
	public static void main(String[] args) {
		int max = 0, a = 0, b = 0;
		for (int i = -1000; i < 1000; i++) {
			for (int j = -1000; j < 1000; j++) {
				int n = 0, count = 0;
				while (isPrime((n * n) + (i * n) + j)) {
					count++;
					n++;
				}
				if(count > max) {
					max = count;
					a = i;
					b = j;
				}
			}
		}
		System.out.println(a * b);
	}
	
	static boolean isPrime(int n) {
		if(n == 2 || n == 3)
			return true;
		if(n % 2 == 0 || n % 3 == 0)
			return false;
		
		int i = 5, w = 2;
		while(i * i <= n) {
			if(n % i == 0)
				return false;
			
			i += w;
			w = 6 - w;
		}

		return true;
	}
}
