
// Problem: Interpreter
// Status: RE

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1_6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            Main_1_6 interpreter = new Main_1_6();
            while (in.hasNext()) {
                String line = in.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                interpreter.ram.add(line.toCharArray());
            }
            interpreter.run();
            if (i < t - 1) {
                System.out.println();
            }
        }
    }

    int[] register = new int[10];
    List<char[]> ram = new ArrayList<char[]>();
    int index, count;
    final int MOD = 1000;

    void run() {
        while (ram.get(index)[0] != '1' && index < ram.size()) {
            process(ram.get(index++));
        }
        System.out.println(++count);
    }

    void process(char[] c) {
        int one = c[0] - '0', two = c[1] - '0', three = c[2] - '0';
        switch (one) {
            case 2:
                processTwo(two, three);
                break;
            case 3:
                processThree(two, three);
                break;
            case 4:
                processFour(two, three);
                break;
            case 5:
                processFive(two, three);
                break;
            case 6:
                processSix(two, three);
                break;
            case 7:
                processSeven(two, three);
                break;
            case 8:
                processEight(two, three);
                break;
            case 9:
                processNine(two, three);
                break;
            case 0:
                if (two != 0 && three != 0) {
                    processZero(two, three);
                }
                break;
        }
    }

    void processTwo(int d, int n) {
        register[d] = n;
        count++;
    }

    void processThree(int d, int n) {
        register[d] = (register[d] + n) % MOD;
        count++;
    }

    void processFour(int d, int n) {
        register[d] = (register[d] * n) % MOD;
        count++;
    }

    void processFive(int d, int s) {
        register[d] = register[s];
        count++;
    }

    void processSix(int d, int s) {
        register[d] = (register[d] + register[s]) % MOD;
        count++;
    }

    void processSeven(int d, int s) {
        register[d] = (register[d] * register[s]) % MOD;
        count++;
    }

    void processEight(int d, int a) {
        char[] c = ram.get(register[a]);
        register[d] = charToInt(c);
        count++;
    }

    void processNine(int s, int a) {
        ram.set(register[a], intToChar(register[s]));
    }

    void processZero(int d, int s) {
        if (register[s] != 0) {
            index = register[d];
        }
        count++;
    }

    static int charToInt(char[] c) {
        return Integer.valueOf("" + c[0] + c[1] + c[2]);
    }

    static char[] intToChar(int n) {
        char[] c = new char[] { '0', '0', '0' };
        if (n < 10) {
            c[2] = (char) (n + '0');
        } else if (n < 100) {
            c[1] = (char) (n / 10 + '0');
            c[2] = (char) ((n % 10) + '0');
        } else if (n < 1000) {
            c[0] = (char) (n / 100 + '0');
            n = n % 100;
            c[1] = (char) (n / 10 + '0');
            c[2] = (char) ((n % 10) + '0');
        }
        return c;
    }
}
