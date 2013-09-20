import java.util.Scanner;

public class Main_5_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long n = 1, target = in.nextLong();
            boolean isStan = true;
            while ((n = (isStan = !isStan) ? n * 2 : n * 9) < target);
            System.out.println((isStan ? "Ollie" : "Stan") + " wins.");
        }
    }
}
