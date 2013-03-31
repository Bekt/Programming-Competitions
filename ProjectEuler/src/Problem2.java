public class Problem2 {
	public static void main(String[] args) {
		int n1 = 1, n2 = 2, sum = 2;
		while(n2 <= 4000000) {
			int temp = n1;
			n1 = n2;
			n2 = temp + n2;
			sum += n2 % 2 == 0 ? n2 : 0; 
		}
		System.out.println(sum);
	}
}
