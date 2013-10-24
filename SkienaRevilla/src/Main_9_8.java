// Problem: Hanoi Tower Troubles Again
// Status: AC
// Note: This is a super fast solution

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_9_8 {

    static Set<Integer> squares = getSquares();
    static int[] results = init();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(results[in.nextInt() - 1]);
        }
    }

    static int[] init() {
        int[] results = new int[50];
        results[0] = 1;
        results[1] = 3;
        results[2] = 7;

        int[] pegs = new int[50];
        int number = 1;
        pegs[0] = number++;
        pegs[1] = number++;
        pegs[2] = number++;

        int count = 3, prev;
        while (count < results.length) {
            prev = number;
            for (int i = 0; i <= count; i++) {
                if (squares.contains(pegs[i] + number)) {
                    pegs[i] = number++;
                    break;
                }
                if (pegs[i] == 0) {
                    pegs[i] = number++;
                    break;
                }
            }
            if (prev == number) {
                results[count++] = number - 1;
            }
        }
        return results;
    }

    static Set<Integer> getSquares() {
        Set<Integer> squares = new HashSet<Integer>();
        for (int i = 1; i < 51; i++) {
            squares.add(i * i);
        }
        return squares;
    }

}
