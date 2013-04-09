public class Problem30 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 5; i < 1000000; i++) {
			int n = i;
			int a = n % 10; n /= 10;
			int b = n % 10; n /= 10;
			int c = n % 10; n /= 10;
			int d = n % 10; n /= 10;
			int e = n % 10; n /= 10;
			if(i == (pow5(a) + pow5(b) + pow5(c) + pow5(d) +  pow5(e) + pow5(n))) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
	static int pow5(int n) {
		return n * n * n * n * n;
	}
}
