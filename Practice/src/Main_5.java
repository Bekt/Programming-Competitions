import java.util.Arrays;
import java.util.Scanner;

public class Main_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            in.nextLine();
            String[] words = new String[n];
            for (int i = 0; i < n; words[i++] = in.nextLine());
            String s = in.nextLine();
            String r = new StringBuilder(s).reverse().toString();
            Arrays.sort(words);
            for (int i = 0; i < n; i++) {
                String w = words[i];
                if (s.indexOf(w) >= 0 || r.indexOf(w) >= 0) {
                    System.out.println(w);
                }
            }
        }
    }

}
