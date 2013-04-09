// Using the 'sum of integers' and 'sum of squares' formulas

public class Problem6 {
	public static void main(String[] args) {
		long sumInt = (100 * 101) / 2,
			 sqSum = sumInt * sumInt,
			 sumSq = (100 * 101 * 201) / 6;
		System.out.println(sqSum - sumSq);
	}
}
