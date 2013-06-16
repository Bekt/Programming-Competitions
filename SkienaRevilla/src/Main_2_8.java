//Status: RE

import java.util.*;

public class Main_2_8 {
	Scanner in = new Scanner(System.in);
	Map<Integer, Contestant> board;
	
	public static void main(String[] args) {
		new Main_2_8().run();
	}
	
	void run() {
		int t = in.nextInt();
		in.nextLine();
		in.nextLine();
		
		for (int i = 0; i < t; i++) {
			solve();
			print();
		}
	}
	
	void solve() {
		board = new HashMap<Integer, Contestant>();
		String line;
		
		while(!(line = in.nextLine()).isEmpty()) {
			String[] sp = line.split(" ");
			int c = Integer.valueOf(sp[0]),
				p = Integer.valueOf(sp[1]),
				t = Integer.valueOf(sp[2]);
			char s = sp[3].charAt(0);
			
			process(c, p, t, s);
		}
	}
	
	void print() {
		List<Contestant> cons = new ArrayList<Contestant>();
		
		Set<Integer> key = board.keySet();
		for (Integer k : key) {
			cons.add(board.get(k));
		}
		
		Collections.sort(cons);
		
		for (Contestant c : cons) {
			System.out.println(c);
		}
		System.out.println();
	}
	
	void process(int c, int p, int t, char s) {
		Contestant con = board.get(c);
		if(con == null) {
			con = new Contestant(c);
			board.put(c, con);
		}
		
		switch (s) {
			case 'I':
				con.problemIncorrect(p);
				break;
			case 'C':
				con.problemCorrect(p, t);
				break;
		}
	}
	
	public class Contestant implements Comparable { 
		Map<Integer, Integer> problemsIncorrect = new HashMap<Integer, Integer>();
		Set<Integer> problemsSolved = new HashSet<>();
		int totalTime = 0;
		int id;
		
		public Contestant(int id) {
			this.id = id;
		}
		
		public void problemIncorrect(int problem) {
			int value = getIncorrect(problem);
			problemsIncorrect.put(problem, value+1);
		}
		
		public void problemCorrect(int problem, int time) {
			if(!problemsSolved.contains(problem)) {
				problemsSolved.add(problem);
				int incorrect = getIncorrect(problem);
				totalTime += time + (incorrect * 20);
			}
		}
		
		public int getIncorrect(int problem) {
			Integer value = problemsIncorrect.get(problem);
			value = value == null ? 0 : value;
			return value;
		}
		
		public int getProblemsSolved() {
			return problemsSolved.size();
		}
		
		
		public String toString() {
			return String.format("%d %d %d", id, getProblemsSolved(), totalTime);
		}

		@Override
		public int compareTo(Object o) {
			Contestant obj = (Contestant) o;
			if(getProblemsSolved() > obj.getProblemsSolved())
				return -1;
			if(getProblemsSolved() < obj.getProblemsSolved())
				return 1;
			if(totalTime > obj.totalTime)
				return -1;
			if(totalTime < obj.totalTime)
				return 1;
			if(id < obj.id)
				return -1;
			if(id > obj.id)
				return 1;
			
			return 0;
		}
	}
}
