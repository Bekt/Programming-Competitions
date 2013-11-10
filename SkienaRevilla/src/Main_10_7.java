import java.util.*;

public class Main_10_7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        List<Integer> source = new ArrayList<Integer>();
        List<Integer> sink = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            source.add(in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            sink.add(in.nextInt());
        }
        solve(source, sink);
    }

    static void solve(List<Integer> source, List<Integer> sink) {

    }

}
