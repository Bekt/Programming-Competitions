
// Problem: Interpreter
// Status: No complete

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1_6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int t = in.nextInt();
        // in.nextInt();
        int t = 1;
        for (int i = 0; i < t; i++) {
            Main_1_6 interpreter = new Main_1_6();
            while (in.hasNext()) {
                interpreter.ram.add(in.nextLine().toCharArray());
            }
            interpreter.run();
        }
    }

    int[] register = new int[10];
    List<char[]> ram = new ArrayList<char[]>();
    int index, count;

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
                count++;
                break;
            case 3:
                processThree(two, three);
                count++;
                break;
            case 4:
                processFour(two, three);
                count++;
                break;
            case 5:
                processFive(two, three);
                count++;
                break;
            case 6:
                processSix(two, three);
                count++;
                break;
            case 7:
                processSeven(two, three);
                count++;
                break;
            case 8:
                processEight(two, three);
                count++;
                break;
            case 9:
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
    }

    void processThree(int d, int n) {
        register[d] = (register[d] + n) % 1000;
    }

    void processFour(int d, int n) {
        register[d] = (register[d] * n) % 1000;
    }

    void processFive(int d, int s) {
        register[d] = register[s];
    }

    void processSix(int d, int s) {
        register[d] = (register[d] + register[s]) % 1000;
    }

    void processSeven(int d, int s) {
        register[d] = (register[d] * register[s]) % 1000;
    }

    void processEight(int d, int a) {
        char[] c = ram.get(a);
        register[d] = charToInt(c);
     }

    void processNine(int s, int a) {
    }

    void processZero(int d, int s) {
        if (register[s] != 0) {
            index = register[d];
        }
    }

    int charToInt(char[] c) {
        return Integer.valueOf(c[0] + c[1] + c[2]);
    }
}
