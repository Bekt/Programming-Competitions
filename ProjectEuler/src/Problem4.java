import static java.lang.Math.*;

public class Problem4 {
	public static void main(String[] args) {
		int max = 0;
		for(int i=100; i<1000; i++) {
			for(int j=100; j<1000; j++) {
				if(isPalin(i*j))
					max = max(i*j, max);
			}
		}
		System.out.println(max);
	}

	static boolean isPalin(int n) {
		char[] val = String.valueOf(n).toCharArray();
		int size = val.length / 2, j = val.length - 1;
		for(int i=0; i<size; i++) {
			if(val[i] != val[j--])
				return false;
		}
		return true;
	}
}
