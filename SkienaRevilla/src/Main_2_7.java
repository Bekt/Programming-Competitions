// Problem: Contest Scoreboard
// Status: AC

import java.util.*;

public class Main_2_7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            Main_2_7 contest = new Main_2_7();

            String line;
            while (in.hasNext() && !(line = in.nextLine()).isEmpty()) {
                String[] sp = line.split(" ");

                int c = Integer.valueOf(sp[0]),
                    p = Integer.valueOf(sp[1]),
                    t = Integer.valueOf(sp[2]);
                char s = sp[3].charAt(0);

                contest.process(c, p, t, s);
            }
            contest.print();
            if (i < n - 1) {
                System.out.println();
            }
        }
    }

    Map<Integer, Contestant> board = new HashMap<Integer, Contestant>();

    void process(int c, int p, int t, char s) {
        Contestant con = board.get(c);
        if (con == null) {
            con = new Contestant(c);
            board.put(c, con);
        }
        if (s == 'I') {
            con.problemIncorrect(p);
        } else if (s == 'C') {
            con.problemCorrect(p, t);
        }
    }

    void print() {
        List<Contestant> cons = new ArrayList<Contestant>(board.values());
        Collections.sort(cons);

        for (Contestant c : cons) {
            System.out.println(c);
        }
    }

    class Contestant implements Comparable {
        Map<Integer, Integer> problemsIncorrect = new HashMap<Integer, Integer>();
        Set<Integer> problemsSolved = new HashSet<Integer>();
        int id, totalTime = 0;

        public Contestant(int id) {
            this.id = id;
        }

        public void problemIncorrect(int problem) {
            int value = getIncorrect(problem);
            problemsIncorrect.put(problem, value + 1);
        }

        public void problemCorrect(int problem, int time) {
            if (!problemsSolved.contains(problem)) {
                problemsSolved.add(problem);
                int attempts = getIncorrect(problem);
                totalTime += time + (attempts * 20);
            }
        }

        public int getIncorrect(int problem) {
            Integer value = problemsIncorrect.get(problem);
            return value == null ? 0 : value;
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
            if (getProblemsSolved() > obj.getProblemsSolved())
                return -1;
            if (getProblemsSolved() < obj.getProblemsSolved())
                return 1;
            if (totalTime > obj.totalTime)
                return -1;
            if (totalTime < obj.totalTime)
                return 1;
            if (id < obj.id)
                return -1;
            if (id > obj.id)
                return 1;

            return 0;
        }
    }
}
