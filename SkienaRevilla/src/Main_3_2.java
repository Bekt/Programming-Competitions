//NOTE: Not finished

import java.util.*;

public class Main_3_2 {
	Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		new Main_3_2().run();
	}
	
	void run() {
		int t = in.nextInt();
		
		for (int i = 0; i < t; i++) {
			init(in.nextInt(), in.nextInt());
			solve(in.nextInt());
		}
	}

	void init(int m, int n) {
		String[] board = new String[m];
		in.nextLine();
		
		for (int i = 0; i < board.length; i++) {
			board[i] = in.nextLine().toLowerCase();
		}
		
		genPermutations(board);
	}
	
	void genPermutations(String[] board) {
		List<String> perm = new ArrayList<String>(Arrays.asList(board));
		
		//Horizontal reverse
		for (int i = 0; i < board.length; i++) {
			perm.add(reverse(board[i]));
		}
		
		//Vertical
		for (int i = 0; i < board[0].length(); i++) {
			StringBuilder str = new StringBuilder();
			for (int j = 0; j < board.length; j++) {
				str.append(board[j].charAt(i));
			}
			perm.add(str.toString());
		}
		
		//Vertical reverse
		reverse(perm, perm.size()-board[0].length(), perm.size());
		
		//Diagonal-1
		for (int i = 0; i < board.length; i++) {
			StringBuilder str = new StringBuilder();
			int j = i;
			while(j >= 0) {
				str.append(board[j].charAt(i-j));
				j--;
			}
			perm.add(str.toString());			
		}
		
		System.out.println(perm.toString().replace(", ","\n"));
	}
	
	String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	
	void reverse(List<String> perm, int i, int j) {
		while(i < j) {
			String word = perm.get(i++);
			perm.add(reverse(word));
		}
	}

	void solve(int k) {
		in.nextLine();
		
		for (int i = 0; i < k; i++) {
			System.out.println(in.nextLine());
		}
	}

}
