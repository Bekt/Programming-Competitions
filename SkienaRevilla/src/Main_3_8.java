//Chapter 3: 3.8.1 WERTYU http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=31&page=show_problem&problem=1023
//Status: AC

import java.util.*;

public class Main_3_8 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String values = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		while(in.hasNext()) {
			char[] line = in.nextLine().toCharArray();
			for (int i=0; i<line.length; i++) {
				System.out.print(line[i] == ' ' ? ' ' : values.charAt(values.indexOf(line[i])-1));				
			}
			System.out.println();
		}
	}
}
