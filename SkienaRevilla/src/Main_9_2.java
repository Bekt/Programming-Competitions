// Problem: Playing with Wheels
// Status: AC (on UVA)

import java.util.*;

public class Main_9_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            in.nextLine();
            String s = in.nextLine(), t = in.nextLine();
            int f = in.nextInt();
            in.nextLine();
            Set<String> forbidden = new HashSet<String>();
            for (int j = 0; j < f; j++) {
                forbidden.add(in.nextLine());
            }
            solve(s, t, forbidden);
        }
    }

    static void solve(String source, String target, Set<String> forbidden) {

        if (source.equals(target) && forbidden.contains(target)) {
            System.out.println("-1");
            return;
        }

        Queue<String> queue = new LinkedList<String>();
        Map<String, Integer> distances = new HashMap<String, Integer>();

        queue.add(source);
        distances.put(source, 0);

        while (!queue.isEmpty()) {
            String id = queue.poll();
            if (target.equals(id)) {
                System.out.println(distances.get(id));
                return;
            } else {
                addToQueue(queue, distances, forbidden, id);
            }
        }
        System.out.println("-1");
    }

    static void addToQueue(Queue<String> queue, Map<String, Integer> distances, Set<String> forbidden, String number) {
        for (int i = 0; i < 4; i++) {
            String[] upDown = getUpDown(number, i * 2);
            for (int j = 0; j < upDown.length; j++) {
                String id = upDown[j];
                if (forbidden.contains(id)) {
                    continue;
                }
                if (!distances.containsKey(id)) {
                    queue.add(id);
                    int dist = distances.get(number);
                    distances.put(id, dist + 1);
                }
            }
        }
    }

    static String[] getUpDown(String number, int index) {
        char[] ch = number.toCharArray();
        int num = ch[index] - '0';
        String fi = number.substring(0, index), la = number.substring(index + 1);

        String[] str = new String[] {
                fi + ((num + 1) % 10) + la,
                fi + (num == 0 ? 9 : num - 1) + la };
        return str;
    }

}
