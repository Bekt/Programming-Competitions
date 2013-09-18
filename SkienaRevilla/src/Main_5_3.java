import java.math.BigInteger;
import java.util.Scanner;

public class Main_5_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            solve(in.nextLine());
        }
    }

    static void solve(String target) {
        BigInteger num = BigInteger.ONE;
        int count = 1, targetLength = 2 * target.length();
        boolean flag = true;
        while (flag) {
            String str = (num = num.shiftLeft(1)).toString();
            if (str.length() > targetLength && str.startsWith(target)) {
                break;
            }
            count++;
            flag = count > 1000 ? false : true;
        }
        System.out.println(flag ? count : "no power of 2");
    }

}
