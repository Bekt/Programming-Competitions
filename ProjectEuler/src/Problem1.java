public class Problem1 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i<1000; sum += (i%3 == 0 || i%5 == 0) ? i : 0, i++);
		System.out.println(sum);
	}
}
