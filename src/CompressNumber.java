import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CompressNumber {
    public static void main(String [] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            int a = sc.nextInt();

            int cout = 0;

            while (a > 10) {
                int lastNumber = a % 10;
                cout += lastNumber;
                a = a / 10;
            }

            cout = cout + a;

            while (cout >= 10) {
                int lastNumber = cout % 10;
                a = cout / 10;
                cout = cout * 0 + lastNumber + a;
            }

            System.out.println("#" + i + " " + cout);
        }
    }
}

//1 + 7 + 8 + 7 + 5
