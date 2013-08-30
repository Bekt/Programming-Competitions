// Problem: WERTYU
// Status: AC

import java.util.Scanner;

public class Main_3_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String values = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
        while (in.hasNext()) {
            char[] line = in.nextLine().toCharArray();
            for (int i = 0; i < line.length; i++) {
                System.out.print(line[i] == ' ' ? ' ' : values.charAt(values.indexOf(line[i]) - 1));
            }
            System.out.println();
        }
    }
}
