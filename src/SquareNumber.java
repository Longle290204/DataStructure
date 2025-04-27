import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SquareNumber {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();


        for(int i = 1; i <= N; i++) {

            StringBuilder str = new StringBuilder();

            int a = sc.nextInt();
            int b = sc.nextInt();

            int x = 1;
            while (x * x <= b) {
                int result = x * x;
                if (result >= a) {
                    str.append(" ").append(result);
                }
                x++;
            }

            if (str.length() == 0) {
                System.out.println("#" + i + " " + "NO NUMBER");
            }
            else {
                System.out.println("#" + i + str.toString());
            }
        }
    }
}
