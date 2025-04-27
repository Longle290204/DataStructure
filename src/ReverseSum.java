import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReverseSum {
    public static int reverseNumber(int n) {
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }

        return reverse;
    }

    public static void main(String[] args) throws FileNotFoundException {
        try {
            System.setIn(new FileInputStream("input.txt"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

         for(int i = 1; i <= N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();


            int result = reverseNumber(reverseNumber(a) + reverseNumber(b));

            System.out.println(result);

         }
    }
}
