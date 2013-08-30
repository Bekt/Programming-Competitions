// Problem: Australian Voting, 10142
// Status: AC

import java.util.*;
import static java.lang.Math.min;

public class Main_1_8_10142 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        in.nextLine();
        in.nextLine();

        for (int i = 0; i < t; i++) {
            getInput();
            if (i < t - 1) {
                System.out.println();
            }
        }
    }

    static void getInput() {
        Main_1_8_10142 voter = new Main_1_8_10142();

        int n = in.nextInt();
        String line = in.nextLine();

        voter.names = new String[n + 1];
        for (int j = 1; j <= n; j++) {
            voter.names[j] = in.nextLine();
            voter.votesCount.put(j, 0);
        }

        while (in.hasNext() && !(line = in.nextLine()).isEmpty()) {
            Queue<Integer> prefs = new LinkedList<Integer>();
            voter.votes.add(prefs);

            String[] nums = line.trim().replaceAll("\\s+", " ").split(" ");
            for (int k = 0; k < nums.length; k++) {
                prefs.add(Integer.valueOf(nums[k]));
            }
        }
        voter.solve();
    }

    String[] names;
    Map<Integer, Integer> votesCount = new HashMap<Integer, Integer>();
    List<Queue<Integer>> votes = new ArrayList<Queue<Integer>>();

    void solve() {
        for (Queue<Integer> prefs : votes) {
            vote(prefs);
        }
        while (!isWinTie()) {
            Set<Integer> removed = removeMins();
            revote(removed);
        }
    }

    boolean isWinTie() {
        int winner = getWinner();
        if (winner > 0) {
            System.out.println(names[winner]);
            return true;
        }
        if (isTie()) {
            for (int i = 1; i <= names.length; i++) {
                if (votesCount.get(i) != null) {
                    System.out.println(names[i]);
                }
            }
            return true;
        }
        return false;
    }

    void revote(Set<Integer> removed) {
        for (Queue<Integer> prefs : votes) {
            if (!removed.contains(prefs.peek())) {
                continue;
            }
            prefs.poll();
            vote(prefs);
        }
    }

    void vote(Queue<Integer> prefs) {
        while (!prefs.isEmpty()) {
            int choice = prefs.peek();
            Integer cand = votesCount.get(choice);
            if (cand != null) {
                votesCount.put(choice, cand + 1);
                break;
            }
            prefs.poll();
        }
    }

    int getWinner() {
        final double FIDDY  = votes.size() * 0.5;
        Set<Integer> keySet = votesCount.keySet();
        for (Integer key : keySet) {
            Integer cand = votesCount.get(key);
            if (cand > FIDDY) {
                return key;
            }
        }
        return -1;
    }

    boolean isTie() {
        boolean first = true;
        int val = 0;
        Set<Integer> keySet = votesCount.keySet();
        for (Integer key : keySet) {
            Integer cand = votesCount.get(key);
            if (first) {
                first = false;
                val = cand;
                continue;
            }
            if (val != cand) {
                return false;
            }
        }
        return true;
    }

    Set<Integer> removeMins() {
        int min = Integer.MAX_VALUE;
        Set<Integer> removed = new HashSet<Integer>();
        Set<Integer> keySet = votesCount.keySet();
        for (Integer key : keySet) {
            min = min(min, votesCount.get(key));
        }

        Iterator<Map.Entry<Integer, Integer>> it = votesCount.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            int cand = entry.getValue();
            if (cand == min) {
                removed.add(entry.getKey());
                it.remove();
            }
        }
        return removed;
    }
}
