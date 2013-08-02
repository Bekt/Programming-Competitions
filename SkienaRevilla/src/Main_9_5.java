//Status: TLE

import static java.lang.Math.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main_9_5 {
	static Scanner in = new Scanner(System.in);
	static List<String> words = new ArrayList<String>();
	static Map<String, Integer> count = new HashMap<String, Integer>();
	static int max = 0;
	
	public static void main(String[] args) {
		while(in.hasNext()) {
			solve(in.nextLine());
		}
		System.out.println(max);
	}
	
	static void solve(String word) {
		int c = 0;
		
		for (int i = 0; i < words.size(); i++) {
			String curr = words.get(i);
			
			if(isEditStep(word, curr)) {
				c = max(c, get(count, curr));
			}
		}
		
		words.add(word);
		count.put(word, c + 1);
		max = max(max, c + 1);
	}
	
	static boolean isEditStep(String a, String b) {
		int sizeA = a.length();
		int sizeB = b.length();
		
		if(abs(sizeA - sizeB) > 1) {
			return false;
		}

		if(sizeA == sizeB) {
			boolean flag = false;
			for (int i = 0; i < sizeA; i++) {
				char ai = a.charAt(i);
				char bi = b.charAt(i);
				
				if(ai != bi && flag) {
					return false;
				}
				if(ai != bi) {
					flag = true;
				}				
			}
			
			return true;
		}
		
		if(sizeB < sizeA) {
			String t = b;
			b = a;
			a = t;
			sizeA = a.length();
			sizeB = b.length();
		}
		
		int i = 0, j = 0;
		boolean flag = false;
		while(i < sizeA && j < sizeB) {
			char ai = a.charAt(i);
			char bi = b.charAt(i);

			if(ai != bi && flag) {
				return false;
			}
			if(ai != bi) {
				flag = true;
				j++;
			}
			else {
				i++;
				j++;				
			}
		}
		
		return true;
	}
	
	static int get(Map<String, Integer> map, String key) {
		Integer val = map.get(key);
		return val == null ? 0 : val;
	}

}
