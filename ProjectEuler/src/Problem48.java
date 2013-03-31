//http://projecteuler.net/problem=48
//Status: AC

public class Problem48 {
	public static void main(String[] args) {
		new Problem48().run();
	}
	
	long MOD = 10000000000L;
	
	void run() {
		long sum = 0;
		for (int i = 1; i < 1001; i++) {
			sum = (sum + slowSelfPower(i)) % MOD;
		}
		System.out.println(sum);
	}

	long slowSelfPower(int n) {
		long ans = n;
		for (int i = 2; i <= n; i++) {
			ans = (ans * n) % MOD;
		}
		return ans;
	}
}
