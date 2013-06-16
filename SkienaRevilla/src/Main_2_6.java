//Status: WA

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static java.lang.Math.min;

public class Main_2_6 {
	Scanner in = new Scanner(System.in);
	Map<String, Integer> count;
	static final String ERDOS = "Erdos, P.";
	
	public static void main(String[] args) {
		new Main_2_6().run();
	}
	
	void run() {
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println("Scenario " + (i+1));
			int p = in.nextInt(), n = in.nextInt();
			solve(p, n);
			print(n);
		}
	}
	
	void solve(int p, int n) {
		in.nextLine();

		count = new HashMap<String, Integer>();
		count.put(ERDOS, 0);
		
		for (int i = 0; i < p; i++) {
			String line = in.nextLine();
			String[] splitByColon = line.split(":");
			String[] splitByComma = splitByColon[0].split(", ");

			List<String> names = new ArrayList<String>();
			for (int j = 0; j < splitByComma.length-1; j = j+2) {
				names.add(splitByComma[j] + ", " + splitByComma[j+1]);
			}
			//System.out.println(names);
			processLine(names.toArray(new String[names.size()]));
		}
	}
	
	void print(int n) {
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			Integer rank = count.get(name);
			System.out.printf("%s %s%n", name, rank == null ? "infinity" : rank);
		}		
	}
	
	void processLine(String[] names) {
		if(isCoErdos(names)) {
			coErdos(names);
		}
		else if(isRelated(names)) {
			related(names);
		}
	}
	
	boolean isCoErdos(String[] names) {
		for (int i = 0; i < names.length; i++) {
			if(names[i].equals(ERDOS)) {
				return true;
			}
		}
		return false;
	}
	
	boolean isRelated(String[] names) {
		for (int i = 0; i < names.length; i++) {
			if(count.get(names[i]) != null) {
				return true;
			}
		}
		return false;
	}
	
	int getLowestRank(String[] names) {
		int lowest = Integer.MAX_VALUE;
		for (int i = 0; i < names.length; i++) {
			Integer val = count.get(names[i]);
			if(val != null) {
				lowest = min(val, lowest);
			}
		}
		return lowest;
	}
	
	void coErdos(String[] names) {
		for (int i = 0; i < names.length; i++) {
			if(!names[i].equals(ERDOS)) {
				count.put(names[i], 1);
			}
		}
	}
	
	void related(String[] names) {
		int lowest = getLowestRank(names);
		for (int i = 0; i < names.length; i++) {
			if(count.get(names[i]) == null) {
				count.put(names[i], lowest+1);
			}
		}
	}
}
