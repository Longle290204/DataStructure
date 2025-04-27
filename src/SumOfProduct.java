import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumOfProduct {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int MOD = 1_000_007;
        for (int t = 1; t <= T; t++) {
            int a = sc.nextInt();
            long result = 0;

            int j = 1;
            while (j <= a) {
                int y = a / j;
                int last = a / y;

                long count = last - j + 1;
                long sumJ = (j + last) * count / 2;

                result = (result + (sumJ % MOD) * y % MOD) % MOD;

                j = last + 1;
            }

            System.out.println(result);
        }
    }
}
