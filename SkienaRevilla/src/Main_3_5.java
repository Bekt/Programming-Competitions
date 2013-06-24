//Status: AC

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_3_5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, m, count = 0;
		while ((n = in.nextInt()) != 0) {
			in.nextLine();
			List<String> orig = new ArrayList<String>();
			List<String> ans = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				orig.add(in.nextLine());
			}
			m = in.nextInt();
			in.nextLine();
			for (int i = 0; i < m; i++) {
				ans.add(in.nextLine());
			}
			System.out.printf("Run #%d: %s%n", ++count, solve(orig, ans));
		}
	}

	static String solve(List<String> orig, List<String> ans) {
		String[] res = {"Accepted", "Presentation Error", "Wrong Answer"};

		if(isAccepted(orig, ans)) {
			return res[0];
		}
		if(isPE(orig, ans)) {
			return res[1];
		}
		return res[2];
	}

	static boolean isAccepted(List<String> orig, List<String> ans) {
		if (orig.size() != ans.size()) {
			return false;
		}
		return orig.toString().equals(ans.toString());
	}
	
	static boolean isPE(List<String> orig, List<String> ans) {
		String origNumer = orig.toString().replaceAll("[^\\d]", "");
		String ansNumer = ans.toString().replaceAll("[^\\d]", "");
		return origNumer.equals(ansNumer);
	}
}
